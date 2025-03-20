float x;
float y;
float speed;
float acceleration = 0.005;  
int[] fillColor = {0, 150, 255}; 

void setup() {
  size(600, 600);
  x = 0;
  y = height / 2;
  speed = 0;
}

void draw() {
  background(240);
  speed += acceleration;
  x += speed;  
    if (x > width) {
      x = 0;
      speed = abs(speed);
    } else if (x < 0) {
      x = width;
      speed = -abs(speed);
    }
  
  fill(fillColor[0], fillColor[1], fillColor[2]);
  ellipse(x, y, 30, 30);
  drawHUD();
  displayInstructions();
}
