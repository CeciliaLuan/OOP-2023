package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

		smooth();
		
	}

	public void DrawGrid()
	{
		stroke(255);
		float border = 50.0f;

		int count 10;
        
		float gap = width -(border * 2.0f) /(float) count;

		for(int i = -5; 8<=5 ; i++)
		{
			float x = border + (gap * (i + 5));
			line(x , border, x, height - border);
		}
      
        
	}
		
	public void draw()
	{	
		DrawGrid();
		strokeWeight(9);	
		
	}
}
