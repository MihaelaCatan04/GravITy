float earthX, earthY;
float moonX, moonY;
float G = 6.674e-11; 
float massEarth = 5.972e24; 
float massMoon = 7.348e22; 
boolean dragging = false;

void setup() {
  size(600, 600);
  earthX = width / 3;
  earthY = height / 2;
  moonX = earthX + 200;
  moonY = earthY;
}

void draw() {
  background(240);
  float dx = moonX - earthX;
  float dy = moonY - earthY;
  float distance = sqrt(dx * dx + dy * dy);
  float force = (G * massEarth * massMoon) / (distance * distance);
  fill(0, 100, 255);
  ellipse(earthX, earthY, 80, 80);
  fill(200);
  ellipse(moonX, moonY, 30, 30);
  fill(0);
  textSize(14);
  text("Earth Mass: " + massEarth + " kg", 20, 20);
  text("Moon Mass: " + massMoon + " kg", 20, 40);
  text("Distance: " + int(distance) + " px", 20, 60);
  text("Gravity Force: " + force + " N", 20, 80);
}
