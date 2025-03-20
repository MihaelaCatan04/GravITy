void keyPressed() {
  float massChangeFactor = 1.5;
  float attractionChangeFactor = 1.2;

  if (key == 'v' || key == 'V') {
    showForceVector = !showForceVector;
  }
  
  if (key == 's' || key == 'S') {
    simulateMotion = !simulateMotion;
    if (!simulateMotion) {
      velocity1.set(0, 0);
      velocity2.set(0, 0);
    }
  }
  
  if (key == 'a' || key == 'A') {
    attractionConstant /= attractionChangeFactor;
  }
  if (key == 'd' || key == 'D') {
    attractionConstant *= attractionChangeFactor;
  }
  
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
