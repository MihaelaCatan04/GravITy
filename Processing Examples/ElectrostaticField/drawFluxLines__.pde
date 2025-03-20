void drawFluxLines() {
  for (ArrayList<PVector> line : fluxLines) {
    if (line.size() < 300) {  // Max length of flux line
      PVector current = line.get(line.size() - 1);
      PVector e = E(current).mult(1e15);
      float len = constrain(e.mag(), 3, 10);
      e.setMag(len);

      PVector next = PVector.add(current, e);
      if (isInside(next) && !isNearNegativeCharge(next)) {
        line.add(next);
      }
    }

    noFill();
    stroke(255, 204, 0, 150);
    beginShape();
    for (PVector p : line) {
      vertex(p.x, p.y);
    }
    endShape();
  }
}
