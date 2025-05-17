package processing;

import processing.core.PApplet;

public class UniformMotion extends PApplet {
    // Static variables to hold the configuration that will be set before the sketch starts
    private static float configRadius = 50;
    private static int[] configBallColor = {50, 5, 250};
    private static float configSpeed = 2.0f;

    private float x;
    private float y;
    private float speed;
    private float radius;
    private boolean bouncing = false;
    private int[] ballColor;

    public static void runUniformMotion(float radius, int[] colors, float initial_speed) {
        UniformMotion instance = new UniformMotion();

        instance.radius = radius;
        instance.ballColor = colors;
        instance.speed = initial_speed;

        PApplet.runSketch(new String[]{"Uniform Motion"}, instance);
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {

        x = width / 2;
        y = height / 2;

        // Safety check to ensure ballColor is initialized
        if (ballColor == null) {
            ballColor = new int[]{50, 5, 250};
        }
    }

    public void draw() {
        background(240);

        x += speed;

        if (bouncing) {
            if (x >= width - radius || x <= radius) {
                speed = -speed;
            }
        } else {
            if (x > width) {
                x = 0;
                speed = abs(speed);
            } else if (x < 0) {
                x = width;
                speed = -abs(speed);
            }
        }

        if (ballColor != null && ballColor.length >= 3) {
            fill(ballColor[0], ballColor[1], ballColor[2]);
        } else {
            fill(50, 5, 250);
        }

        noStroke();
        ellipse(x, y, 2*radius, 2*radius);

        stroke(255, 0, 0);
        strokeWeight(2);
        point(x, y);

        drawHUD();
        displayInstructions();
    }

    void displayInstructions() {
        fill(100);
        textSize(12);
        text("Press Left arrow to decrease speed", 20, height - 60);
        text("Press Right arrow to increase speed", 20, height - 40);
        text("Press 'b' to toggle bouncing mode", 20, height - 20);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            speed -= 0.5;
        } else if (keyCode == RIGHT) {
            speed += 0.5;
        } else if (key == 'b' || key == 'B') {
            bouncing = !bouncing;
        } else if (key == '+') {
            radius += 5;
        } else if (key == '-') {
            radius = max(5, radius - 5);
        }
    }

    void drawHUD() {
        noStroke();
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 100, 10);
        fill(255);
        textSize(14);
        text("Uniform Motion", 20, 30);
        textSize(12);
        text("X Position: " + nf(x, 1, 2), 20, 50);
        text("Speed: " + nf(abs(speed), 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);
        text("Mode: " + (bouncing ? "Bouncing" : "Wrapping"), 20, 80);
        text("Radius: " + nf(radius, 1, 2), 20, 95);
    }
}