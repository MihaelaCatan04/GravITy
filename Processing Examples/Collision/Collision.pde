Mover[] movers;
boolean showVectors = true;

void setup() {
    size(600, 600);
    movers = new Mover[3];

    movers[0] = new Mover(50, 50, new PVector(3, 2), new PVector(200, 300), 255, 0, 0);   // Red
    movers[1] = new Mover(40, 40, new PVector(-2, 1), new PVector(500, 300), 0, 255, 0); // Green
    movers[2] = new Mover(30, 30, new PVector(-1, -3), new PVector(400, 200), 0, 0, 255);  // Blue
}

void draw() {
    background(255);
    
    for (int i = 0; i < movers.length; i++) {
        movers[i].go();
        
        for (int j = i + 1; j < movers.length; j++) {
            movers[i].collideWithMass(movers[j], 0.8); 
        }
    }
    drawHUD(); 
}
