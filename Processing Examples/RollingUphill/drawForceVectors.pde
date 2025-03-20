void drawForceVectors() {
  float sinAngle = sin(angle);
  float cosAngle = cos(angle);
  
  float distFromBase = ballX - planeX;
  float ballWorldY = planeY - distFromBase * tan(angle);
  
  stroke(0, 0, 255);
  strokeWeight(2);
  float gravityScale = 50;
  drawArrow(ballX, ballWorldY, ballX, ballWorldY + gravityScale, 8);
  fill(0, 0, 255);
  text("Gravity", ballX + 5, ballWorldY + gravityScale/2);
  
  if (ballVx != 0) {
    stroke(255, 0, 0);
    float frictionScale = 30;
    float frictionX = -frictionScale * sign(ballVx) * cosAngle;
    float frictionY = frictionScale * sign(ballVx) * sinAngle;
    drawArrow(ballX, ballWorldY, ballX + frictionX, ballWorldY + frictionY, 8);
    fill(255, 0, 0);
    text("Friction", ballX + frictionX/2, ballWorldY + frictionY/2 - 10);
  }
  
  stroke(0, 255, 0);
  float parallelScale = 40 * sinAngle;
  float parallelX = parallelScale * cosAngle;
  float parallelY = parallelScale * sinAngle;
  drawArrow(ballX, ballWorldY, ballX - parallelX, ballWorldY - parallelY, 8);
  fill(0, 255, 0);
  text("Force down plane", ballX + parallelX/2, ballWorldY + parallelY/2 - 10);
}
