void mouseDragged() {
  if (isDragging) {
    float dx = mouseX - planeX;
    float dy = planeY - mouseY;
    
    float projectedDist = (dx * cos(angle) + dy * sin(angle));
    
    projectedDist = constrain(projectedDist, 
                          ballRadius / cos(angle), 
                          planeLength * cos(angle) - ballRadius / cos(angle));
    ballX = planeX + projectedDist;
    ballVx = 0;
  }
}
