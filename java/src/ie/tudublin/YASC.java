package ie.tudublin;

import ie.tudublin.Ship.AIShip;
import processing.core.PApplet;
import java.util.ArrayList;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;
	AIShip Aiship;


	public void settings()
	{
		size(500, 500);
		
	}

	

	public void setup() {
		
			ship = new Ship(width / 2, height / 2, 50, 70, this);
			ship1 = new Ship(100, 50, 80, 6, this);
			
			
			Aiship = new AIShip(50, 25, 40, color(0, 0, 255), this, path);
			colorMode(HSB);
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();

		ship1.render();
		ship1.move();

		Aiship.render();
        Aiship.move();
	}
}