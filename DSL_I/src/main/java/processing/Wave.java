package processing;

import processing.core.PApplet;

public class Wave extends PApplet {
    float startAngle = 0;
    float angleVel = 0.23F;
    float amplitude = 150;
    float frequency = 3;
    float phaseShift = 0;

    public static void runWave(float startAngle, float angleVel, float amplitude, float frequency, float phaseShift) {
        Wave instance = new Wave();
        instance.startAngle = startAngle;
        instance.angleVel = angleVel;
        instance.amplitude = amplitude;
        instance.frequency = frequency;
        instance.phaseShift = phaseShift;

        PApplet.runSketch(new String[]{"Wave"}, instance);
    }

    public void settings() {
        size(600, 600);
    }
    public void setup() {
        size(600, 600);
        frameRate(60);
    }

    public void draw() {
        background(255);

        float period = 1 / frequency;
        angleVel = 2 * PI * frequency / 60;

        startAngle += angleVel;
        float angle = startAngle + phaseShift;

        int prevX = 0;
        float prevY = (float) height / 2 + map(sin(angle), -1, 1, -amplitude, amplitude);

        stroke(0);
        strokeWeight(2);

        for (int x = 0; x <= width; x++) {
            float y = (float) height / 2 + map(sin(angle), -1, 1, -amplitude, amplitude);

            line(prevX, (int)prevY, x, (int)y);

            prevX = x;
            prevY = y;

            angle += angleVel;
        }

        drawHUD(period, frequency, amplitude);
    }


    void drawHUD(float period, float frequency, float amplitude) {
        fill(50, 50, 50, 200);
        rect(10, 10, 230, 100, 10);

        fill(255);
        textSize(14);
        text("Sine Wave Animation", 20, 30);

        textSize(12);
        text("startAngle: " + nf(startAngle, 1, 2), 20, 50);
        text("angleVel: " + nf(angleVel, 1, 2), 20, 65);
        text("Period (s): " + nf(period, 1, 2), 20, 80);
        text("Frequency (Hz): " + nf(frequency, 1, 2), 20, 95);
        text("Amplitude: " + nf(amplitude, 1, 2), 20, 110);
    }
}
