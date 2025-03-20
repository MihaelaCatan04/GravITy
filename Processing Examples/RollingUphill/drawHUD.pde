void drawHUD() {
  fill(50, 50, 50, 200);
  stroke(0);
  rect(10, 10, 230, 210, 10); 
  fill(255);
  textSize(14);
  text("Physics Simulation", 20, 30);
  textSize(12);
  text("Angle: " + nf(degrees(angle), 0, 1) + "°", 20, 50);
  text("Velocity: " + nf(ballVx, 0, 2) + " m/s", 20, 70);
  text("Position: (" + nf(ballX, 0, 1) + ", " + nf(ballY, 0, 1) + ")", 20, 90);
  text("Gravity: " + nf(g, 0, 2), 20, 110);
  text("Friction: " + nf(mu, 0, 2), 20, 130);
  text("Restitution: " + nf(restitution, 0, 2), 20, 150);
  text("Click and drag the ball to reposition", 20, 170);
  text("Click below the incline to adjust angle: " + nf(degrees(angle), 0, 1) + "°", 20, 190);
}
