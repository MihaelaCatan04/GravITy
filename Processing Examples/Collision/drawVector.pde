// Function to draw velocity vector
void drawVector(PVector v, PVector pos, float scale) {
    PVector end = PVector.add(pos, PVector.mult(v, scale));
    stroke(0);
    line(pos.x, pos.y, end.x, end.y);
    
    // Draw arrowhead
    PVector arrowDir = PVector.sub(end, pos);
    arrowDir.setMag(6);
    PVector left = PVector.add(end, new PVector(-arrowDir.y, arrowDir.x));
    PVector right = PVector.add(end, new PVector(arrowDir.y, -arrowDir.x));
    
    line(end.x, end.y, left.x, left.y);
    line(end.x, end.y, right.x, right.y);
}
