void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 100, 10);
  fill(255);
  textSize(14);
  text("Accelerated Motion", 20, 30);
  textSize(12);
  text("X Position: " + nf(x, 1, 2), 20, 50);
  text("Speed: " + nf(speed, 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);
  text("Acceleration: " + nf(acceleration, 1, 3), 20, 80);
}
