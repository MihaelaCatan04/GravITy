void mousePressed() {
  if (dist(mouseX, mouseY, obj1X, obj1Y) < radius1) {
    dragging1 = true;
  } else if (dist(mouseX, mouseY, obj2X, obj2Y) < radius2) {
    dragging2 = true;
  }
}
