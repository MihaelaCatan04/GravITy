PVector E(PVector pos) {
  PVector result = new PVector(0, 0);
  for (Particle p : particles) {
    PVector r = PVector.sub(pos, p.pos);
    float rMag = r.mag();
    if (rMag > RAD / 2) {
      r.normalize();
      r.mult((float) (p.charge / (rMag * rMag)));
      result.add(r);
    }
  }
  return result.div((float) (4 * PI * e0));
}
