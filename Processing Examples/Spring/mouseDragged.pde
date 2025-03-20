void mouseDragged() {
  if (isDragging) {
    ballPosition.x = mouseX;
    ballPosition.y = mouseY;
    
    float minDist = 20;
    if (PVector.dist(ballPosition, anchorPosition) < minDist) {
      PVector dir = PVector.sub(ballPosition, anchorPosition);
      dir.normalize();
      ballPosition = PVector.add(anchorPosition, PVector.mult(dir, minDist));
    }
    
    ballVelocity.x = 0;
    ballVelocity.y = 0;
  }
}
