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
