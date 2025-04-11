import processing.core.PApplet;

public class AcceleratedUniformMotion extends PApplet {
    float x;
    float y;
    float speed;
    float acceleration = 0.005F;
    int[] fillColor = {0, 150, 255};

    public static void main(String[] args) {
        PApplet.main("AcceleratedUniformMotion");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        x = 0;
        y = (float) height / 2;
        speed = 0;
    }

    public void draw() {
        background(240);
        speed += acceleration;
        x += speed;
        if (x > width) {
            x = 0;
            speed = abs(speed);
        } else if (x < 0) {
            x = width;
            speed = -abs(speed);
        }

        fill(fillColor[0], fillColor[1], fillColor[2]);
        ellipse(x, y, 30, 30);
        drawHUD();
        displayInstructions();
    }
    void displayInstructions() {
        fill(100);
        textSize(12);
        text("Press Left arrow to decrease acceleration", 20, height - 60);
        text("Press Right arrow to increase acceleration", 20, height - 40);
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 100, 10);
        fill(255);
        textSize(14);
        text("Accelerated Motion", 20, 30);
        textSize(12);
        text("X Position: " + nf(x, 1, 2), 20, 50);
        text("Speed: " + nf(speed, 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);
        text("Acceleration: " + nf(acceleration, 1, 3), 20, 80);
    }
    public void keyPressed() {
        if (keyCode == LEFT) {
            acceleration -= 0.01F;
        } else if (keyCode == RIGHT) {
            acceleration += 0.01F;
        }
    }

}
