package oop.practice;

import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;

public class ProcessingInterface extends PApplet {
    private final List<Mover> movers = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("oop.practice.ProcessingInterface");
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        background(0);
        // Adăugăm un exemplu de mover
        addMover(200, 300, 10, 2, 1, 1, 255, 0, 0);
    }

    @Override
    public void draw() {
        background(0);
        for (Mover mover : movers) {
            mover.update();
            mover.display(this);
        }
    }

    public void addMover(float x, float y, float radius, float mass, float vx, float vy, int r, int g, int b) {
        movers.add(new Mover(x, y, radius, mass, vx, vy, color(r, g, b)));
    }
}

// ========================== PARTICLE CLASS (MOVER) ==========================
class Mover {
    private float x, y, radius, mass, vx, vy;
    private final int color;

    public Mover(float x, float y, float radius, float mass, float vx, float vy, int color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.mass = mass;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }

    public void update() {
        x += vx;
        y += vy;
    }

    public void display(PApplet app) {
        app.fill(color);
        app.ellipse(x, y, radius * 2, radius * 2);
    }
}
