void updateBobPosition() {
  bob.x = origin.x + r * sin(angle);
  bob.y = origin.y + r * cos(angle);
}
