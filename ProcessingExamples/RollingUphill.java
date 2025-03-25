import processing.core.PApplet;

public class RollingUphill extends PApplet {
    float g = 0.1F;
    float mu = 0.5F;
    float restitution = 0.7F;
    float angle = PI/6;

    float ballRadius = 20;
    float ballMass = 1;
    float ballX, ballY;
    float ballVx = 0;
    boolean isDragging = false;

    float planeLength = 600;
    float planeHeight = 200;
    float planeX, planeY;

    public static void main(String[] args) {
        PApplet.main("RollingUphill");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {

        planeX = (float) width /2 - planeLength/2;
        planeY = (float) height /2 + planeHeight/2;

        resetBall();
    }

    public void draw() {
        background(240);

        if (mousePressed && mouseY > height/2) {
            angle = map((float) mouseX, (float) 0, (float) width, PI/12, (float) (PI/2.5));
            resetBall();
        }

        float sinAngle = sin(angle);
        float cosAngle = cos(angle);

        float x1 = planeX;
        float y1 = planeY;
        float x2 = planeX + planeLength * cosAngle;
        float y2 = planeY - planeLength * sinAngle;
        float x3 = planeX + planeLength * cosAngle;
        float y3 = y2 + 20;
        float x4 = planeX;
        float y4 = y1 + 20;

        fill(120);
        quad(x1, y1, x2, y2, x3, y3, x4, y4);

        if (!isDragging) {
            float Fgp = ballMass * g * sinAngle;

            float normalForce = ballMass * g * cosAngle;
            float frictionForce = mu * normalForce;

            float netForce;
            if (ballVx == 0) {
                if (abs(Fgp) < frictionForce) {
                    netForce = 0;
                } else {
                    netForce = Fgp - frictionForce * sign(Fgp);
                }
            } else {
                netForce = Fgp - frictionForce * sign(ballVx);
            }

            float acceleration = netForce / ballMass;
            ballVx += acceleration;

            ballX += ballVx;
            ballY -= ballVx * tanAngle(angle);

            if (ballX < planeX + ballRadius / cosAngle) {
                ballX = planeX + ballRadius / cosAngle;
                ballVx *= -restitution;
            }

            float maxX = planeX + planeLength * cosAngle - ballRadius / cosAngle;
            if (ballX > maxX) {
                ballX = maxX;
                ballVx *= -restitution;
            }
        }

        drawBall();

        if (!isDragging) {
            drawForceVectors();
        }
        drawHUD();

    }

    void drawArrow(float x1, float y1, float x2, float y2) {
        line(x1, y1, x2, y2);
        pushMatrix();
        translate(x2, y2);
        float a = atan2(y2-y1, x2-x1);
        rotate(a);
        line(0, 0, -(float) 8, -(float) 8 /2);
        line(0, 0, -(float) 8, (float) 8 /2);
        popMatrix();
    }
    void drawBall() {
        float distFromBase = ballX - planeX;
        float ballWorldY = planeY - distFromBase * tan(angle);

        float rotationAngle = -distFromBase / ballRadius;

        pushMatrix();
        translate(ballX, ballWorldY);

        fill(255, 50, 50);
        stroke(0);
        strokeWeight(2);
        ellipse(0, 0, ballRadius * 2, ballRadius * 2);

        rotate(rotationAngle);
        stroke(0);
        line(0, 0, 0, -ballRadius);

        popMatrix();
    }
    void drawForceVectors() {
        float sinAngle = sin(angle);
        float cosAngle = cos(angle);

        float distFromBase = ballX - planeX;
        float ballWorldY = planeY - distFromBase * tan(angle);

        stroke(0, 0, 255);
        strokeWeight(2);
        float gravityScale = 50;
        drawArrow(ballX, ballWorldY, ballX, ballWorldY + gravityScale);
        fill(0, 0, 255);
        text("Gravity", ballX + 5, ballWorldY + gravityScale/2);

        if (ballVx != 0) {
            stroke(255, 0, 0);
            float frictionScale = 30;
            float frictionX = -frictionScale * sign(ballVx) * cosAngle;
            float frictionY = frictionScale * sign(ballVx) * sinAngle;
            drawArrow(ballX, ballWorldY, ballX + frictionX, ballWorldY + frictionY);
            fill(255, 0, 0);
            text("Friction", ballX + frictionX/2, ballWorldY + frictionY/2 - 10);
        }

        stroke(0, 255, 0);
        float parallelScale = 40 * sinAngle;
        float parallelX = parallelScale * cosAngle;
        float parallelY = parallelScale * sinAngle;
        drawArrow(ballX, ballWorldY, ballX - parallelX, ballWorldY - parallelY);
        fill(0, 255, 0);
        text("Force down plane", ballX + parallelX/2, ballWorldY + parallelY/2 - 10);
    }
    void drawHUD() {
        fill(50, 50, 50, 200);
        stroke(0);
        rect(10, 10, 230, 210, 10);
        fill(255);
        textSize(14);
        text("Physics Simulation", 20, 30);
        textSize(12);
        text("Angle: " + nf(degrees(angle), 0, 1) + "°", 20, 50);
        text("Velocity: " + nf(ballVx, 0, 2) + " m/s", 20, 70);
        text("Position: (" + nf(ballX, 0, 1) + ", " + nf(ballY, 0, 1) + ")", 20, 90);
        text("Gravity: " + nf(g, 0, 2), 20, 110);
        text("Friction: " + nf(mu, 0, 2), 20, 130);
        text("Restitution: " + nf(restitution, 0, 2), 20, 150);
        text("Click and drag the ball to reposition", 20, 170);
        text("Click below the incline to adjust angle: " + nf(degrees(angle), 0, 1) + "°", 20, 190);
    }
    public void mouseDragged() {
        if (isDragging) {
            float dx = mouseX - planeX;
            float dy = planeY - mouseY;

            float projectedDist = (dx * cos(angle) + dy * sin(angle));

            projectedDist = constrain(projectedDist,
                    ballRadius / cos(angle),
                    planeLength * cos(angle) - ballRadius / cos(angle));
            ballX = planeX + projectedDist;
            ballVx = 0;
        }
    }
    public void mousePressed() {
        float distFromBase = ballX - planeX;
        float ballWorldY = planeY - distFromBase * tan(angle);

        if (dist(mouseX, mouseY, ballX, ballWorldY) < ballRadius) {
            isDragging = true;
        }
    }
    public void mouseReleased() {
        isDragging = false;
    }
    void resetBall() {
        float planeProjectedLength = planeLength * cos(angle);
        ballX = (float) (planeX + planeProjectedLength * 0.25);
        float distFromBase = ballX - planeX;
        ballY = planeY - distFromBase * tan(angle);
        ballVx = 0;
    }
    float sign(float val) {
        if (val > 0) return 1;
        if (val < 0) return -1;
        return 0;
    }
    float tanAngle(float a) {
        return tan(a);
    }


}
