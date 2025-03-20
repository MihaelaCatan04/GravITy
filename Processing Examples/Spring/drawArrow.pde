void drawArrow(float x1, float y1, float x2, float y2, float arrowSize) {
  line(x1, y1, x2, y2);
  pushMatrix();
  translate(x2, y2);
  float a = atan2(y2-y1, x2-x1);
  rotate(a);
  line(0, 0, -arrowSize, -arrowSize/2);
  line(0, 0, -arrowSize, arrowSize/2);
  popMatrix();
}
