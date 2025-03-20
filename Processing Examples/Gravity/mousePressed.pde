void mousePressed() {
  if (dist(mouseX, mouseY, moonX, moonY) < 15) {
    dragging = true;
  }
}
