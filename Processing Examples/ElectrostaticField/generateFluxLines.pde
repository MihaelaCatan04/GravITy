void generateFluxLines() {
  fluxLines.clear();

  for (Particle p : particles) {
    if (p.charge > 0) { 
      float angleStep = TWO_PI / fluxResolution;
      for (int i = 0; i < fluxResolution; i++) {
        ArrayList<PVector> line = new ArrayList<>();
        PVector start = PVector.fromAngle(angleStep * i).mult(RAD / 2).add(p.pos);
        line.add(start);
        fluxLines.add(line);
      }
    }
  }
}
