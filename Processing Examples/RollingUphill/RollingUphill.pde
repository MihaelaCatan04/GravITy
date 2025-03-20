float g = 0.1;      
float mu = 0.5;    
float restitution = 0.7;
float angle = PI/6;  

float ballRadius = 20;
float ballMass = 1;
float ballX, ballY;    
float ballVx = 0;  
boolean isDragging = false;  

float planeLength = 600;
float planeHeight = 200;
float planeX, planeY; 

void setup() {
  size(600, 600);
  
  planeX = width/2 - planeLength/2;
  planeY = height/2 + planeHeight/2;
  
  resetBall();
}

void draw() {
  background(240);
  
  if (mousePressed && mouseY > height/2) {
    angle = map(mouseX, 0, width, PI/12, PI/2.5);
    resetBall();
  }
  
  float sinAngle = sin(angle);
  float cosAngle = cos(angle);
  
  float x1 = planeX;
  float y1 = planeY;
  float x2 = planeX + planeLength * cosAngle;
  float y2 = planeY - planeLength * sinAngle;
  float x3 = planeX + planeLength * cosAngle;
  float y3 = y2 + 20; 
  float x4 = planeX;
  float y4 = y1 + 20; 
  
  fill(120);
  quad(x1, y1, x2, y2, x3, y3, x4, y4);
  
  if (!isDragging) {
    float Fgp = ballMass * g * sinAngle;
    
    float normalForce = ballMass * g * cosAngle;
    float frictionForce = mu * normalForce;
    
    float netForce;
    if (ballVx == 0) {
      if (abs(Fgp) < frictionForce) {
        netForce = 0;
      } else {
        netForce = Fgp - frictionForce * sign(Fgp);
      }
    } else {
      netForce = Fgp - frictionForce * sign(ballVx);
    }
    
    float acceleration = netForce / ballMass;
    ballVx += acceleration;
    
    ballX += ballVx;
    ballY -= ballVx * tanAngle(angle);
    
    if (ballX < planeX + ballRadius / cosAngle) {
      ballX = planeX + ballRadius / cosAngle;
      ballVx *= -restitution; 
    }
    
    float maxX = planeX + planeLength * cosAngle - ballRadius / cosAngle;
    if (ballX > maxX) {
      ballX = maxX;
      ballVx *= -restitution; 
    }
  }
  
  drawBall();
  
  if (!isDragging) {
    drawForceVectors();
  }
  drawHUD();
 
}
