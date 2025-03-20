float springConstant = 0.1; 
float damping = 0.98;  
float restLength = 150;  
float floorFriction = 0.99; 

float ballRadius = 30;
float ballMass = 1;
PVector ballPosition;
PVector ballVelocity;
boolean isDragging = false;

PVector anchorPosition;
float springWidth = 20;   
int numCoils = 10;   

boolean hasLaunched = false;
ArrayList<PVector> trajectoryPoints = new ArrayList<PVector>();

void setup() {
  size(600, 600);
  anchorPosition = new PVector(100, height/2);
  ballPosition = new PVector(anchorPosition.x + restLength, height/2);
  ballVelocity = new PVector(0, 0);
}

void draw() {
  background(240);
  fill(200);
  rect(0, height-20, width, 20);
  
  float displacement = PVector.dist(anchorPosition, ballPosition) - restLength;
  PVector springDirection = PVector.sub(anchorPosition, ballPosition);
  springDirection.normalize();
  
  if (!isDragging) {
    PVector springForce = PVector.mult(springDirection, springConstant * displacement);
    PVector acceleration = PVector.div(springForce, ballMass);
    ballVelocity.add(acceleration);
    
    ballVelocity.mult(damping);
    
    ballPosition.add(ballVelocity);
    
    if (ballPosition.y > height - 20 - ballRadius) {
      ballPosition.y = height - 20 - ballRadius;
      ballVelocity.y *= -0.9;
      ballVelocity.x *= floorFriction;
    }
    
    if (hasLaunched && frameCount % 3 == 0 && trajectoryPoints.size() < 50) {
      trajectoryPoints.add(ballPosition.copy());
    }
  }
  
  fill(100);
  stroke(0);
  strokeWeight(2);
  rect(anchorPosition.x-15, anchorPosition.y-40, 30, 80);
  
  if (hasLaunched) {
    noFill();
    strokeWeight(1);
    stroke(100, 200, 100, 150);
    for (int i = 0; i < trajectoryPoints.size()-1; i++) {
      line(trajectoryPoints.get(i).x, trajectoryPoints.get(i).y, 
           trajectoryPoints.get(i+1).x, trajectoryPoints.get(i+1).y);
    }
  }
  
  drawSpring(anchorPosition.x, anchorPosition.y, ballPosition.x, ballPosition.y);
  
  fill(50, 200, 50);
  stroke(0);
  strokeWeight(2);
  ellipse(ballPosition.x, ballPosition.y, ballRadius*2, ballRadius*2);
  
  if (!isDragging) {
    float forceScaling = 0.5;
    stroke(255, 0, 0);
    strokeWeight(2);
    float forceX = springDirection.x * springConstant * displacement * forceScaling;
    float forceY = springDirection.y * springConstant * displacement * forceScaling;
    drawArrow(ballPosition.x, ballPosition.y, 
             ballPosition.x + forceX, ballPosition.y + forceY, 8);
             
    fill(255, 0, 0);
    text("Spring Force", ballPosition.x + forceX/2, ballPosition.y + forceY/2 - 10);
    
    fill(0);
    text("Spring Energy: " + nf(0.5 * springConstant * displacement * displacement, 0, 1) + "J", 20, 60);
    text("Kinetic Energy: " + nf(0.5 * ballMass * ballVelocity.magSq(), 0, 1) + "J", 20, 90);
  }
  
  fill(0);
  textSize(16);
  if (!hasLaunched) {
    text("Drag the ball to compress or stretch the spring, then release", 20, 30);
  }
}
