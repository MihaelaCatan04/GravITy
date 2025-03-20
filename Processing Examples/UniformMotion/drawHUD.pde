void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 80, 10); 
  fill(255);
  textSize(14);
  text("Uniform Motion", 20, 30);
  textSize(12);
  text("X Position: " + nf(x, 1, 2), 20, 50);
  text("Speed: " + nf(abs(speed), 1, 2) + (speed < 0 ? " (left)" : " (right)"), 20, 65);
}
