void mouseDragged() {
  if (dragging1) {
    obj1X = mouseX;
    obj1Y = mouseY;
    position1.set(obj1X, obj1Y);
    velocity1.set(0, 0);
  } else if (dragging2) {
    obj2X = mouseX;
    obj2Y = mouseY;
    position2.set(obj2X, obj2Y);
    velocity2.set(0, 0);
  }
}
