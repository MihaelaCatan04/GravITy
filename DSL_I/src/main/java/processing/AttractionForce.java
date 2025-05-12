package processing;

import processing.core.PApplet;
import processing.core.PVector;

public class AttractionForce extends PApplet {
    float radius1, radius2;
    float mass1, mass2;
    float attractionConstant = 1.0F;
    int[] color1 = {0, 100, 255};
    int[] color2 = {255, 100, 0};
    PVector position1, position2;
    PVector velocity1, velocity2;
    PVector acceleration1, acceleration2;
    boolean simulateMotion = false;
    boolean showForceVector = true;
    float dampingFactor = 0.98F;
    float velocityLimit = 10;

    public static void runAttractionForce(float radius1, float mass1, float[] position1, float[] velocity1,
                                          float radius2, float mass2, float[] position2, float[] velocity2,
                                          int[] color1, int[] color2) {
        AttractionForce instance = new AttractionForce();
        instance.radius1 = radius1;
        instance.mass1 = mass1;
        instance.position1 = new PVector(position1[0], position1[1]);
        instance.velocity1 = new PVector(velocity1[0], velocity1[1]);
        instance.acceleration1 = new PVector(0, 0);
        instance.color1 = color1;

        instance.radius2 = radius2;
        instance.mass2 = mass2;
        instance.position2 = new PVector(position2[0], position2[1]);
        instance.velocity2 = new PVector(velocity2[0], velocity2[1]);
        instance.acceleration2 = new PVector(0, 0);
        instance.color2 = color2;

        PApplet.runSketch(new String[]{"Attraction Force"}, instance);
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        background(240);
    }

    public void draw() {
        background(240);
        updateMotion();
        drawObjects();
        drawHUD();
    }

    void updateMotion() {
        if (!simulateMotion) return;

        PVector force = PVector.sub(position2, position1);
        float distance = max(force.mag(), radius1 + radius2);
        force.normalize();
        float forceMagnitude = (attractionConstant * mass1 * mass2) / (distance * distance);
        force.mult(forceMagnitude);

        acceleration1 = force.copy().div(mass1);
        acceleration2 = force.copy().mult(-1).div(mass2);

        velocity1.add(acceleration1).mult(dampingFactor).limit(velocityLimit);
        velocity2.add(acceleration2).mult(dampingFactor).limit(velocityLimit);

        position1.add(velocity1);
        position2.add(velocity2);

        handleBoundaryCollision(position1, velocity1, radius1);
        handleBoundaryCollision(position2, velocity2, radius2);
    }

    void handleBoundaryCollision(PVector position, PVector velocity, float radius) {
        if (position.x < radius || position.x > width - radius) {
            velocity.x *= -0.8;
        }
        if (position.y < radius || position.y > height - radius) {
            velocity.y *= -0.8;
        }
    }

    void drawObjects() {
        fill(color1[0], color1[1], color1[2]);
        ellipse(position1.x, position1.y, radius1 * 2, radius1 * 2);

        fill(color2[0], color2[1], color2[2]);
        ellipse(position2.x, position2.y, radius2 * 2, radius2 * 2);
    }

    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 140, 10);
        fill(255);
        textSize(14);
        text("Attraction Force Simulation", 20, 30);
        textSize(12);
        text("Mass 1: " + mass1, 20, 50);
        text("Mass 2: " + mass2, 20, 65);
        text("Attraction Constant: " + nf(attractionConstant, 1, 3), 20, 80);
        text("Simulation Running: " + (simulateMotion ? "YES" : "NO"), 20, 95);
        text("Press 's' to start/stop simulation", 20, 110);
        text("Press 'v' to toggle force vectors", 20, 125);
        text("Press 'a'/'d' to adjust attraction constant", 20, 140);
    }

    public void keyPressed() {
        if (key == 's') simulateMotion = !simulateMotion;
        if (key == 'v') showForceVector = !showForceVector;
        if (key == 'a') attractionConstant /= 1.2F;
        if (key == 'd') attractionConstant *= 1.2F;
    }
}