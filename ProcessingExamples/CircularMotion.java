import processing.core.PApplet;

public class CircularMotion extends PApplet {
    float angle = 0;
    float radius = 100;
    float cx, cy;
    float angularSpeed = 0.02F;
    int[] fillColor = {0, 150, 255};
    float ballRadius = 30;

    public static void main(String[] args) {
        PApplet.main("CircularMotion");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        cx = (float) width / 2;
        cy = (float) height / 2;
    }

    public void draw() {
        background(240);
        fill(fillColor[0], fillColor[1], fillColor[2]);
        float x = cx + radius * cos(angle);
        float y = cy + radius * sin(angle);
        ellipse(x, y, ballRadius, ballRadius);
        angle += angularSpeed;
        drawHUD();
        displayInstructions();
    }
    void displayInstructions() {
        fill(100);
        textSize(12);
        text("Press Left arrow to decrease angular speed", 20, height - 60);
        text("Press Right arrow to increase angular speed", 20, height - 40);
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 100, 10);
        fill(255);
        textSize(14);
        text("Circular Motion", 20, 30);
        textSize(12);
        text("Angle: " + nf(angle, 1, 2) + " radians", 20, 50);
        text("Angular Speed: " + nf(angularSpeed, 1, 4), 20, 65);
        text("Radius: " + nf(radius, 1, 2), 20, 80);
    }
    public void keyPressed() {
        if (keyCode == LEFT) {
            angularSpeed -= 0.005F;
        } else if (keyCode == RIGHT) {
            angularSpeed += 0.005F;
        }
    }


}
