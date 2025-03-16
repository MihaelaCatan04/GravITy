Mover[] movers;
boolean showVectors = true;  // Toggle vector display

void setup() {
    size(800, 600);
    movers = new Mover[3];

    movers[0] = new Mover(50, 50, new PVector(3, 2), new PVector(200, 300), 255, 0, 0);   // Red
    movers[1] = new Mover(40, 40, new PVector(-2, 1), new PVector(500, 300), 0, 255, 0); // Green
    movers[2] = new Mover(30, 30, new PVector(-1, -3), new PVector(400, 200), 0, 0, 255);  // Blue
}

void draw() {
    background(255);
    
    for (int i = 0; i < movers.length; i++) {
        movers[i].go();
        
        // Check collisions between all movers
        for (int j = i + 1; j < movers.length; j++) {
            movers[i].collideWithMass(movers[j], 0.8); // Partial inelastic collision (80% energy retained)
        }
    }
    
    drawHUD();  // Display simulation info
}

// Function to draw simulation HUD with object details
void drawHUD() {
    fill(0, 150);
    rect(10, 10, 220, 20 + movers.length * 30, 10);

    fill(255);
    textSize(14);
    text("MOVER SIMULATION", 20, 30);
    text("Objects: " + movers.length, 20, 50);

    textSize(12);
    for (int i = 0; i < movers.length; i++) {
        text("Obj " + (i + 1) + " - Mass: " + nf(movers[i].mass, 0, 2) + 
             ", Radius: " + nf(movers[i].r, 0, 2), 20, 70 + (i * 20));
    }
}
