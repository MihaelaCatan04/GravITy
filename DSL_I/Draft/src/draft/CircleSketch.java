package draft;

import processing.core.PApplet;

public class CircleSketch extends PApplet {
    private float radius = 50; // Valoare implicită

    public static void main(String[] args) {
        PApplet.main(CircleSketch.class.getName(), args);
    }

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        if (args != null && args.length > 0) {
            try {
                radius = Float.parseFloat(args[1]); // Preia raza din argumente
            } catch (NumberFormatException e) {
                println("Eroare la conversia razei. Se folosește valoarea implicită.");
            }
        }
    }

    public void draw() {
        background(200);
        fill(255, 0, 0);
        ellipse(width / 2, height / 2, radius * 2, radius * 2);
    }
}
