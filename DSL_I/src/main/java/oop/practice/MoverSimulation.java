package oop.practice;

import processing.core.PApplet;
import processing.core.PVector;

public class MoverSimulation extends PApplet {
    Mover[] movers;
    boolean showVectors = true;

    public static void main(String[] args) {
        PApplet.main("oop.practice.MoverSimulation");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        movers = new Mover[3];
        movers[0] = new Mover(50, 500, new PVector(3, 2), new PVector(200, 300), 255, 0, 0); // Red
        movers[1] = new Mover(40, 40, new PVector(-2, 1), new PVector(500, 300), 0, 255, 0); // Green
        movers[2] = new Mover(30, 30, new PVector(-1, -3), new PVector(400, 200), 0, 0, 255); // Blue
    }

    public void draw() {
        background(255);

        for (int i = 0; i < movers.length; i++) {
            movers[i].go();
            for (int j = i + 1; j < movers.length; j++) {
                movers[i].collideWithMass(movers[j], 0.8f);
            }
        }
        drawHUD();
    }

    class Mover {
        PVector pos, vel;
        float bounce = 1.0f;
        float r, mass;
        boolean colliding = false;
        int[] fillColor;

        Mover(float radius, float m, PVector v, PVector l, int rC, int gC, int bC) {
            r = radius;
            vel = v.copy();
            pos = l.copy();
            mass = m;
            fillColor = new int[]{rC, gC, bC};
        }

        void go() {
            update();
            borders();
            display();
        }

        void update() {
            pos.add(vel);
        }

        void borders() {
            if (pos.y > height) {
                vel.y *= -1;
                pos.y = height;
            } else if (pos.y < 0) {
                vel.y *= -1;
                pos.y = 0;
            }
            if (pos.x > width) {
                vel.x *= -1;
                pos.x = width;
            } else if (pos.x < 0) {
                vel.x *= -1;
                pos.x = 0;
            }
        }

        void display() {
            ellipseMode(CENTER);
            stroke(0);
            fill(fillColor[0], fillColor[1], fillColor[2]);
            ellipse(pos.x, pos.y, r * 2, r * 2);

            if (showVectors) {
                drawVector(vel, pos, 10);
                fill(0);
                textSize(12);
                text("v: " + nf(vel.mag(), 0, 2), pos.x + 10, pos.y - 10);
            }
        }

        void collideWithMass(Mover other, float e) {
            float d = PVector.dist(pos, other.pos);
            float sumR = r + other.r;

            if (!colliding && d < sumR) {
                colliding = true;

                PVector n = PVector.sub(other.pos, pos);
                n.normalize();

                PVector u = PVector.sub(vel, other.vel);
                PVector un = componentVector(u, n);

                float m1 = mass;
                float m2 = other.mass;

                float massRatio1 = (1 + e) * m2 / (m1 + m2);
                float massRatio2 = (1 + e) * m1 / (m1 + m2);

                PVector v1 = PVector.mult(un, -massRatio1);
                PVector v2 = PVector.mult(un, massRatio2);

                vel.add(v1);
                other.vel.add(v2);
            } else if (d > sumR) {
                colliding = false;
            }
        }
    }

    PVector componentVector(PVector vector, PVector directionVector) {
        directionVector.normalize();
        directionVector.mult(vector.dot(directionVector));
        return directionVector;
    }

    void drawHUD() {
        fill(0, 150);
        rect(10, 10, 220, 20 + movers.length * 30, 10);

        fill(255);
        textSize(14);
        text("MOVER SIMULATION", 20, 30);
        text("Objects: " + movers.length, 20, 50);

        textSize(12);
        for (int i = 0; i < movers.length; i++) {
            text("Obj " + (i + 1) + " - Mass: " + nf(movers[i].mass, 0, 2) +
                    ", Radius: " + nf(movers[i].r, 0, 2), 20, 70 + (i * 20));
        }
    }

    void drawVector(PVector v, PVector pos, float scale) {
        PVector end = PVector.add(pos, PVector.mult(v, scale));
        stroke(0);
        line(pos.x, pos.y, end.x, end.y);

        PVector arrowDir = PVector.sub(end, pos);
        arrowDir.setMag(6);
        PVector left = PVector.add(end, new PVector(-arrowDir.y, arrowDir.x));
        PVector right = PVector.add(end, new PVector(arrowDir.y, -arrowDir.x));

        line(end.x, end.y, left.x, left.y);
        line(end.x, end.y, right.x, right.y);
    }
}
