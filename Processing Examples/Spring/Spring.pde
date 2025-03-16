// Spring Compression & Elastic Force Simulation
// Drag the ball to compress the spring and release to launch

// Physics constants
float springConstant = 0.1;  // Spring stiffness
float damping = 0.98;        // Damping factor (energy loss)
float restLength = 150;      // Spring rest length
float floorFriction = 0.99;  // Friction with floor

// Ball properties
float ballRadius = 30;
float ballMass = 1;
PVector ballPosition;
PVector ballVelocity;
boolean isDragging = false;

// Spring properties
PVector anchorPosition;
float springWidth = 20;      // Visual width of spring coils
int numCoils = 10;           // Number of spring coils

// Launch tracker
boolean hasLaunched = false;
ArrayList<PVector> trajectoryPoints = new ArrayList<PVector>();

void setup() {
  size(800, 800);
  
  // Set initial positions
  anchorPosition = new PVector(100, height/2);
  ballPosition = new PVector(anchorPosition.x + restLength, height/2);
  ballVelocity = new PVector(0, 0);
}

void draw() {
  background(240);
  
  // Draw floor
  fill(200);
  rect(0, height-20, width, 20);
  
  // Calculate spring force
  float displacement = PVector.dist(anchorPosition, ballPosition) - restLength;
  PVector springDirection = PVector.sub(anchorPosition, ballPosition);
  springDirection.normalize();
  
  // Apply spring force if not dragging
  if (!isDragging) {
    PVector springForce = PVector.mult(springDirection, springConstant * displacement);
    PVector acceleration = PVector.div(springForce, ballMass);
    ballVelocity.add(acceleration);
    
    // Apply damping
    ballVelocity.mult(damping);
    
    // Update position
    ballPosition.add(ballVelocity);
    
    // Handle floor collision
    if (ballPosition.y > height - 20 - ballRadius) {
      ballPosition.y = height - 20 - ballRadius;
      ballVelocity.y *= -0.9; // Bounce
      ballVelocity.x *= floorFriction; // Friction
    }
    
    // Track trajectory after launch
    if (hasLaunched && frameCount % 3 == 0 && trajectoryPoints.size() < 50) {
      trajectoryPoints.add(ballPosition.copy());
    }
  }
  
  // Draw anchor point
  fill(100);
  stroke(0);
  strokeWeight(2);
  rect(anchorPosition.x-15, anchorPosition.y-40, 30, 80);
  
  // Draw trajectory
  if (hasLaunched) {
    noFill();
    strokeWeight(1);
    stroke(100, 200, 100, 150);
    for (int i = 0; i < trajectoryPoints.size()-1; i++) {
      line(trajectoryPoints.get(i).x, trajectoryPoints.get(i).y, 
           trajectoryPoints.get(i+1).x, trajectoryPoints.get(i+1).y);
    }
  }
  
  // Draw spring
  drawSpring(anchorPosition.x, anchorPosition.y, ballPosition.x, ballPosition.y);
  
  // Draw ball
  fill(50, 200, 50);
  stroke(0);
  strokeWeight(2);
  ellipse(ballPosition.x, ballPosition.y, ballRadius*2, ballRadius*2);
  
  // Draw force vectors
  if (!isDragging) {
    // Spring force vector
    float forceScaling = 0.5;
    stroke(255, 0, 0);
    strokeWeight(2);
    float forceX = springDirection.x * springConstant * displacement * forceScaling;
    float forceY = springDirection.y * springConstant * displacement * forceScaling;
    drawArrow(ballPosition.x, ballPosition.y, 
             ballPosition.x + forceX, ballPosition.y + forceY, 8);
             
    fill(255, 0, 0);
    text("Spring Force", ballPosition.x + forceX/2, ballPosition.y + forceY/2 - 10);
    
    // Energy indicator
    fill(0);
    text("Spring Energy: " + nf(0.5 * springConstant * displacement * displacement, 0, 1), 20, 30);
    text("Kinetic Energy: " + nf(0.5 * ballMass * ballVelocity.magSq(), 0, 1), 20, 60);
  }
  
  // Instructions
  fill(0);
  textSize(16);
  if (!hasLaunched) {
    text("Drag the ball to compress or stretch the spring, then release", 20, 30);
  }
}

