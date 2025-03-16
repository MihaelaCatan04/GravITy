float angle = 0;         // current angle (in radians)
float radius = 100;      // radius of the circle
float cx, cy;            // coordinates of the circle's center
float angularSpeed = 0.02; // angular velocity
int[] fillColor = {0, 150, 255};
float ballRadius = 30;
void setup() {
  size(600, 400);
  cx = width / 2;
  cy = height / 2;
}

void draw() {
  background(240);
  
  // Draw the ball moving along the circle
  fill(fillColor[0], fillColor[1], fillColor[2]);
  float x = cx + radius * cos(angle);
  float y = cy + radius * sin(angle);
  ellipse(x, y, ballRadius, ballRadius);
  
  // Update the angle for circular motion
  angle += angularSpeed;
  
  // Display information (HUD)
  drawHUD();
  displayInstructions();
}

void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 100, 10);  // Background for HUD
  fill(255);
  textSize(14);
  text("Circular Motion", 20, 30);
  textSize(12);
  text("Angle: " + nf(angle, 1, 2) + " radians", 20, 50);  // Display angle
  text("Angular Speed: " + nf(angularSpeed, 1, 4), 20, 65);  // Display angular speed
  text("Radius: " + nf(radius, 1, 2), 20, 80);  // Display radius
}

void keyPressed() {
  if (keyCode == LEFT) {
    angularSpeed -= 0.005; // Decrease angular speed when left arrow is pressed
  } else if (keyCode == RIGHT) {
    angularSpeed += 0.005; // Increase angular speed when right arrow is pressed
  }
}

void displayInstructions() {
  fill(100);
  textSize(12);
  text("Press Left arrow to decrease angular speed", 20, height - 60);
  text("Press Right arrow to increase angular speed", 20, height - 40);
}
