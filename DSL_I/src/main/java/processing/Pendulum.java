package processing;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Pendulum extends PApplet {

    // Parameters received from main
    float r;
    float angle;
    float angleV;
    float angleA;
    float g = 9.8F;
    float damping;
    float ballRadius;

    PVector origin;
    PVector bob;

    ArrayList<PVector> trail = new ArrayList<>();
    int maxTrail = 100;

    boolean dragging = false;
    boolean running = true;

    // Static method to run simulation with given parameters
    public static void runPendulum(float length, float ballRadius, float initialAngle,
                                   float angularVelocity, float angularAcceleration, float airResistance) {
        Pendulum instance = new Pendulum();
        instance.r = length;
        instance.ballRadius = ballRadius;
        instance.angle = initialAngle;
        instance.angleV = angularVelocity;
        instance.angleA = angularAcceleration;
        instance.damping = 1.0f - airResistance;

        PApplet.runSketch(new String[]{"Pendulum"}, instance);
    }


    public void settings() {
        size(600, 600);
    }

    public void setup() {
        origin = new PVector((float) width /2, 100);
        bob = new PVector();
        strokeWeight(2);
        updateBobPosition();
    }

    public void draw() {
        background(240);

        if (dragging) {
            PVector mouse = new PVector(mouseX, mouseY);
            PVector dir = PVector.sub(mouse, origin);

            dir.setMag(r);
            bob.x = origin.x + dir.x;
            bob.y = origin.y + dir.y;

            angle = atan2(dir.x, dir.y);

            trail.clear();

            stroke(200, 0, 0, 100);
            line(origin.x, origin.y, mouseX, mouseY);
        } else if (running) {
            angleA = -g / r * sin(angle);
            angleV += angleA;
            angleV *= damping;
            angle += angleV;

            updateBobPosition();

            trail.add(new PVector(bob.x, bob.y));
            if (trail.size() > maxTrail) {
                trail.removeFirst();
            }
        }

        stroke(0);
        line(origin.x, origin.y, bob.x, bob.y);
        noFill();
        beginShape();
        stroke(100, 100, 255, 150);
        for (PVector v : trail) {
            vertex(v.x, v.y);
        }
        endShape();

        fill(dragging ? color(255, 0, 0) : color(200, 0, 0));
        noStroke();
        ellipse(bob.x, bob.y, ballRadius*2, ballRadius*2);

        fill(0);
        ellipse(origin.x, origin.y, 10, 10);

        fill(0);
        textSize(16);
        text("Pendulum Length: " + r + " m", 20, 30);
        text("Gravity: " + g + " m/s²", 20, 50);
        text("Current Angle: " + nf(degrees(angle), 0, 2) + "°", 20, 70);
        text("Angular Velocity: " + nf(angleV, 0, 4) + " rad/s", 20, 90);

        float potentialE = g * r * (1 - cos(angle));
        float kineticE = (float) (0.5 * angleV * angleV * r * r);
        float totalE = potentialE + kineticE;

        text("Potential Energy: " + nf(potentialE, 0, 2), width - 300, 30);
        text("Kinetic Energy: " + nf(kineticE, 0, 2), width - 300, 50);
        text("Total Energy: " + nf(totalE, 0, 2), width - 300, 70);

        fill(0, 100, 0);
        text("Click and drag pendulum to set position, release to start", (float) width /2 - 200, height - 30);
        text("Press SPACE to pause/resume simulation", (float) width /2 - 150, height - 10);
    }

    public void keyPressed() {
        if (key == ' ') {
            running = !running;
        }
    }
    public void mousePressed() {
        float d = dist(mouseX, mouseY, bob.x, bob.y);
        if (d < ballRadius) {
            dragging = true;
            angleV = 0;
        }
    }
    public void mouseReleased() {
        if (dragging) {
            dragging = false;
            angleV = 0;
        }
    }
    void updateBobPosition() {
        bob.x = origin.x + r * sin(angle);
        bob.y = origin.y + r * cos(angle);
    }
}
