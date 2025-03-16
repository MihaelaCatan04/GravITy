/* General Attraction Force Simulation */

// Object properties
float obj1X, obj1Y;
float obj2X, obj2Y;
float attractionConstant = 1.0;  // Generic attraction constant (can represent various forces)
float mass1 = 100; // Mass for object 1 (smaller values for easier visualization)
float mass2 = 50;  // Mass for object 2
float radius1 = 40;     // Visual radius for object 1
float radius2 = 20;     // Visual radius for object 2
color color1 = color(0, 100, 255);  // Blue for object 1
color color2 = color(255, 100, 0);  // Orange for object 2
boolean dragging1 = false;
boolean dragging2 = false;
boolean showForceVector = true;
float forceScale = 0.5;  // Scale factor to visualize force vector
boolean simulateMotion = false;
float dampingFactor = 0.98; // Reduces velocity over time
float velocityLimit = 10;   // Maximum velocity

// Physics variables
PVector position1, position2;
PVector velocity1, velocity2;
PVector acceleration1, acceleration2;

void setup() {
  size(800, 500);
  obj1X = width / 3;
  obj1Y = height / 2;
  obj2X = obj1X + 200;
  obj2Y = obj1Y;
  
  // Initialize physics vectors
  position1 = new PVector(obj1X, obj1Y);
  position2 = new PVector(obj2X, obj2Y);
  velocity1 = new PVector(0, 0);
  velocity2 = new PVector(0, 0);
  acceleration1 = new PVector(0, 0);
  acceleration2 = new PVector(0, 0);
}

void draw() {
  background(240);
  
  // Update positions from physics engine if not being dragged
  if (!dragging1) {
    obj1X = position1.x;
    obj1Y = position1.y;
  } else {
    position1.set(obj1X, obj1Y);
    velocity1.set(0, 0);
  }
  
  if (!dragging2) {
    obj2X = position2.x;
    obj2Y = position2.y;
  } else {
    position2.set(obj2X, obj2Y);
    velocity2.set(0, 0);
  }
  
  // Compute distance and direction
  float dx = obj2X - obj1X;
  float dy = obj2Y - obj1Y;
  float distance = sqrt(dx * dx + dy * dy);
  
  // Prevent division by zero and keep minimum distance
  distance = max(distance, radius1 + radius2);
  
  // Compute attraction force magnitude (F = k * m1 * m2 / r²)
  float forceMagnitude = (attractionConstant * mass1 * mass2) / (distance * distance);
  
  // Compute force direction (normalized)
  float forceX = dx / distance;
  float forceY = dy / distance;
  
  // If simulating motion, apply forces
  if (simulateMotion && !dragging1 && !dragging2) {
    // Calculate acceleration based on F = ma
    PVector force = new PVector(forceX, forceY);
    
    // Force on object 1 (towards object 2)
    acceleration1.set(force.x, force.y);
    acceleration1.mult(forceMagnitude / mass1);
    
    // Force on object 2 (towards object 1)
    acceleration2.set(-force.x, -force.y);
    acceleration2.mult(forceMagnitude / mass2);
    
    // Update velocities
    velocity1.add(acceleration1);
    velocity2.add(acceleration2);
    
    // Damping to prevent perpetual motion
    velocity1.mult(dampingFactor);
    velocity2.mult(dampingFactor);
    
    // Limit velocity
    velocity1.limit(velocityLimit);
    velocity2.limit(velocityLimit);
    
    // Update positions
    position1.add(velocity1);
    position2.add(velocity2);
    
    // Boundary checking
    if (position1.x < radius1) {
      position1.x = radius1;
      velocity1.x *= -0.8;
    } else if (position1.x > width - radius1) {
      position1.x = width - radius1;
      velocity1.x *= -0.8;
    }
    
    if (position1.y < radius1) {
      position1.y = radius1;
      velocity1.y *= -0.8;
    } else if (position1.y > height - radius1) {
      position1.y = height - radius1;
      velocity1.y *= -0.8;
    }
    
    if (position2.x < radius2) {
      position2.x = radius2;
      velocity2.x *= -0.8;
    } else if (position2.x > width - radius2) {
      position2.x = width - radius2;
      velocity2.x *= -0.8;
    }
    
    if (position2.y < radius2) {
      position2.y = radius2;
      velocity2.y *= -0.8;
    } else if (position2.y > height - radius2) {
      position2.y = height - radius2;
      velocity2.y *= -0.8;
    }
  }
  
  // Draw force vector if enabled
  if (showForceVector) {
    stroke(255, 0, 0);
    strokeWeight(2);
    
    // Draw force arrow from object 1 to object 2
    float arrowLength = min(forceMagnitude * forceScale, distance * 0.8);
    line(obj1X, obj1Y, obj1X + forceX * arrowLength, obj1Y + forceY * arrowLength);
    
    // Draw arrowhead
    pushMatrix();
    translate(obj1X + forceX * arrowLength, obj1Y + forceY * arrowLength);
    rotate(atan2(forceY, forceX));
    line(0, 0, -10, -5);
    line(0, 0, -10, 5);
    popMatrix();
    
    // Draw opposite force arrow from object 2 to object 1
    line(obj2X, obj2Y, obj2X - forceX * arrowLength, obj2Y - forceY * arrowLength);
    
    // Draw opposite arrowhead
    pushMatrix();
    translate(obj2X - forceX * arrowLength, obj2Y - forceY * arrowLength);
    rotate(atan2(-forceY, -forceX));
    line(0, 0, -10, -5);
    line(0, 0, -10, 5);
    popMatrix();
    
    noStroke();
  }
  
  // Draw Object 1
  fill(color1);
  ellipse(obj1X, obj1Y, radius1 * 2, radius1 * 2);
  
  // Draw Object 2
  fill(color2);
  ellipse(obj2X, obj2Y, radius2 * 2, radius2 * 2);
  
  // Display information
  fill(0);
  textSize(14);
  text("Object 1 Mass: " + mass1, 20, 20);
  text("Object 2 Mass: " + mass2, 20, 40);
  text("Distance: " + int(distance) + " px", 20, 60);
  text("Attraction Force: " + nf(forceMagnitude, 1, 3), 20, 80);
  text("Attraction Constant: " + nf(attractionConstant, 1, 3), 20, 100);
  text("Simulation Running: " + (simulateMotion ? "YES" : "NO"), 20, 120);
  
  // Instructions
  fill(100);
  textSize(12);
  text("Drag either object to move it", 20, height - 80);
  text("Press 'v' to toggle force vectors", 20, height - 60);
  text("Press '1' or '2' to increase respective object mass", 20, height - 40);
  text("Press '3' or '4' to decrease respective object mass", 20, height - 20);
  text("Press 's' to toggle simulation, 'a'/'d' to adjust attraction constant", width/2, height - 20);
}

