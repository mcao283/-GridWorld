
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.awt.Color;
import java.util.ArrayList;


public class BlusterCritter extends Critter
{
	private int courage;
	private int counter;
	private static final double COLOR_FACTOR = 0.05;
	
	public BlusterCritter(int courage)
	{
		this.courage = courage;
		this.counter = 0;
		setColor(new Color(128,128,128));
	}
    
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
		Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        for(int i=-2; i<=2;i++)
        {
			for(int j=-2;j<=2;j++)
			{
				if(i!=0 && j!=0)
				{
					Location newLoc = new Location(loc.getRow()+i, loc.getCol()+j);
					if(gr.isValid(newLoc))
					{
						 Actor a =gr.get(newLoc);
						 if (a != null)
							actors.add(a);
					}
				}
			}
		}
        return actors;
    }
    
    
    public void processActors(ArrayList<Actor> actors)
    {
		Color c = getColor();
		int red, green, blue;
        for (Actor a : actors)
        {
			if (a instanceof Critter)
				counter++;			
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
        }
        if(counter < courage)
        {
			red = (int) (c.getRed() * (1 + COLOR_FACTOR));
			green = (int) (c.getGreen() * (1 + COLOR_FACTOR));
			blue = (int) (c.getBlue() * (1 + COLOR_FACTOR));
			setColor(new Color(red,green,blue));
			
		}
		else
		{
			red = (int) (c.getRed() * (1 - COLOR_FACTOR));
			green = (int) (c.getGreen() * (1 - COLOR_FACTOR));
			blue = (int) (c.getBlue() * (1 - COLOR_FACTOR));
			setColor(new Color(red,green,blue));
		}
		counter=0;
    }
	
}
