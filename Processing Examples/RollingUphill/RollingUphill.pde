// Physics constants
float g = 0.1;         // Gravity strength
float mu = 0.5;       // Coefficient of friction
float restitution = 0.7; // Bounciness
float angle = PI/6;    // Incline angle (30 degrees)

// Ball properties
float ballRadius = 20;
float ballMass = 1;
float ballX, ballY;    // Position
float ballVx = 0;      // Velocity along incline
boolean isDragging = false;  // Is the ball being dragged?

// Plane properties
float planeLength = 600;
float planeHeight = 200;
float planeX, planeY;  // Base position of the plane

void setup() {
  size(800, 600);
  
  // Initialize plane position
  planeX = width/2 - planeLength/2;
  planeY = height/2 + planeHeight/2;
  
  // Initialize ball on the incline
  resetBall();
}

void draw() {
  background(240);
  
  // Allow angle adjustment (15-75 degrees)
  if (mousePressed && mouseY > height/2) {
    angle = map(mouseX, 0, width, PI/12, PI/2.5);
    resetBall();
  }
  
  // Calculate components
  float sinAngle = sin(angle);
  float cosAngle = cos(angle);
  
  // Calculate plane points
  float x1 = planeX;
  float y1 = planeY;
  float x2 = planeX + planeLength * cosAngle;
  float y2 = planeY - planeLength * sinAngle;
  float x3 = planeX + planeLength * cosAngle;
  float y3 = y2 + 20; // Thickness
  float x4 = planeX;
  float y4 = y1 + 20; // Thickness
  
  // Draw inclined plane
  fill(120);
  quad(x1, y1, x2, y2, x3, y3, x4, y4);
  
  // Physics - only apply if not dragging
  if (!isDragging) {
    // Component of gravity parallel to the incline
    float Fgp = ballMass * g * sinAngle;
    
    // Friction force (opposite direction of velocity)
    float normalForce = ballMass * g * cosAngle;
    float frictionForce = mu * normalForce;
    
    // Net force along the incline
    float netForce;
    if (ballVx == 0) {
      // Static case
      if (abs(Fgp) < frictionForce) {
        netForce = 0; // Ball doesn't move
      } else {
        netForce = Fgp - frictionForce * sign(Fgp);
      }
    } else {
      // Dynamic case
      netForce = Fgp - frictionForce * sign(ballVx);
    }
    
    // Apply acceleration
    float acceleration = netForce / ballMass;
    ballVx += acceleration;
    
    // Update position along incline
    ballX += ballVx;
    ballY -= ballVx * tanAngle(angle);
    
    // Check if ball reaches bottom of incline
    if (ballX < planeX + ballRadius / cosAngle) {
      ballX = planeX + ballRadius / cosAngle;
      ballVx *= -restitution; // Bounce
    }
    
    // Check if ball reaches top of incline
    float maxX = planeX + planeLength * cosAngle - ballRadius / cosAngle;
    if (ballX > maxX) {
      ballX = maxX;
      ballVx *= -restitution; // Bounce
    }
  }
  
  // Draw ball
  drawBall();
  
  // Draw force vectors
  if (!isDragging) {
    drawForceVectors();
  }
  
  // Draw HUD
  drawHUD();
 
}

void drawBall() {
  // Calculate actual coordinates on incline
  float distFromBase = ballX - planeX;
  float ballWorldY = planeY - distFromBase * tan(angle);
  
  // Draw rolling animation
  float rotationAngle = -distFromBase / ballRadius;
  
  pushMatrix();
  translate(ballX, ballWorldY);
  
  // Draw ball
  fill(255, 50, 50);
  stroke(0);
  strokeWeight(2);
  ellipse(0, 0, ballRadius * 2, ballRadius * 2);
  
  // Draw line to show rotation
  rotate(rotationAngle);
  stroke(0);
  line(0, 0, 0, -ballRadius);
  
  popMatrix();
}

