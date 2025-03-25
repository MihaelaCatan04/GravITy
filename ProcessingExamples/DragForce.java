import processing.core.PApplet;
import processing.core.PVector;

public class DragForce extends PApplet {
    Mover[] movers = new Mover[9];
    Liquid liquid;
    float dragCoefficient = 0.1F;

    public static void main(String[] args) {
        PApplet.main("DragForce");
    }

    public void settings() {
        size(600, 600);
    }
    public void setup() {
        size(600, 600);
        reset();
        liquid = new Liquid(0, (float) height /2, width, (float) height /2, dragCoefficient, 137, 207, 240);
    }

    public void draw() {
        background(255);

        liquid.display();

        for (int i = 0; i < movers.length; i++) {
            if (liquid.contains(movers[i])) {
                PVector dragForce = liquid.drag(movers[i]);
                movers[i].applyForce(dragForce);
            }

            PVector gravity = new PVector((float) 0, (float) (0.1 * movers[i].mass));
            movers[i].applyForce(gravity);
            movers[i].update();
            movers[i].display();
            movers[i].checkEdges();
        }
        drawHUD();
        fill(0);
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 150, 10);

        fill(255);
        textSize(14);
        text("Liquid Simulator", 20, 30);

        textSize(12);
        text("Drag Coefficient: " + dragCoefficient, 20, 50);
        text("Number of Movers: " + movers.length, 20, 65);

        text("Click to Reset", 20, 130);
    }
    class Liquid {

        // Liquid is a rectangle
        float x, y, w, h;
        // Coefficient of drag
        float c;
        int[] fillColor;

        Liquid(float x_, float y_, float w_, float h_, float c_, int rC, int gC, int bC) {
            x = x_;
            y = y_;
            w = w_;
            h = h_;
            c = c_;
            fillColor = new int[]{rC, gC, bC};
        }

        // Is the Mover in the Liquid?
        boolean contains(Mover m) {
            PVector l = m.position;
            return l.x > x && l.x < x + w && l.y > y && l.y < y + h;
        }

        // Calculate drag force
        PVector drag(Mover m) {
            // Magnitude is coefficient * speed squared
            float speed = m.velocity.mag();
            float dragMagnitude = c * speed * speed;

            // Direction is inverse of velocity
            PVector dragForce = m.velocity.get();
            dragForce.mult(-1);

            // Scale according to magnitude
            dragForce.normalize();
            dragForce.mult(dragMagnitude);
            return dragForce;
        }

        void display() {
            noStroke();
            fill(fillColor[0], fillColor[1], fillColor[2]);
            rect(x, y, w, h);
        }
    }
    public void mousePressed() {
        reset();
    }
    class Mover {

        // position, velocity, and acceleration
        PVector position;
        PVector velocity;
        PVector acceleration;

        // Mass is tied to size
        float mass;
        float bounce = 1.0F;
        int[] fillColor;

        Mover(float m, float x, float y, int rC, int gC, int bC) {
            mass = m;
            position = new PVector(x-10, y);
            velocity = new PVector(0, 0);
            acceleration = new PVector(0, 0);
            fillColor = new int[]{rC, gC, bC};
        }

        // Newton's 2nd law: F = M * A
        // or A = F / M
        void applyForce(PVector force) {
            // Divide by mass
            PVector f = PVector.div(force, mass);
            // Accumulate all forces in acceleration
            acceleration.add(f);
        }

        void update() {

            // Velocity changes according to acceleration
            velocity.add(acceleration);
            // position changes by velocity
            position.add(velocity);
            // We must clear acceleration each frame
            acceleration.mult(0);
        }

        // Draw Mover
        void display() {
            stroke(0);
            strokeWeight(2);
            fill(fillColor[0], fillColor[1], fillColor[2]);
            ellipse(position.x, position.y, mass*16, mass*16);
        }

        // Bounce off bottom of window
        void checkEdges() {
            if (position.y > height) {
                velocity.y *= (float) -0.9;  // A little dampening when hitting the bottom
                position.y = height;
            }
        }
    }
    void reset() {
        for (int i = 0; i < movers.length; i++) {
            movers[i] = new Mover(random(0.5F, 3), 40 + i * 70, 0, 0, 163, 108);
        }
    }


}
