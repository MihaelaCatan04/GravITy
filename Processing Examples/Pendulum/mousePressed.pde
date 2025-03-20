void mousePressed() {
  float d = dist(mouseX, mouseY, bob.x, bob.y);
  if (d < ballRadius) {
    dragging = true;
    angleV = 0;
  }
}
