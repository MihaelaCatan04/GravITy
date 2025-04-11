import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;


public class Spring extends PApplet {
    float springConstant = 0.1F;
    float damping = 0.98F;
    float restLength = 150;
    float floorFriction = 0.99F;

    float ballRadius = 30;
    float ballMass = 1;
    PVector ballPosition;
    PVector ballVelocity;
    boolean isDragging = false;

    PVector anchorPosition;
    float springWidth = 20;
    int numCoils = 10;

    boolean hasLaunched = false;
    ArrayList<PVector> trajectoryPoints = new ArrayList<PVector>();
    public static void main(String[] args) {
        PApplet.main("Spring");
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        anchorPosition = new PVector(100, (float) height /2);
        ballPosition = new PVector(anchorPosition.x + restLength, (float) height /2);
        ballVelocity = new PVector(0, 0);
    }

    public void draw() {
        background(240);
        fill(200);
        rect(0, height-20, width, 20);

        float displacement = PVector.dist(anchorPosition, ballPosition) - restLength;
        PVector springDirection = PVector.sub(anchorPosition, ballPosition);
        springDirection.normalize();

        if (!isDragging) {
            PVector springForce = PVector.mult(springDirection, springConstant * displacement);
            PVector acceleration = PVector.div(springForce, ballMass);
            ballVelocity.add(acceleration);

            ballVelocity.mult(damping);

            ballPosition.add(ballVelocity);

            if (ballPosition.y > height - 20 - ballRadius) {
                ballPosition.y = height - 20 - ballRadius;
                ballVelocity.y *= (float) -0.9;
                ballVelocity.x *= floorFriction;
            }

            if (hasLaunched && frameCount % 3 == 0 && trajectoryPoints.size() < 50) {
                trajectoryPoints.add(ballPosition.copy());
            }
        }

        fill(100);
        stroke(0);
        strokeWeight(2);
        rect(anchorPosition.x-15, anchorPosition.y-40, 30, 80);

        if (hasLaunched) {
            noFill();
            strokeWeight(1);
            stroke(100, 200, 100, 150);
            for (int i = 0; i < trajectoryPoints.size()-1; i++) {
                line(trajectoryPoints.get(i).x, trajectoryPoints.get(i).y,
                        trajectoryPoints.get(i+1).x, trajectoryPoints.get(i+1).y);
            }
        }

        drawSpring(anchorPosition.x, anchorPosition.y, ballPosition.x, ballPosition.y);

        fill(50, 200, 50);
        stroke(0);
        strokeWeight(2);
        ellipse(ballPosition.x, ballPosition.y, ballRadius*2, ballRadius*2);

        if (!isDragging) {
            float forceScaling = 0.5F;
            stroke(255, 0, 0);
            strokeWeight(2);
            float forceX = springDirection.x * springConstant * displacement * forceScaling;
            float forceY = springDirection.y * springConstant * displacement * forceScaling;
            drawArrow(ballPosition.x, ballPosition.y,
                    ballPosition.x + forceX, ballPosition.y + forceY);

            fill(255, 0, 0);
            text("Spring Force", ballPosition.x + forceX/2, ballPosition.y + forceY/2 - 10);

            fill(0);
            text("Spring Energy: " + nf((float) (0.5 * springConstant * displacement * displacement), 0, 1) + "J", 20, 60);
            text("Kinetic Energy: " + nf((float) (0.5 * ballMass * ballVelocity.magSq()), 0, 1) + "J", 20, 90);
        }

        fill(0);
        textSize(16);
        if (!hasLaunched) {
            text("Drag the ball to compress or stretch the spring, then release", 20, 30);
        }
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
    void drawSpring(float x1, float y1, float x2, float y2) {
        float springLength = dist(x1, y1, x2, y2);
        float angle = atan2(y2 - y1, x2 - x1);

        stroke(80);
        strokeWeight(3);

        float endGap = 10;

        line(x1, y1, x1 + endGap * cos(angle), y1 + endGap * sin(angle));

        float coilLength = springLength - 2 * endGap;
        float coilSpacing = coilLength / numCoils;

        for (int i = 0; i < numCoils; i++) {
            float startX = x1 + (endGap + i * coilSpacing) * cos(angle);
            float startY = y1 + (endGap + i * coilSpacing) * sin(angle);
            float midX = startX + (coilSpacing/2) * cos(angle) + springWidth * cos(angle + PI/2);
            float midY = startY + (coilSpacing/2) * sin(angle) + springWidth * sin(angle + PI/2);
            float endX = x1 + (endGap + (i+1) * coilSpacing) * cos(angle);
            float endY = y1 + (endGap + (i+1) * coilSpacing) * sin(angle);

            bezier(startX, startY,
                    startX + coilSpacing/4 * cos(angle), startY + coilSpacing/4 * sin(angle),
                    midX - coilSpacing/4 * cos(angle), midY - coilSpacing/4 * sin(angle),
                    midX, midY);

            bezier(midX, midY,
                    midX + coilSpacing/4 * cos(angle), midY + coilSpacing/4 * sin(angle),
                    endX - coilSpacing/4 * cos(angle), endY - coilSpacing/4 * sin(angle),
                    endX, endY);
        }

        line(x1 + (endGap + numCoils * coilSpacing) * cos(angle),
                y1 + (endGap + numCoils * coilSpacing) * sin(angle),
                x2, y2);

        if (abs(springLength - restLength) > 5) {
            strokeWeight(1);
            stroke(100, 100, 255, 100);
            line(x1, y1, x1 + restLength * cos(angle), y1 + restLength * sin(angle));
            fill(100, 100, 255);
            text("Rest Length", x1 + restLength/2 * cos(angle), y1 + restLength/2 * sin(angle) - 10);
        }
    }
    public void mouseDragged() {
        if (isDragging) {
            ballPosition.x = mouseX;
            ballPosition.y = mouseY;

            float minDist = 20;
            if (PVector.dist(ballPosition, anchorPosition) < minDist) {
                PVector dir = PVector.sub(ballPosition, anchorPosition);
                dir.normalize();
                ballPosition = PVector.add(anchorPosition, PVector.mult(dir, minDist));
            }

            ballVelocity.x = 0;
            ballVelocity.y = 0;
        }
    }
    public void mousePressed() {
        if (dist(mouseX, mouseY, ballPosition.x, ballPosition.y) < ballRadius) {
            isDragging = true;
            hasLaunched = false;
            trajectoryPoints.clear();
        }
    }
    public void mouseReleased() {
        if (isDragging) {
            isDragging = false;
            hasLaunched = true;
        }
    }
}
