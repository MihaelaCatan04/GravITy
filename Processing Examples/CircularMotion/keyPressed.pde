void keyPressed() {
  if (keyCode == LEFT) {
    angularSpeed -= 0.005;
  } else if (keyCode == RIGHT) {
    angularSpeed += 0.005;
  }
}
