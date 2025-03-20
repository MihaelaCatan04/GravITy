void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 150, 10);

  fill(255);
  textSize(14);
  text("Liquid Simulator", 20, 30);

  textSize(12);
  text("Drag Coefficient: " + dragCoefficient, 20, 50);
  text("Number of Movers: " + movers.length, 20, 65);

  text("Click to Reset", 20, 130);
}
