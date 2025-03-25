import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class ElectrostaticField extends PApplet {
    int RAD = 100;
    float e0 = 8.854187e-12F;
    ArrayList<Particle> particles = new ArrayList<>();
    ArrayList<ArrayList<PVector>> fluxLines = new ArrayList<>();
    Particle selected = null;
    boolean dragging = false;
    int fluxResolution = 10;
    public static void main(String[] args) {
        PApplet.main("ElectrostaticField");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        particles.add(new Particle((float) (width / 3), (float) (height / 2), 1.602176e-19F));
        particles.add(new Particle((float) (2 * width / 3), (float) (height / 2), (float) -1.602176e-19));
        generateFluxLines();
    }

    public void draw() {
        background(0);
        drawField();
        drawFluxLines();

        for (Particle p : particles) {
            p.display();
        }

        drawHUD();
    }
    void drawField() {
        int resolution = 50;
        for (int i = resolution; i < width; i += resolution) {
            for (int j = resolution; j < height; j += resolution) {
                PVector pos = new PVector(i, j);
                PVector e = E(pos).mult(1e15F);
                float len = constrain(e.mag(), 6, 15);
                e.setMag(len);

                stroke(200, 255, 255, 100);
                line(i, j, i + e.x, j + e.y);
            }
        }
    }
    void drawFluxLines() {
        for (ArrayList<PVector> line : fluxLines) {
            if (line.size() < 300) {  // Max length of flux line
                PVector current = line.get(line.size() - 1);
                PVector e = E(current).mult(1e15F);
                float len = constrain(e.mag(), 3, 10);
                e.setMag(len);

                PVector next = PVector.add(current, e);
                if (isInside(next) && !isNearNegativeCharge(next)) {
                    line.add(next);
                }
            }

            noFill();
            stroke(255, 204, 0, 150);
            beginShape();
            for (PVector p : line) {
                vertex(p.x, p.y);
            }
            endShape();
        }
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 110, 10);

        fill(255);
        textSize(14);
        text("Electric Field Simulator", 20, 30);

        textSize(12);
        text("Press '+' to add a positive charge", 20, 50);
        text("Press '-' to add a negative charge", 20, 65);
        text("Press '0' to remove last charge", 20, 80);
        text("Drag charges to move them", 20, 95);
        text("Total Particles: " + particles.size(), 20, 110);
    }
    PVector E(PVector pos) {
        PVector result = new PVector(0, 0);
        for (Particle p : particles) {
            PVector r = PVector.sub(pos, p.pos);
            float rMag = r.mag();
            if (rMag > RAD / 2) {
                r.normalize();
                r.mult((float) (p.charge / (rMag * rMag)));
                result.add(r);
            }
        }
        return result.div((float) (4 * PI * e0));
    }
    void generateFluxLines() {
        fluxLines.clear();

        for (Particle p : particles) {
            if (p.charge > 0) {
                float angleStep = TWO_PI / fluxResolution;
                for (int i = 0; i < fluxResolution; i++) {
                    ArrayList<PVector> line = new ArrayList<>();
                    PVector start = PVector.fromAngle(angleStep * i).mult(RAD / 2).add(p.pos);
                    line.add(start);
                    fluxLines.add(line);
                }
            }
        }
    }
    boolean isNearNegativeCharge(PVector pos) {
        for (Particle p : particles) {
            if (p.charge < 0 && PVector.dist(pos, p.pos) < RAD / 2) {
                return true;
            }
        }
        return false;
    }

    boolean isInside(PVector pos) {
        return pos.x > 0 && pos.x < width && pos.y > 0 && pos.y < height;
    }
    public void keyPressed() {
        if (key == '+') {
            particles.add(new Particle(random(width), random(height), 1.602176e-19F));
            generateFluxLines();
        } else if (key == '-') {
            particles.add(new Particle(random(width), random(height), (float) -1.602176e-19));
            generateFluxLines();
        } else if (key == '0') {
            if (!particles.isEmpty()) {
                particles.removeLast();
                generateFluxLines();
            }
        }
    }
    public void mouseDragged() {
        if (dragging && selected != null) {
            selected.pos.set(mouseX, mouseY);
            generateFluxLines();  // Regenerate flux lines during dragging
        }
    }
    public void mousePressed() {
        for (Particle p : particles) {
            if (p.isMouseOver(mouseX, mouseY)) {
                selected = p;
                dragging = true;
                break;
            }
        }
    }
    public void mouseReleased() {
        dragging = false;
        selected = null;
    }
    class Particle {
        PVector pos;
        float charge;

        Particle(float x, float y, float q) {
            pos = new PVector(x, y);
            charge = q;
        }

        void display() {
            noStroke();
            if (charge > 0) {
                fill(255, 0, 0);
            } else {
                fill(0, 0, 255);
            }
            ellipse(pos.x, pos.y, RAD, RAD);
        }

        boolean isMouseOver(float mx, float my) {
            return dist(mx, my, pos.x, pos.y) < (float) RAD / 2;
        }
    }


}
