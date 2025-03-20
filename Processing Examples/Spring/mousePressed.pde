void mousePressed() {
  if (dist(mouseX, mouseY, ballPosition.x, ballPosition.y) < ballRadius) {
    isDragging = true;
    hasLaunched = false;
    trajectoryPoints.clear();
  }
}