void drawForceVectors() {
  float sinAngle = sin(angle);
  float cosAngle = cos(angle);
  
  // Convert ball position to screen coordinates
  float distFromBase = ballX - planeX;
  float ballWorldY = planeY - distFromBase * tan(angle);
  
  // Draw gravity vector (downward)
  stroke(0, 0, 255);
  strokeWeight(2);
  float gravityScale = 50;
  drawArrow(ballX, ballWorldY, ballX, ballWorldY + gravityScale, 8);
  fill(0, 0, 255);
  text("Gravity", ballX + 5, ballWorldY + gravityScale/2);
  
  // Draw friction vector (opposite to motion)
  if (ballVx != 0) {
    stroke(255, 0, 0);
    float frictionScale = 30;
    float frictionX = -frictionScale * sign(ballVx) * cosAngle;
    float frictionY = frictionScale * sign(ballVx) * sinAngle;
    drawArrow(ballX, ballWorldY, ballX + frictionX, ballWorldY + frictionY, 8);
    fill(255, 0, 0);
    text("Friction", ballX + frictionX/2, ballWorldY + frictionY/2 - 10);
  }
  
  // Draw component of gravity parallel to incline
  stroke(0, 255, 0);
  float parallelScale = 40 * sinAngle;
  float parallelX = parallelScale * cosAngle;
  float parallelY = parallelScale * sinAngle;
  drawArrow(ballX, ballWorldY, ballX - parallelX, ballWorldY - parallelY, 8);
  fill(0, 255, 0);
  text("Force down plane", ballX + parallelX/2, ballWorldY + parallelY/2 - 10);
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

void drawHUD() {
  fill(50, 50, 50, 200);
  stroke(0);
  rect(10, 10, 230, 210, 10);  // Background for HUD
  
  fill(255);
  textSize(14);
  text("Physics Simulation", 20, 30);

  textSize(12);
  text("Angle: " + nf(degrees(angle), 0, 1) + "°", 20, 50);
  text("Velocity: " + nf(ballVx, 0, 2) + " m/s", 20, 70);
  text("Position: (" + nf(ballX, 0, 1) + ", " + nf(ballY, 0, 1) + ")", 20, 90);
  text("Gravity: " + nf(g, 0, 2), 20, 110);
  text("Friction: " + nf(mu, 0, 2), 20, 130);
  text("Restitution: " + nf(restitution, 0, 2), 20, 150);
  text("Click and drag the ball to reposition", 20, 170);
  text("Click below the incline to adjust angle: " + nf(degrees(angle), 0, 1) + "°", 20, 190);
}

void mousePressed() {
  // Calculate actual coordinates on incline
  float distFromBase = ballX - planeX;
  float ballWorldY = planeY - distFromBase * tan(angle);
  
  // Check if mouse is on ball
  if (dist(mouseX, mouseY, ballX, ballWorldY) < ballRadius) {
    isDragging = true;
  }
}

void mouseReleased() {
  isDragging = false;
}

void mouseDragged() {
  if (isDragging) {
    // Calculate where on the inclined plane the mouse is
    float dx = mouseX - planeX;
    float dy = planeY - mouseY;
    
    // Project onto inclined plane
    float projectedDist = (dx * cos(angle) + dy * sin(angle));
    
    // Constrain to plane
    projectedDist = constrain(projectedDist, 
                          ballRadius / cos(angle), 
                          planeLength * cos(angle) - ballRadius / cos(angle));
    // Calculate new position
    ballX = planeX + projectedDist;
    
    // Reset velocity when dragging
    ballVx = 0;
  }
}

float sign(float val) {
  if (val > 0) return 1;
  if (val < 0) return -1;
  return 0;
}

float tanAngle(float a) {
  return tan(a);
}

void resetBall() {
  // Position ball 1/4 way up the incline
  float planeProjectedLength = planeLength * cos(angle);
  ballX = planeX + planeProjectedLength * 0.25;
  // Calculate Y position based on X
  float distFromBase = ballX - planeX;
  ballY = planeY - distFromBase * tan(angle);
  // Reset velocity
  ballVx = 0;
}
