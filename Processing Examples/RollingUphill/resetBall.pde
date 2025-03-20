void resetBall() {
  float planeProjectedLength = planeLength * cos(angle);
  ballX = planeX + planeProjectedLength * 0.25;
  float distFromBase = ballX - planeX;
  ballY = planeY - distFromBase * tan(angle);
  ballVx = 0;
}
