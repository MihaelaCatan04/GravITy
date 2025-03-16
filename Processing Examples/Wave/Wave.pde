float startAngle = 0;
float angleVel = 0.23;
float amplitude = 150;  // Amplitude of the sine wave
float frequency = 3;  // Frequency of the sine wave (cycles per second)
float phaseShift = 0;   // Horizontal shift of the sine wave

void setup() {
  size(640, 360);
  frameRate(60);  // Set the frame rate
}

void draw() {
  background(255);

  // Period and Frequency calculations
  float period = 1 / frequency;  // Period (time per cycle)
  angleVel = 2 * PI * frequency / 60;  // Angle velocity based on frequency and frame rate

  startAngle += angleVel;
  float angle = startAngle + phaseShift;

  // Draw the sine wave curve
  int prevX = 0;
  float prevY = height / 2 + map(sin(angle), -1, 1, -amplitude, amplitude);
  
  stroke(0);
  strokeWeight(2);
  
  for (int x = 0; x <= width; x++) {
    // Calculate the y position based on the sine function
    float y = height / 2 + map(sin(angle), -1, 1, -amplitude, amplitude);
    
    // Draw line segments to form the sine wave
    line(prevX, (int)prevY, x, (int)y);  // Casting to int for drawing
    
    // Update previous position for next line segment
    prevX = x;
    prevY = y;
    
    angle += angleVel;
  }

  // Display the HUD
  drawHUD(period, frequency, amplitude);
}

void drawHUD(float period, float frequency, float amplitude) {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 100, 10);  // Background for HUD

  fill(255);
  textSize(14);
  text("Sine Wave Animation", 20, 30);

  textSize(12);
  text("startAngle: " + nf(startAngle, 1, 2), 20, 50);
  text("angleVel: " + nf(angleVel, 1, 2), 20, 65);
  text("Period (s): " + nf(period, 1, 2), 20, 80);
  text("Frequency (Hz): " + nf(frequency, 1, 2), 20, 95);
  text("Amplitude: " + nf(amplitude, 1, 2), 20, 110);
}
