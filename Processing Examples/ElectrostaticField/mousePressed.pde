void mousePressed() {
  for (Particle p : particles) {
    if (p.isMouseOver(mouseX, mouseY)) {
      selected = p;
      dragging = true;
      break;
    }
  }
}
