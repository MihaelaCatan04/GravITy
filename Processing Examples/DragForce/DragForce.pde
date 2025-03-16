Mover[] movers = new Mover[9];  // Array for Mover objects
Liquid liquid;  // Liquid object
float dragCoefficient = 0.1;  // Coefficient of drag

void setup() {
  size(600, 600);
  reset();
  liquid = new Liquid(0, height/2, width, height/2, dragCoefficient, 137, 207, 240);
}

void draw() {
  background(255);
  
  // Draw water
  liquid.display();

  for (int i = 0; i < movers.length; i++) {

    // Is the Mover in the liquid?
    if (liquid.contains(movers[i])) {
      // Calculate drag force
      PVector dragForce = liquid.drag(movers[i]);
      // Apply drag force to Mover
      movers[i].applyForce(dragForce);
    }

    // Gravity is scaled by mass here!
    PVector gravity = new PVector(0, 0.1 * movers[i].mass);
    // Apply gravity
    movers[i].applyForce(gravity);

    // Update and display the Mover
    movers[i].update();
    movers[i].display();
    movers[i].checkEdges();
  }

  // Display the HUD
  drawHUD();
  
  fill(0);
}

void mousePressed() {
  reset();
}

// Restart all the Mover objects randomly
void reset() {
  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.5, 3), 40 + i * 70, 0, 0, 163, 108);
  }
}

// HUD Display in the Top-Left Corner
void drawHUD() {
  fill(50, 50, 50, 200);
  rect(10, 10, 230, 150, 10);  // Background for HUD

  fill(255);
  textSize(14);
  text("Liquid Simulator", 20, 30);

  textSize(12);
  text("Drag Coefficient: " + dragCoefficient, 20, 50);
  text("Number of Movers: " + movers.length, 20, 65);

  text("Click to Reset", 20, 130);
}
