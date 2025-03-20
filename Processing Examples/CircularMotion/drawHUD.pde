void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 100, 10);
  fill(255);
  textSize(14);
  text("Circular Motion", 20, 30);
  textSize(12);
  text("Angle: " + nf(angle, 1, 2) + " radians", 20, 50);
  text("Angular Speed: " + nf(angularSpeed, 1, 4), 20, 65); 
  text("Radius: " + nf(radius, 1, 2), 20, 80); 
}
