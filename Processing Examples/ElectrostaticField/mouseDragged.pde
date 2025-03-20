void mouseDragged() {
  if (dragging && selected != null) {
    selected.pos.set(mouseX, mouseY);
    generateFluxLines();  // Regenerate flux lines during dragging
  }
}
