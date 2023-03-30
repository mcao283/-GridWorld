import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.awt.Color;

public class Stone extends Rock
{
	private int lifetime;
	private final int THRESHOLD = 3;
	
	
	public Stone ()
	{
		lifetime = Math.floor(Math.random() * (200) + 1);
		super.setColor(null);
	}
	
	public Stone(int lifetime)
	{
		this.lifetime = lifetime;
		super.setColor(null);
	}
	
	public void act()
	{
		Boulder b = new Boulder();
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		if(lifetime = 0)
		{
			removeSelfFromGrid();
			b.putSelfInGrid(gr,loc);
		}
		else if( lifetime <= 3 )
		{
			setColor(Color.GREEN);
			lifetime --;
		}
		else
			lifetime--;
	}
}
