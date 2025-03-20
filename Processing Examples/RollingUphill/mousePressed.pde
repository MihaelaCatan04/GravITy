void mousePressed() {
  float distFromBase = ballX - planeX;
  float ballWorldY = planeY - distFromBase * tan(angle);
  
  if (dist(mouseX, mouseY, ballX, ballWorldY) < ballRadius) {
    isDragging = true;
  }
}