void drawSpring(float x1, float y1, float x2, float y2) {
  // Calculate spring parameters
  float springLength = dist(x1, y1, x2, y2);
  float angle = atan2(y2 - y1, x2 - x1);
  
  // Draw spring
  stroke(80);
  strokeWeight(3);
  
  // Gap between anchor and first coil, and ball and last coil
  float endGap = 10;
  
  // Start of spring (attached to anchor)
  line(x1, y1, x1 + endGap * cos(angle), y1 + endGap * sin(angle));
  
  // Coils
  float coilLength = springLength - 2 * endGap;
  float coilSpacing = coilLength / numCoils;
  
  for (int i = 0; i < numCoils; i++) {
    float startX = x1 + (endGap + i * coilSpacing) * cos(angle);
    float startY = y1 + (endGap + i * coilSpacing) * sin(angle);
    float midX = startX + (coilSpacing/2) * cos(angle) + springWidth * cos(angle + PI/2);
    float midY = startY + (coilSpacing/2) * sin(angle) + springWidth * sin(angle + PI/2);
    float endX = x1 + (endGap + (i+1) * coilSpacing) * cos(angle);
    float endY = y1 + (endGap + (i+1) * coilSpacing) * sin(angle);
    
    // Draw each coil as a bezier curve for smoother look
    bezier(startX, startY, 
           startX + coilSpacing/4 * cos(angle), startY + coilSpacing/4 * sin(angle), 
           midX - coilSpacing/4 * cos(angle), midY - coilSpacing/4 * sin(angle),
           midX, midY);
           
    bezier(midX, midY,
           midX + coilSpacing/4 * cos(angle), midY + coilSpacing/4 * sin(angle),
           endX - coilSpacing/4 * cos(angle), endY - coilSpacing/4 * sin(angle),
           endX, endY);
  }
  
  // End of spring (attached to ball)
  line(x1 + (endGap + numCoils * coilSpacing) * cos(angle), 
       y1 + (endGap + numCoils * coilSpacing) * sin(angle),
       x2, y2);
       
  // Visual indicator of rest length
  if (abs(springLength - restLength) > 5) {
    strokeWeight(1);
    stroke(100, 100, 255, 100);
    line(x1, y1, x1 + restLength * cos(angle), y1 + restLength * sin(angle));
    fill(100, 100, 255);
    text("Rest Length", x1 + restLength/2 * cos(angle), y1 + restLength/2 * sin(angle) - 10);
  }
}

void drawArrow(float x1, float y1, float x2, float y2, float arrowSize) {
  line(x1, y1, x2, y2);
  pushMatrix();
  translate(x2, y2);
  float a = atan2(y2-y1, x2-x1);
  rotate(a);
  line(0, 0, -arrowSize, -arrowSize/2);
  line(0, 0, -arrowSize, arrowSize/2);
  popMatrix();
}

void mousePressed() {
  // Check if mouse is on ball
  if (dist(mouseX, mouseY, ballPosition.x, ballPosition.y) < ballRadius) {
    isDragging = true;
    // Reset trajectory tracking
    hasLaunched = false;
    trajectoryPoints.clear();
  }
}

void mouseReleased() {
  if (isDragging) {
    isDragging = false;
    hasLaunched = true;
  }
}

void mouseDragged() {
  if (isDragging) {
    // Update ball position
    ballPosition.x = mouseX;
    ballPosition.y = mouseY;
    
    // Keep ball from going into anchor
    float minDist = 20;
    if (PVector.dist(ballPosition, anchorPosition) < minDist) {
      PVector dir = PVector.sub(ballPosition, anchorPosition);
      dir.normalize();
      ballPosition = PVector.add(anchorPosition, PVector.mult(dir, minDist));
    }
    
    // Reset velocity when dragging
    ballVelocity.x = 0;
    ballVelocity.y = 0;
  }
}
