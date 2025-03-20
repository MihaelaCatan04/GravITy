Mover[] movers = new Mover[9]; 
Liquid liquid;
float dragCoefficient = 0.1; 

void setup() {
  size(600, 600);
  reset();
  liquid = new Liquid(0, height/2, width, height/2, dragCoefficient, 137, 207, 240);
}

void draw() {
  background(255);
  
  liquid.display();

  for (int i = 0; i < movers.length; i++) {
    if (liquid.contains(movers[i])) {
      PVector dragForce = liquid.drag(movers[i]);
      movers[i].applyForce(dragForce);
    }

    PVector gravity = new PVector(0, 0.1 * movers[i].mass);
    movers[i].applyForce(gravity);
    movers[i].update();
    movers[i].display();
    movers[i].checkEdges();
  }
  drawHUD();
  fill(0);
}
