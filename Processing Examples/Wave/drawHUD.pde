void drawHUD(float period, float frequency, float amplitude) {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 100, 10); 

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
