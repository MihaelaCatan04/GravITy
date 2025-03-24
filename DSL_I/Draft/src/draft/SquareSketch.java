package draft;

import processing.core.PApplet;

public class SquareSketch extends PApplet {
    private float side = 50; // Default size

    public static void main(String[] args) {
        PApplet.main(SquareSketch.class.getName(), args);
    }

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        if (args != null && args.length > 0) {
            side = Float.parseFloat(args[1]);
        }
    }

    public void draw() {
        background(200);
        fill(0, 255, 0);
        rectMode(CENTER);
        rect(width / 2, height / 2, side, side);
    }
}

