//import processing.core.PApplet;
//
//public class JumpingBall extends PApplet {
//    float ballX, ballY;
//    float ballSize = 40;
//    float velocity = 0;
//    double gravity = 0.8;
//    float jumpForce = -15;
//    boolean isJumping = false;
//
//    public void settings() {
//        size(500, 500);
//    }
//
//    public void setup() {
//        ballX = width / 2;
//        ballY = height - ballSize / 2;
//    }
//
//    public void draw() {
//        background(200);
//
//        // Apply gravity
//        velocity += gravity;
//        ballY += velocity;
//
//        // Prevent ball from falling below the ground
//        if (ballY >= height - ballSize / 2) {
//            ballY = height - ballSize / 2;
//            velocity = 0;
//            isJumping = false;
//        }
//
//        // Draw the ball
//        fill(255, 0, 0);
//        ellipse(ballX, ballY, ballSize, ballSize);
//    }
//
//    public void keyPressed() {
//        if (key == ' ' && !isJumping) {
//            velocity = jumpForce;
//            isJumping = true;
//        }
//    }
//
//    public static void main(String[] args) {
//        PApplet.main("JumpingBall");
//    }
//}
