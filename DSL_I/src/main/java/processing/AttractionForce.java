package processing;

import processing.core.PApplet;
import processing.core.PVector;

public class AttractionForce extends PApplet {
    float radius1, radius2;
    float mass1, mass2;
    float attractionConstant = 1.0F;
    int color1;
    int color2;
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
        instance.color1 = instance.color(color1[0], color1[1], color1[2]);

        instance.radius2 = radius2;
        instance.mass2 = mass2;
        instance.position2 = new PVector(position2[0], position2[1]);
        instance.velocity2 = new PVector(velocity2[0], velocity2[1]);
        instance.acceleration2 = new PVector(0, 0);
        instance.color2 = instance.color(color2[0], color2[1], color2[2]);

        PApplet.runSketch(new String[]{"Attraction Force"}, instance);
    }

    public void settings() {
        size(600, 600);
    }

    float obj1X, obj1Y;
    float obj2X, obj2Y;
    boolean dragging1 = false;
    boolean dragging2 = false;
    float forceScale = 0.5F;

    public void setup() {
        size(600, 600);
        obj1X = (float) width / 3;
        obj1Y = (float) height / 2;
        obj2X = obj1X + 200;
        obj2Y = obj1Y;
        position1 = new PVector(obj1X, obj1Y);
        position2 = new PVector(obj2X, obj2Y);
        velocity1 = new PVector(0, 0);
        velocity2 = new PVector(0, 0);
        acceleration1 = new PVector(0, 0);
        acceleration2 = new PVector(0, 0);
        color1 = color(0, 100, 255); // Initialize color1
        color2 = color(255, 100, 0); // Initialize color2
    }

    public void draw() {
        background(240);
        if (!dragging1) {
            obj1X = position1.x;
            obj1Y = position1.y;
        } else {
            position1.set(obj1X, obj1Y);
            velocity1.set(0, 0);
        }

        if (!dragging2) {
            obj2X = position2.x;
            obj2Y = position2.y;
        } else {
            position2.set(obj2X, obj2Y);
            velocity2.set(0, 0);
        }

        float dx = obj2X - obj1X;
        float dy = obj2Y - obj1Y;
        float distance = sqrt(dx * dx + dy * dy);

        distance = max(distance, radius1 + radius2);

        float forceMagnitude = (attractionConstant * mass1 * mass2) / (distance * distance);

        float forceX = dx / distance;
        float forceY = dy / distance;

        if (simulateMotion && !dragging1 && !dragging2) {
            PVector force = new PVector(forceX, forceY);
            acceleration1.set(force.x, force.y);
            acceleration1.mult(forceMagnitude / mass1);
            acceleration2.set(-force.x, -force.y);
            acceleration2.mult(forceMagnitude / mass2);
            velocity1.add(acceleration1);
            velocity2.add(acceleration2);
            velocity1.mult(dampingFactor);
            velocity2.mult(dampingFactor);
            velocity1.limit(velocityLimit);
            velocity2.limit(velocityLimit);
            position1.add(velocity1);
            position2.add(velocity2);
            if (position1.x < radius1) {
                position1.x = radius1;
                velocity1.x *= (float) -0.8;
            } else if (position1.x > width - radius1) {
                position1.x = width - radius1;
                velocity1.x *= (float) -0.8;
            }
            if (position1.y < radius1) {
                position1.y = radius1;
                velocity1.y *= (float) -0.8;
            } else if (position1.y > height - radius1) {
                position1.y = height - radius1;
                velocity1.y *= (float) -0.8;
            }

            if (position2.x < radius2) {
                position2.x = radius2;
                velocity2.x *= (float) -0.8;
            } else if (position2.x > width - radius2) {
                position2.x = width - radius2;
                velocity2.x *= (float) -0.8;
            }
            if (position2.y < radius2) {
                position2.y = radius2;
                velocity2.y *= (float) -0.8;
            } else if (position2.y > height - radius2) {
                position2.y = height - radius2;
                velocity2.y *= (float) -0.8;
            }
        }
        if (showForceVector) {
            stroke(255, 0, 0);
            strokeWeight(2);
            float arrowLength = min((int) (forceMagnitude * forceScale), (int) (distance * 0.8));
            line(obj1X, obj1Y, obj1X + forceX * arrowLength, obj1Y + forceY * arrowLength);
            pushMatrix();
            translate(obj1X + forceX * arrowLength, obj1Y + forceY * arrowLength);
            rotate(atan2(forceY, forceX));
            line(0, 0, -10, -5);
            line(0, 0, -10, 5);
            popMatrix();
            line(obj2X, obj2Y, obj2X - forceX * arrowLength, obj2Y - forceY * arrowLength);
            pushMatrix();
            translate(obj2X - forceX * arrowLength, obj2Y - forceY * arrowLength);
            rotate(atan2(-forceY, -forceX));
            line(0, 0, -10, -5);
            line(0, 0, -10, 5);
            popMatrix();

            noStroke();
        }

        fill(color1);
        ellipse(obj1X, obj1Y, radius1 * 2, radius1 * 2);

        fill(color2);
        ellipse(obj2X, obj2Y, radius2 * 2, radius2 * 2);

        fill(0);
        textSize(14);
        text("Object 1 Mass: " + mass1, 20, 20);
        text("Object 2 Mass: " + mass2, 20, 40);
        text("Distance: " + (int)distance + " px", 20, 60);
        text("Attraction Force: " + nf(forceMagnitude, 1, 3), 20, 80);
        text("Attraction Constant: " + nf(attractionConstant, 1, 3), 20, 100);
        text("Simulation Running: " + (simulateMotion ? "YES" : "NO"), 20, 120);
        fill(100);
        textSize(12);
        text("Drag either object to move it", 20, height - 100);
        text("Press 'v' to toggle force vectors", 20, height - 80);
        text("Press '1' or '2' to increase respective object mass", 20, height - 60);
        text("Press '3' or '4' to decrease respective object mass", 20, height - 40);
        text("Press 's' to toggle simulation, 'a'/'d' to adjust attraction constant", 20, height - 20);
    }

    public void keyPressed() {
        float massChangeFactor = 1.5F;
        float attractionChangeFactor = 1.2F;

        if (key == 'v' || key == 'V') {
            showForceVector = !showForceVector;
        }

        if (key == 's' || key == 'S') {
            simulateMotion = !simulateMotion;
            if (!simulateMotion) {
                velocity1.set(0, 0);
                velocity2.set(0, 0);
            }
        }

        if (key == 'a' || key == 'A') {
            attractionConstant /= attractionChangeFactor;
        }
        if (key == 'd' || key == 'D') {
            attractionConstant *= attractionChangeFactor;
        }

        if (key == '3') {
            mass1 /= massChangeFactor;
        } else if (key == '1') {
            mass1 *= massChangeFactor;
        }

        if (key == '4') {
            mass2 /= massChangeFactor;
        } else if (key == '2') {
            mass2 *= massChangeFactor;
        }
    }

    public void mouseDragged() {
        if (dragging1) {
            obj1X = mouseX;
            obj1Y = mouseY;
            position1.set(obj1X, obj1Y);
            velocity1.set(0, 0);
        } else if (dragging2) {
            obj2X = mouseX;
            obj2Y = mouseY;
            position2.set(obj2X, obj2Y);
            velocity2.set(0, 0);
        }
    }

    public void mousePressed() {
        if (dist(mouseX, mouseY, obj1X, obj1Y) < radius1) {
            dragging1 = true;
        } else if (dist(mouseX, mouseY, obj2X, obj2Y) < radius2) {
            dragging2 = true;
        }
    }

    public void mouseReleased() {
        dragging1 = false;
        dragging2 = false;
    }
}