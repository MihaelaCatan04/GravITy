void drawSpring(float x1, float y1, float x2, float y2) {
  float springLength = dist(x1, y1, x2, y2);
  float angle = atan2(y2 - y1, x2 - x1);
  
  stroke(80);
  strokeWeight(3);
  
  float endGap = 10;
  
  line(x1, y1, x1 + endGap * cos(angle), y1 + endGap * sin(angle));
  
  float coilLength = springLength - 2 * endGap;
  float coilSpacing = coilLength / numCoils;
  
  for (int i = 0; i < numCoils; i++) {
    float startX = x1 + (endGap + i * coilSpacing) * cos(angle);
    float startY = y1 + (endGap + i * coilSpacing) * sin(angle);
    float midX = startX + (coilSpacing/2) * cos(angle) + springWidth * cos(angle + PI/2);
    float midY = startY + (coilSpacing/2) * sin(angle) + springWidth * sin(angle + PI/2);
    float endX = x1 + (endGap + (i+1) * coilSpacing) * cos(angle);
    float endY = y1 + (endGap + (i+1) * coilSpacing) * sin(angle);
    
    bezier(startX, startY, 
           startX + coilSpacing/4 * cos(angle), startY + coilSpacing/4 * sin(angle), 
           midX - coilSpacing/4 * cos(angle), midY - coilSpacing/4 * sin(angle),
           midX, midY);
           
    bezier(midX, midY,
           midX + coilSpacing/4 * cos(angle), midY + coilSpacing/4 * sin(angle),
           endX - coilSpacing/4 * cos(angle), endY - coilSpacing/4 * sin(angle),
           endX, endY);
  }
  
  line(x1 + (endGap + numCoils * coilSpacing) * cos(angle), 
       y1 + (endGap + numCoils * coilSpacing) * sin(angle),
       x2, y2);
       
  if (abs(springLength - restLength) > 5) {
    strokeWeight(1);
    stroke(100, 100, 255, 100);
    line(x1, y1, x1 + restLength * cos(angle), y1 + restLength * sin(angle));
    fill(100, 100, 255);
    text("Rest Length", x1 + restLength/2 * cos(angle), y1 + restLength/2 * sin(angle) - 10);
  }
}
