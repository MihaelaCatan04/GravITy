void drawField() {
  int resolution = 50;
  for (int i = resolution; i < width; i += resolution) {
    for (int j = resolution; j < height; j += resolution) {
      PVector pos = new PVector(i, j);
      PVector e = E(pos).mult(1e15);  
      float len = constrain(e.mag(), 6, 15);
      e.setMag(len);

      stroke(200, 255, 255, 100);
      line(i, j, i + e.x, j + e.y);
    }
  }
}
