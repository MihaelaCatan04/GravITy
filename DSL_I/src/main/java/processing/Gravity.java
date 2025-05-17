package processing;

import processing.core.PApplet;

public class Gravity extends PApplet {
    float earthX, earthY;
    float moonX, moonY;
    float G = 6.674e-11F;
    float massEarth = 5.972e24F;
    float massMoon = 7.348e22F;
    boolean dragging = false;

    public static void runGravity(float earthX, float earthY, float moonX, float moonY) {
        Gravity instance = new Gravity();
        instance.moonX = moonX;
        instance.moonY = moonY;
        instance.earthX = earthX;
        instance.earthY = earthY;

        PApplet.runSketch(new String[]{"Gravity"}, instance);
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        earthX = (float) width / 3;
        earthY = (float) height / 2;
        moonX = earthX + 200;
        moonY = earthY;
    }

    public void draw() {
        background(240);
        float dx = moonX - earthX;
        float dy = moonY - earthY;
        float distance = sqrt(dx * dx + dy * dy);
        float force = (G * massEarth * massMoon) / (distance * distance);
        fill(0, 100, 255);
        ellipse(earthX, earthY, 80, 80);
        fill(200);
        ellipse(moonX, moonY, 30, 30);
        fill(0);
        textSize(14);
        text("Earth Mass: " + massEarth + " kg", 20, 20);
        text("Moon Mass: " + massMoon + " kg", 20, 40);
        text("Distance: " + (int)distance + " px", 20, 60);
        text("Gravity Force: " + force + " N", 20, 80);
    }
    public void mouseDragged() {
        if (dragging) {
            moonX = mouseX;
            moonY = mouseY;
        }
    }
    public void mousePressed() {
        if (dist(mouseX, mouseY, moonX, moonY) < 15) {
            dragging = true;
        }
    }
    public void mouseReleased() {
        dragging = false;
    }
}
