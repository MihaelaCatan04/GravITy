float x;         // current X coordinate
float y;         // fixed Y coordinate
float speed;     // constant speed
int[] fillColor = {0, 150, 255};  // Ball color
float radius = 50;
boolean bouncing = false;

void setup() {
  size(600, 400);
  x = 0;
  y = height / 2;
  speed = 2;  // Initial speed of motion
}

void draw() {
  background(240);
  
  // Update position: uniform motion
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
  ellipse(x, y, radius, radius);
  
  // Display information (HUD)
  drawHUD();
  displayInstructions();
}

void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 80, 10);  // Background for HUD
  fill(255);
  textSize(14);
  text("Uniform Motion", 20, 30);
  textSize(12);
  text("X Position: " + nf(x, 1, 2), 20, 50);  // Display X position of the ball
  text("Speed: " + nf(abs(speed), 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);  // Display speed with direction
}

void keyPressed() {
  if (keyCode == LEFT) {
    speed -= 0.5; // Decrease speed when left arrow is pressed
  } else if (keyCode == RIGHT) {
    speed += 0.5; // Increase speed when right arrow is pressed
  }
  
}

void displayInstructions() {
  fill(100);
  textSize(12);
  text("Press Left arrow to decrease speed", 20, height - 60);
  text("Press Right arrow to increase speed", 20, height - 40);
}
