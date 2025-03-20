void drawBall() {
  float distFromBase = ballX - planeX;
  float ballWorldY = planeY - distFromBase * tan(angle);
  
  float rotationAngle = -distFromBase / ballRadius;
  
  pushMatrix();
  translate(ballX, ballWorldY);
  
  fill(255, 50, 50);
  stroke(0);
  strokeWeight(2);
  ellipse(0, 0, ballRadius * 2, ballRadius * 2);
  
  rotate(rotationAngle);
  stroke(0);
  line(0, 0, 0, -ballRadius);
  
  popMatrix();
}
