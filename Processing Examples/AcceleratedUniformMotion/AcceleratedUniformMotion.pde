float x;         // current X coordinate
float y;         // fixed Y coordinate
float speed;     // current speed
float acceleration = 0.05;  // Constant acceleration
int[] fillColor = {0, 150, 255};  // Ball color
boolean bouncing = false; // If the ball is bouncing (left-right motion)

void setup() {
  size(600, 400);
  x = 0;
  y = height / 2;
  speed = 0;  // Initial speed is 0
}

void draw() {
  background(240);
  
  // Update speed based on acceleration
  speed += acceleration;
  
  // Update position: motion with acceleration
  x += speed;
  
  // If bouncing mode is enabled, reverse direction at edges
  if (bouncing) {
    if (x >= width - 15 || x <= 15) {  // Adjusted to account for ball radius
      speed = -speed;  // Reverse direction when hitting edges
    }
  } else {
    // If the ball reaches the right edge, reset to the left
    if (x > width) {
      x = 0;
      speed = abs(speed); // Always move right if reset
    } else if (x < 0) {
      x = width; // Reset to right edge if ball goes too far left
      speed = -abs(speed); // Always move left if reset
    }
  }
  
  // Draw the ball with dynamic color based on speed
  fill(fillColor[0], fillColor[1], fillColor[2]);
  ellipse(x, y, 30, 30);
  
  // Display information (HUD)
  drawHUD();
  displayInstructions();
}

void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 100, 10);  // Background for HUD
  fill(255);
  textSize(14);
  text("Accelerated Motion", 20, 30);
  textSize(12);
  text("X Position: " + nf(x, 1, 2), 20, 50);  // Display X position of the ball
  text("Speed: " + nf(speed, 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);  // Display speed with direction
  text("Acceleration: " + nf(acceleration, 1, 2), 20, 80);  // Display acceleration
}

void keyPressed() {
  if (keyCode == LEFT) {
    acceleration -= 0.01; // Decrease acceleration when left arrow is pressed
  } else if (keyCode == RIGHT) {
    acceleration += 0.01; // Increase acceleration when right arrow is pressed
  }
}

void displayInstructions() {
  fill(100);
  textSize(12);
  text("Press Left arrow to decrease acceleration", 20, height - 60);
  text("Press Right arrow to increase acceleration", 20, height - 40);
}
