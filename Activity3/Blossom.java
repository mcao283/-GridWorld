//@author Marcus Cao
//package info.gridworld.actor;

import info.gridworld.actor.Flower;
import java.awt.Color;

public class Blossom extends Flower
{
	private int lifetime;
	private int steps;
	private static final double DARKENING_FACTOR = 0.05;
	
	
	public Blossom()
    {
		setColor(Color.GREEN);
        lifetime = 10;
        steps = 0;
    }


    public Blossom(int lifetime)
    {
		setColor(Color.GREEN);
		this.lifetime = lifetime;
		steps = 0;
	}
	
	/**
     * Causes the color of this blossom to darken.
     */
    public void act()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
		if(steps < lifetime)
		{
			setColor(new Color(red, green, blue));
			steps++;
		}
		else
		{
			removeSelfFromGrid();
		}
			
		
    }
   
}
