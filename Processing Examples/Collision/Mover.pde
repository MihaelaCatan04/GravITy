class Mover {
    PVector pos;
    PVector vel;
    float bounce = 1.0;
    float r;
    float mass;
    boolean colliding = false;
    int[] fillColor;

    Mover(float radius, float m, PVector v, PVector l, int rC, int gC, int bC) {
        r = radius;
        vel = v.get();
        pos = l.get();
        mass = m;
        fillColor = new int[]{rC, gC, bC};
    }

    void go() {
        update();
        borders();
        display();
    }

    void update() {
        pos.add(vel);
    }

    void borders() {
        if (pos.y > height) {
            vel.y *= -1;
            pos.y = height;
        } else if (pos.y < 0) {
            vel.y *= -1;
            pos.y = 0;
        }
        if (pos.x > width) {
            vel.x *= -1;
            pos.x = width;
        } else if (pos.x < 0) {
            vel.x *= -1;
            pos.x = 0;
        }
    }

    void display() {
        ellipseMode(CENTER);
        stroke(0);
        fill(fillColor[0], fillColor[1], fillColor[2]);
        ellipse(pos.x, pos.y, r * 2, r * 2);

        if (showVectors) {
            drawVector(vel, pos, 10);
            fill(0);
            textSize(12);
            text("v: " + nf(vel.mag(), 0, 2), pos.x + 10, pos.y - 10);
        }
    }

    void collideWithMass(Mover other, float e) {
        float d = PVector.dist(pos, other.pos);
        float sumR = r + other.r;

        if (!colliding && d < sumR) {
            colliding = true;

            PVector n = PVector.sub(other.pos, pos);
            n.normalize();

            PVector u = PVector.sub(vel, other.vel);
            PVector un = componentVector(u, n);

            float m1 = mass;
            float m2 = other.mass;

            float massRatio1 = (1 + e) * m2 / (m1 + m2);
            float massRatio2 = (1 + e) * m1 / (m1 + m2);

            PVector v1 = PVector.mult(un, -massRatio1);
            PVector v2 = PVector.mult(un, massRatio2);

            vel.add(v1);
            other.vel.add(v2);
        } else if (d > sumR) {
            colliding = false;
        }
    }
}

PVector componentVector(PVector vector, PVector directionVector) {
    directionVector.normalize();
    directionVector.mult(vector.dot(directionVector));
    return directionVector;
}
