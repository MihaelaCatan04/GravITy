void keyPressed() {
  if (keyCode == LEFT) {
    acceleration -= 0.01;
  } else if (keyCode == RIGHT) {
    acceleration += 0.01;
  }
}
