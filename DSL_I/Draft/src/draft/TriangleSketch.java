package draft;

import processing.core.PApplet;

public class TriangleSketch extends PApplet {
    private float side = 50; // Default size

    public static void main(String[] args) {
        PApplet.main(TriangleSketch.class.getName(), args);
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
        fill(0, 0, 255);
        float h = (float) (Math.sqrt(3) / 2 * side);
        triangle(width / 2, height / 2 - h / 2, width / 2 - side / 2, height / 2 + h / 2, width / 2 + side / 2, height / 2 + h / 2);
    }
}

