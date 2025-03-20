class Particle {
  PVector pos;
  float charge;

  Particle(float x, float y, float q) {
    pos = new PVector(x, y);
    charge = q;
  }

  void display() {
    noStroke();
    if (charge > 0) {
      fill(255, 0, 0);
    } else {
      fill(0, 0, 255);
    }
    ellipse(pos.x, pos.y, RAD, RAD);
  }

  boolean isMouseOver(float mx, float my) {
    return dist(mx, my, pos.x, pos.y) < RAD / 2;
  }
}
