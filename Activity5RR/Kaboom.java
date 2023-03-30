import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;
public class Kaboom extends Actor
{
	private int lifetime;
	private final int THRESHOLD = 3;
	
	
	public Kaboom ()
	{
		lifetime = THRESHOLD;
		super.setColor(null);
	}
	
	public void act()
	{
		if(lifetime = 0)
			removeSelfFromGrid();
		else
			lifetime--;
	}
	
}
