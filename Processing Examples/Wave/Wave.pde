float startAngle = 0;
float angleVel = 0.23;
float amplitude = 150; 
float frequency = 3;
float phaseShift = 0; 

void setup() {
  size(600, 600);
  frameRate(60); 
}

void draw() {
  background(255);

  float period = 1 / frequency;  
  angleVel = 2 * PI * frequency / 60; 

  startAngle += angleVel;
  float angle = startAngle + phaseShift;

  int prevX = 0;
  float prevY = height / 2 + map(sin(angle), -1, 1, -amplitude, amplitude);
  
  stroke(0);
  strokeWeight(2);
  
  for (int x = 0; x <= width; x++) {
    float y = height / 2 + map(sin(angle), -1, 1, -amplitude, amplitude);
    
    line(prevX, (int)prevY, x, (int)y);
    
    prevX = x;
    prevY = y;
    
    angle += angleVel;
  }

  drawHUD(period, frequency, amplitude);
}
