float x;   
float y;      
float speed;
int[] fillColor = {0, 150, 255}; 
float radius = 50;
boolean bouncing = false;

void setup() {
  size(600, 600);
  x = 0;
  y = height / 2;
  speed = 2; 
}

void draw() {
  background(240);

  x += speed;
  
  if (bouncing) {
    if (x >= width - radius || x <= radius) { 
      speed = -speed; 
    }
  } else {
    if (x > width) {
      x = 0;
      speed = abs(speed);
    } else if (x < 0) {
      x = width; 
      speed = -abs(speed); 
    }
  }
  
  fill(fillColor[0], fillColor[1], fillColor[2]);
  ellipse(x, y, radius, radius);
  
  drawHUD();
  displayInstructions();
}
