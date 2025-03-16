class Mover {

  // position, velocity, and acceleration 
  PVector position;
  PVector velocity;
  PVector acceleration;

  // Mass is tied to size
  float mass;
  float bounce = 1.0;
  int[] fillColor;

  Mover(float m, float x, float y, int rC, int gC, int bC) {
    mass = m;
    position = new PVector(x-10, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    fillColor = new int[]{rC, gC, bC};
  }

  // Newton's 2nd law: F = M * A
  // or A = F / M
  void applyForce(PVector force) {
    // Divide by mass 
    PVector f = PVector.div(force, mass);
    // Accumulate all forces in acceleration
    acceleration.add(f);
  }

  void update() {

    // Velocity changes according to acceleration
    velocity.add(acceleration);
    // position changes by velocity
    position.add(velocity);
    // We must clear acceleration each frame
    acceleration.mult(0);
  }

  // Draw Mover
  void display() {
    stroke(0);
    strokeWeight(2);
    fill(fillColor[0], fillColor[1], fillColor[2]);
    ellipse(position.x, position.y, mass*16, mass*16);
  }

  // Bounce off bottom of window
  void checkEdges() {
    if (position.y > height) {
      velocity.y *= -0.9;  // A little dampening when hitting the bottom
      position.y = height;
    }
  }
}
