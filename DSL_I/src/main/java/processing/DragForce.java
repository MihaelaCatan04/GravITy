package processing;

import processing.core.PApplet;
import processing.core.PVector;


public class DragForce extends PApplet {
    Mover[] movers = new Mover[9];
    Liquid liquid;
    float dragCoefficient = 0.1F;
    int[] ballFillColor = {0, 0, 0};
    int[] liquidFillColor = {0, 0, 0};

    public static void runDragForce(int[] ballFillColor, float dragCoefficient, int[] liquidFillCoefficient) {
        DragForce instance = new DragForce();
        instance.ballFillColor = ballFillColor;
        instance.dragCoefficient = dragCoefficient;
        instance.liquidFillColor = liquidFillCoefficient;

        PApplet.runSketch(new String[]{"Drag Force"}, instance);
    }
    public void settings() {
        size(600, 600);
    }
    public void setup() {
        size(600, 600);
        reset();
        liquid = new Liquid(0, (float) height /2, width, (float) height /2, dragCoefficient);
    }

    public void draw() {
        background(255);

        liquid.display();

        for (int i = 0; i < movers.length; i++) {
            if (liquid.contains(movers[i])) {
                PVector dragForce = liquid.drag(movers[i]);
                movers[i].applyForce(dragForce);
            }

            PVector gravity = new PVector((float) 0, (float) (0.1 * movers[i].mass));
            movers[i].applyForce(gravity);
            movers[i].update();
            movers[i].display();
            movers[i].checkEdges();
        }
        drawHUD();
        fill(0);
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 150, 10);

        fill(255);
        textSize(14);
        text("Liquid Simulator", 20, 30);

        textSize(12);
        text("Drag Coefficient: " + dragCoefficient, 20, 50);
        text("Number of Movers: " + movers.length, 20, 65);

        text("Click to Reset", 20, 130);
    }
    class Liquid {

        float x, y, w, h;
        float c;

        Liquid(float x_, float y_, float w_, float h_, float c_) {
            x = x_;
            y = y_;
            w = w_;
            h = h_;
            c = c_;
        }

        boolean contains(Mover m) {
            PVector l = m.position;
            return l.x > x && l.x < x + w && l.y > y && l.y < y + h;
        }

        PVector drag(Mover m) {
            float speed = m.velocity.mag();
            float dragMagnitude = c * speed * speed;

            PVector dragForce = m.velocity.get();
            dragForce.mult(-1);

            dragForce.normalize();
            dragForce.mult(dragMagnitude);
            return dragForce;
        }

        void display() {
            noStroke();
            fill(liquidFillColor[0], liquidFillColor[1], liquidFillColor[2]);
            rect(x, y, w, h);
        }
    }
    public void mousePressed() {
        reset();
    }
    class Mover {

        PVector position;
        PVector velocity;
        PVector acceleration;

        float mass;
        float bounce = 1.0F;

        Mover(float m, float x, float y) {
            mass = m;
            position = new PVector(x-10, y);
            velocity = new PVector(0, 0);
            acceleration = new PVector(0, 0);
        }

        void applyForce(PVector force) {
            PVector f = PVector.div(force, mass);
            acceleration.add(f);
        }

        void update() {

            velocity.add(acceleration);
            position.add(velocity);
            acceleration.mult(0);
        }

        void display() {
            stroke(0);
            strokeWeight(2);
            fill(ballFillColor[0], ballFillColor[1], ballFillColor[2]);
            ellipse(position.x, position.y, mass*16, mass*16);
        }

        void checkEdges() {
            if (position.y > height) {
                velocity.y *= (float) -0.9;
                position.y = height;
            }
        }
    }
    void reset() {
        for (int i = 0; i < movers.length; i++) {
            movers[i] = new Mover(random(0.5F, 3), 40 + i * 70, 0);
        }
    }
}