// Mouse interactions
void mousePressed() {
  if (dist(mouseX, mouseY, obj1X, obj1Y) < radius1) {
    dragging1 = true;
  } else if (dist(mouseX, mouseY, obj2X, obj2Y) < radius2) {
    dragging2 = true;
  }
}

void mouseDragged() {
  if (dragging1) {
    obj1X = mouseX;
    obj1Y = mouseY;
    position1.set(obj1X, obj1Y);
    velocity1.set(0, 0);
  } else if (dragging2) {
    obj2X = mouseX;
    obj2Y = mouseY;
    position2.set(obj2X, obj2Y);
    velocity2.set(0, 0);
  }
}

void mouseReleased() {
  dragging1 = false;
  dragging2 = false;
}

// Keyboard interactions
void keyPressed() {
  float massChangeFactor = 1.5;  // Change mass by this factor
  float attractionChangeFactor = 1.2; // Change attraction constant by this factor
  
  // Toggle force vector
  if (key == 'v' || key == 'V') {
    showForceVector = !showForceVector;
  }
  
  // Toggle simulation
  if (key == 's' || key == 'S') {
    simulateMotion = !simulateMotion;
    if (!simulateMotion) {
      velocity1.set(0, 0);
      velocity2.set(0, 0);
    }
  }
  
  // Adjust attraction constant
  if (key == 'a' || key == 'A') {
    attractionConstant /= attractionChangeFactor;
  }
  if (key == 'd' || key == 'D') {
    attractionConstant *= attractionChangeFactor;
  }
  
  // Increase/decrease masses
  if (key == '3') {
      mass1 /= massChangeFactor;
    } else if (key == '1') {
      mass1 *= massChangeFactor;
    }
  
  if (key == '4') {
      mass2 /= massChangeFactor;
    } else if (key == '2') {
      mass2 *= massChangeFactor;
    }
}
