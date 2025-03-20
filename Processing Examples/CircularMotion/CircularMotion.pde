float angle = 0;
float radius = 100;
float cx, cy;
float angularSpeed = 0.02;
int[] fillColor = {0, 150, 255};
float ballRadius = 30;

void setup() {
  size(600, 600);
  cx = width / 2;
  cy = height / 2;
}

void draw() {
  background(240);
  fill(fillColor[0], fillColor[1], fillColor[2]);
  float x = cx + radius * cos(angle);
  float y = cy + radius * sin(angle);
  ellipse(x, y, ballRadius, ballRadius);
  angle += angularSpeed;
  drawHUD();
  displayInstructions();
}
