void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 110, 10);

  fill(255);
  textSize(14);
  text("Electric Field Simulator", 20, 30);
  
  textSize(12);
  text("Press '+' to add a positive charge", 20, 50);
  text("Press '-' to add a negative charge", 20, 65);
  text("Press '0' to remove last charge", 20, 80);
  text("Drag charges to move them", 20, 95);
  text("Total Particles: " + particles.size(), 20, 110);
}
