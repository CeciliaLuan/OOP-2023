package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Ship extends GameObject {
    
    float size;
    float halfSize;

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        super(x, y, 0, c, p);  
        this.size = size;
        halfSize = size / 2;
    }

    
    int fireRate = 5;

    int toPass = 1000 / fireRate;
    int ellapsed = 1000;

    int health = 10;

    public void checkCollisions()
    {
        for(int i = ((YASC)p).gameObjects.size() - 1 ; i >= 0 ; i --)
        {
            GameObject go = ((YASC)p).gameObjects.get(i);
            if (go instanceof Bullet && PVector.dist(go.pos, pos) < halfSize)
            {
                health --;
                ((YASC)p).gameObjects.remove(go);
            }
        }

    }

    public void update()
    {
        forward.x = PApplet.sin(rot);
        forward.y = - PApplet.cos(rot);

        YASC yasc= ((YASC)p);
        

        if (yasc.keys[PApplet.LEFT])
        {
            rot -= 0.1f;
        }

        if (yasc.keys[PApplet.RIGHT])
        {
            rot += 0.1f;
        }

        if (yasc.keys[PApplet.UP])
        {
            pos.x += forward.x;
            pos.y += forward.y;
        }

        if (yasc.keys[PApplet.DOWN])
        {
            pos.x -= forward.x;
            pos.y -= forward.y;
        }
        if (yasc.keys[' '] && ellapsed >= toPass)
        {
            ellapsed = 0;
            PVector inFront = PVector.add(pos,
                PVector.mult(forward, 30)
                );  
            
            Bullet b = new Bullet(inFront.x, inFront.y, rot, c, p);

            ((YASC)p).gameObjects.add(b);
        }
        int now = p.millis();
        timeDelta = now - last;
        ellapsed += timeDelta;
        last = now;

        checkCollisions();
    }
    int last = 0;
    int timeDelta;

    public class AIShip extends Ship {
        private ArrayList<PVector> path;
        private int currentTargetIndex;
        
        public AIShip(float x, float y, float size, int c, PApplet p, ArrayList<PVector> path) {
            super(x, y, size, c, p);
            this.path = path;
            this.currentTargetIndex = 0;
        }
        
        public void set() {
        ArrayList<PVector> path = new ArrayList<PVector>();
			path.add(new PVector(100, 100));
			path.add(new PVector(200, 200));
			path.add(new PVector(300, 300));
        }
        public void move() {
            // Check if we've reached the current target
            if (PVector.dist(getPos(), path.get(currentTargetIndex)) < 5) {
                currentTargetIndex++;
                if (currentTargetIndex >= path.size()) {
                    currentTargetIndex = 0;
                }
            }
        
            // Move towards the current target
            PVector target = path.get(currentTargetIndex);
            PVector dir = PVector.sub(target, getPos());
            dir.normalize();
            setPos(PVector.add(getPos(), dir));
        }
    }

    public void render()
    {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        
        p.fill(255);
        p.text("Health: " + health, 50, 0);
        p.noFill();
        
        p.rotate(rot);
        p.stroke(c, 255, 255);
        p.line(- halfSize, halfSize, 0, - halfSize);
        p.line(0, - halfSize, halfSize, + halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, -halfSize, halfSize);
        p.popMatrix();

    }


    
}
