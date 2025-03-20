boolean isNearNegativeCharge(PVector pos) {
  for (Particle p : particles) {
    if (p.charge < 0 && PVector.dist(pos, p.pos) < RAD / 2) {
      return true;
    }
  }
  return false;
}
