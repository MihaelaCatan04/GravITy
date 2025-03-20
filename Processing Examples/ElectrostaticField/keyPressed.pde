void keyPressed() {
  if (key == '+') {
    particles.add(new Particle(random(width), random(height), 1.602176e-19));
    generateFluxLines();
  } else if (key == '-') {
    particles.add(new Particle(random(width), random(height), -1.602176e-19));
    generateFluxLines();
  } else if (key == '0') {
    if (!particles.isEmpty()) {
      particles.remove(particles.size() - 1);
      generateFluxLines();
    }
  }
}
