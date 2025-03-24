package draft;

import processing.core.PApplet;

public class PentagonSketch extends PApplet {
    private float side = 50; // Default size

    public static void main(String[] args) {
        PApplet.main(PentagonSketch.class.getName(), args);
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
        fill(255, 255, 0);
        drawPentagon(width / 2, height / 2, side);
    }

    private void drawPentagon(float x, float y, float size) {
        float angle = TWO_PI / 5;
        beginShape();
        for (int i = 0; i < 5; i++) {
            float vx = x + cos(angle * i) * size;
            float vy = y + sin(angle * i) * size;
            vertex(vx, vy);
        }
        endShape(CLOSE);
    }
}

