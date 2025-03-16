float r = 400;          // Length of pendulum
float angle = PI/4;     // Initial angle
float angleV = 0;       // Angular velocity
float angleA = 0;       // Angular acceleration
float g = 9.8;          // Gravitational constant
float damping = 0.995;  // Damping factor (air resistance)
float ballRadius = 30;  // Radius of the bob

PVector origin;         // Pendulum pivot point
PVector bob;            // Position of the pendulum bob

ArrayList<PVector> trail = new ArrayList<PVector>(); // Trail of pendulum bob
int maxTrail = 100;     // Maximum length of trail

boolean dragging = false; // Is user dragging the pendulum?
boolean running = true;   // Is simulation running?

void setup() {
  size(800, 600);
  origin = new PVector(width/2, 100);
  bob = new PVector();
  strokeWeight(2);
  
  // Initialize bob position
  updateBobPosition();
}

void draw() {
  background(240);
  
  if (dragging) {
    // If dragging, update pendulum to follow mouse
    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, origin);
    
    // Constrain to pendulum length
    dir.setMag(r);
    bob.x = origin.x + dir.x;
    bob.y = origin.y + dir.y;
    
    // Calculate the angle
    angle = atan2(dir.x, dir.y);
    
    // Clear trail during dragging
    trail.clear();
    
    // Show dragline
    stroke(200, 0, 0, 100);
    line(origin.x, origin.y, mouseX, mouseY);
  } else if (running) {
    // Normal pendulum physics
    // Calculate forces on pendulum
    // F = mg*sin(angle) => a = g*sin(angle)/r
    angleA = -g / r * sin(angle);  // Angular acceleration
    
    // Update angular velocity and position with damping
    angleV += angleA;
    angleV *= damping;
    angle += angleV;
    
    // Update bob position
    updateBobPosition();
    
    // Add current position to trail
    trail.add(new PVector(bob.x, bob.y));
    if (trail.size() > maxTrail) {
      trail.remove(0);
    }
  }
  
  // Draw pendulum
  stroke(0);
  line(origin.x, origin.y, bob.x, bob.y);  // Pendulum rod
  
  // Draw trail
  noFill();
  beginShape();
  stroke(100, 100, 255, 150);
  for (PVector v : trail) {
    vertex(v.x, v.y);
  }
  endShape();
  
  // Draw bob
  fill(dragging ? color(255, 0, 0) : color(200, 0, 0));
  noStroke();
  ellipse(bob.x, bob.y, ballRadius*2, ballRadius*2);
  
  // Draw pivot
  fill(0);
  ellipse(origin.x, origin.y, 10, 10);
  
  // Display data
  fill(0);
  textSize(16);
  text("Pendulum Length: " + r + " m", 20, 30);
  text("Gravity: " + g + " m/s²", 20, 50);
  text("Current Angle: " + nf(degrees(angle), 0, 2) + "°", 20, 70);
  text("Angular Velocity: " + nf(angleV, 0, 4) + " rad/s", 20, 90);
  
  // Calculate and display energy
  float potentialE = g * r * (1 - cos(angle));
  float kineticE = 0.5 * angleV * angleV * r * r;
  float totalE = potentialE + kineticE;
  
  text("Potential Energy: " + nf(potentialE, 0, 2), width - 300, 30);
  text("Kinetic Energy: " + nf(kineticE, 0, 2), width - 300, 50);
  text("Total Energy: " + nf(totalE, 0, 2), width - 300, 70);
  
  // Instructions
  fill(0, 100, 0);
  text("Click and drag pendulum to set position, release to start", width/2 - 200, height - 30);
  text("Press SPACE to pause/resume simulation", width/2 - 150, height - 10);
}

// Update bob position based on current angle
void updateBobPosition() {
  bob.x = origin.x + r * sin(angle);
  bob.y = origin.y + r * cos(angle);
}

// When mouse is pressed, check if bob is clicked
void mousePressed() {
  // Check if mouse is near the bob
  float d = dist(mouseX, mouseY, bob.x, bob.y);
  if (d < ballRadius) {
    dragging = true;
    // Stop physics while dragging
    angleV = 0;
  }
}

// While dragging, update the pendulum angle
void mouseDragged() {
  // Handled in draw()
}

// When mouse is released, start the pendulum motion
void mouseReleased() {
  if (dragging) {
    dragging = false;
    // Start with zero velocity
    angleV = 0;
  }
}

// Space bar to pause/resume
void keyPressed() {
  if (key == ' ') {
    running = !running;
  }
}
