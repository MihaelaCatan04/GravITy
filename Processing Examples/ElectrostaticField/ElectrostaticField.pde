int RAD = 100;  // Particle Radius
float e0 = 8.854187e-12;
ArrayList<Particle> particles = new ArrayList<>();
ArrayList<ArrayList<PVector>> fluxLines = new ArrayList<>();
Particle selected = null;
boolean dragging = false;
int fluxResolution = 10; 

void setup() {
  size(800, 600);
  particles.add(new Particle(width / 3, height / 2, 1.602176e-19));  // Positive Charge
  particles.add(new Particle(2 * width / 3, height / 2, -1.602176e-19));  // Negative Charge
  generateFluxLines();
}

void draw() {
  background(0);
  drawField();
  drawFluxLines();
  
  for (Particle p : particles) {
    p.display();
  }
  
  drawHUD(); // Display instructions and particle info
}

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

void generateFluxLines() {
  fluxLines.clear();

  for (Particle p : particles) {
    if (p.charge > 0) {  // Only positive charges create flux lines
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

boolean isNearNegativeCharge(PVector pos) {
  for (Particle p : particles) {
    if (p.charge < 0 && PVector.dist(pos, p.pos) < RAD / 2) {
      return true;
    }
  }
  return false;
}

boolean isInside(PVector pos) {
  return pos.x > 0 && pos.x < width && pos.y > 0 && pos.y < height;
}

void mousePressed() {
  for (Particle p : particles) {
    if (p.isMouseOver(mouseX, mouseY)) {
      selected = p;
      dragging = true;
      break;
    }
  }
}

void mouseDragged() {
  if (dragging && selected != null) {
    selected.pos.set(mouseX, mouseY);
    generateFluxLines();  // Regenerate flux lines during dragging
  }
}

void mouseReleased() {
  dragging = false;
  selected = null;
}

void keyPressed() {
  if (key == '+') {
    particles.add(new Particle(random(width), random(height), 1.602176e-19));
    generateFluxLines();
  } else if (key == '-') {
    particles.add(new Particle(random(width), random(height), -1.602176e-19));
    generateFluxLines();
  } else if (key == '0') {
    if (!particles.isEmpty()) {
      particles.remove(particles.size() - 1);
      generateFluxLines();
    }
  }
}

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

// HUD Display in the Top-Left Corner
void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 110, 10);

  fill(255);
  textSize(14);
  text("Electric Field Simulator", 20, 30);
  
  textSize(12);
  text("Press '+' to add a positive charge", 20, 50);
  text("Press '-' to add a negative charge", 20, 65);
  text("Press '0' to remove last charge", 20, 80);
  text("Drag charges to move them", 20, 95);
  text("Total Particles: " + particles.size(), 20, 110);
}
