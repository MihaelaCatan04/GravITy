import processing.core.PApplet;

public class UniformMotion extends PApplet {
    float x;
    float y;
    float speed;
    int[] fillColor = {0, 150, 255};
    float radius = 50;
    boolean bouncing = false;
    public static void main(String[] args) {
        PApplet.main("UniformMotion");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        x = 0;
        y = (float) height / 2;
        speed = 2;
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

        fill(fillColor[0], fillColor[1], fillColor[2]);
        ellipse(x, y, radius, radius);

        drawHUD();
        displayInstructions();
    }

    void displayInstructions() {
        fill(100);
        textSize(12);
        text("Press Left arrow to decrease speed", 20, height - 60);
        text("Press Right arrow to increase speed", 20, height - 40);
    }
    public void keyPressed() {
        if (keyCode == LEFT) {
            speed -= 0.5;
        } else if (keyCode == RIGHT) {
            speed += 0.5;
        }
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 80, 10);
        fill(255);
        textSize(14);
        text("Uniform Motion", 20, 30);
        textSize(12);
        text("X Position: " + nf(x, 1, 2), 20, 50);
        text("Speed: " + nf(abs(speed), 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);
    }

}
