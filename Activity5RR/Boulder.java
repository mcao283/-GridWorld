import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;
public class Boulder extends Actor
{
	private int lifetime;
	private final int THRESHOLD = 3;
	
	public Boulder ()
	{
		lifetime = (int)(Math.random() * (199) + 1);
		if ( lifetime <= 3 )
			super.setColor(Color.RED);
		else
			super.setColor(null);
	}
	
	public Boulder(int lifetime)
	{
		this.lifetime = lifetime;
		if ( lifetime <= 3 )
			super.setColor(Color.RED);
		else
			super.setColor(null);
	}
	
	public void act()
	{
		Kaboom k = new Kaboom();
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		if(lifetime == 0)
		{
			removeSelfFromGrid();
			k.putSelfInGrid(gr,loc);
		}
		else if( lifetime <= 3 )
		{
			setColor(Color.RED);
			lifetime --;
		}
		else
			lifetime--;
	}
}
