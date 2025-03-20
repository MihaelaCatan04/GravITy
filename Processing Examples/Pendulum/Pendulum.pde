float r = 400;         
float angle = PI/4;    
float angleV = 0;      
float angleA = 0;     
float g = 9.8;         
float damping = 0.995; 
float ballRadius = 30;

PVector origin; 
PVector bob; 

ArrayList<PVector> trail = new ArrayList<PVector>();
int maxTrail = 100; 

boolean dragging = false;
boolean running = true; 

void setup() {
  size(600, 600);
  origin = new PVector(width/2, 100);
  bob = new PVector();
  strokeWeight(2);
  updateBobPosition();
}

void draw() {
  background(240);
  
  if (dragging) {
    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, origin);
    
    dir.setMag(r);
    bob.x = origin.x + dir.x;
    bob.y = origin.y + dir.y;
    
    angle = atan2(dir.x, dir.y);
    
    trail.clear();
    
    stroke(200, 0, 0, 100);
    line(origin.x, origin.y, mouseX, mouseY);
  } else if (running) {
    angleA = -g / r * sin(angle);  
    angleV += angleA;
    angleV *= damping;
    angle += angleV;
    
    updateBobPosition();
    
    trail.add(new PVector(bob.x, bob.y));
    if (trail.size() > maxTrail) {
      trail.remove(0);
    }
  }
  
  stroke(0);
  line(origin.x, origin.y, bob.x, bob.y); 
  noFill();
  beginShape();
  stroke(100, 100, 255, 150);
  for (PVector v : trail) {
    vertex(v.x, v.y);
  }
  endShape();
  
  fill(dragging ? color(255, 0, 0) : color(200, 0, 0));
  noStroke();
  ellipse(bob.x, bob.y, ballRadius*2, ballRadius*2);
  
  fill(0);
  ellipse(origin.x, origin.y, 10, 10);
  
  fill(0);
  textSize(16);
  text("Pendulum Length: " + r + " m", 20, 30);
  text("Gravity: " + g + " m/s²", 20, 50);
  text("Current Angle: " + nf(degrees(angle), 0, 2) + "°", 20, 70);
  text("Angular Velocity: " + nf(angleV, 0, 4) + " rad/s", 20, 90);
  
  float potentialE = g * r * (1 - cos(angle));
  float kineticE = 0.5 * angleV * angleV * r * r;
  float totalE = potentialE + kineticE;
  
  text("Potential Energy: " + nf(potentialE, 0, 2), width - 300, 30);
  text("Kinetic Energy: " + nf(kineticE, 0, 2), width - 300, 50);
  text("Total Energy: " + nf(totalE, 0, 2), width - 300, 70);
  
  fill(0, 100, 0);
  text("Click and drag pendulum to set position, release to start", width/2 - 200, height - 30);
  text("Press SPACE to pause/resume simulation", width/2 - 150, height - 10);
}
