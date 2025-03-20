void reset() {
  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.5, 3), 40 + i * 70, 0, 0, 163, 108);
  }
}
