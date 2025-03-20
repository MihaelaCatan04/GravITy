int RAD = 100; 
float e0 = 8.854187e-12;
ArrayList<Particle> particles = new ArrayList<>();
ArrayList<ArrayList<PVector>> fluxLines = new ArrayList<>();
Particle selected = null;
boolean dragging = false;
int fluxResolution = 10; 

void setup() {
  size(600, 600);
  particles.add(new Particle(width / 3, height / 2, 1.602176e-19)); 
  particles.add(new Particle(2 * width / 3, height / 2, -1.602176e-19));  
  generateFluxLines();
}

void draw() {
  background(0);
  drawField();
  drawFluxLines();
  
  for (Particle p : particles) {
    p.display();
  }
  
  drawHUD(); 
}
