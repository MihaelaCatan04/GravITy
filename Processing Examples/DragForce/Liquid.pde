// Liquid class 
class Liquid {

  // Liquid is a rectangle
  float x, y, w, h;
  // Coefficient of drag
  float c;
  int[] fillColor;

  Liquid(float x_, float y_, float w_, float h_, float c_, int rC, int gC, int bC) {
    x = x_;
    y = y_;
    w = w_;
    h = h_;
    c = c_;
    fillColor = new int[]{rC, gC, bC};
  }

  // Is the Mover in the Liquid?
  boolean contains(Mover m) {
    PVector l = m.position;
    return l.x > x && l.x < x + w && l.y > y && l.y < y + h;
  }

  // Calculate drag force
  PVector drag(Mover m) {
    // Magnitude is coefficient * speed squared
    float speed = m.velocity.mag();
    float dragMagnitude = c * speed * speed;

    // Direction is inverse of velocity
    PVector dragForce = m.velocity.get();
    dragForce.mult(-1);

    // Scale according to magnitude
    dragForce.normalize();
    dragForce.mult(dragMagnitude);
    return dragForce;
  }

  void display() {
    noStroke();
    fill(fillColor[0], fillColor[1], fillColor[2]);
    rect(x, y, w, h);
  }
}
