float earthX, earthY;
float moonX, moonY;
float G = 6.674e-11;  // Universal gravitational constant
float massEarth = 5.972e24; // kg
float massMoon = 7.348e22; // kg
boolean dragging = false;

void setup() {
  size(800, 400);
  earthX = width / 3;
  earthY = height / 2;
  moonX = earthX + 200;
  moonY = earthY;
}

void draw() {
  background(240);
  
  // Compute distance
  float dx = moonX - earthX;
  float dy = moonY - earthY;
  float distance = sqrt(dx * dx + dy * dy);
  
  // Compute gravitational force
  float force = (G * massEarth * massMoon) / (distance * distance);
  
  // Draw Earth
  fill(0, 100, 255);
  ellipse(earthX, earthY, 80, 80);
  
  // Draw Moon
  fill(200);
  ellipse(moonX, moonY, 30, 30);
  
  // Display information
  fill(0);
  textSize(14);
  text("Earth Mass: " + massEarth + " kg", 20, 20);
  text("Moon Mass: " + massMoon + " kg", 20, 40);
  text("Distance: " + int(distance) + " px", 20, 60);
  text("Gravity Force: " + force + " N", 20, 80);
}

// Allow dragging the Moon
void mousePressed() {
  if (dist(mouseX, mouseY, moonX, moonY) < 15) {
    dragging = true;
  }
}

void mouseDragged() {
  if (dragging) {
    moonX = mouseX;
    moonY = mouseY;
  }
}

void mouseReleased() {
  dragging = false;
}
