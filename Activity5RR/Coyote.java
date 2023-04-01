import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.awt.Color;
import java.util.ArrayList;

public class Coyote extends Critter
{
	private int steps;
	private int sleep;
	
	public Coyote()
	{
		steps = 0;
		sleep = 0;
		setColor(null);
		setDirection(((int)(Math.random() * 7)*45));
	}
	
	public ArrayList<Location> getMoveLocations()
    {
		ArrayList<Location> moveLoc = new ArrayList<Location>();
         Location loc = getLocation().getAdjacentLocation(getDirection());
         if(!getGrid().isValid(loc) ||( getGrid().get(loc) != null && (!(getGrid().get(loc) instanceof Boulder))) ||steps == 5)
         {
			 return moveLoc;
		 }
		 else
		 {
			 moveLoc.add(loc);
			 return moveLoc;
		 } 
    }

    public void act()
    {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    public void makeMove(Location loc)
    {
		Stone s = new Stone(10);
		Actor adjacentActor = new Actor();
		int d = 1;
        if (loc == null  || loc == getLocation())
        {
			if(sleep <= 4)
			{
				sleep++;			
				return;
			}
			else
			{
				steps=0;
				sleep = 0;
				if(!getGrid().isValid(getLocation().getAdjacentLocation(getDirection())))
				{
					setDirection(getDirection() + ((int)(Math.random() * 6+1)*45));
				}
				else
				{
					if(getGrid().get(getLocation().getAdjacentLocation(getDirection())) == null)
					{
						s.putSelfInGrid(getGrid(),getLocation().getAdjacentLocation(getDirection()));
						
					}
					else
					{
						do
						{
							if(getGrid().isValid(getLocation().getAdjacentLocation(getDirection() + (45*d))))
							{
								adjacentActor = getGrid().get(getLocation().getAdjacentLocation(getDirection() + (45*d)));
							
								if(adjacentActor == null)
								{
								s.putSelfInGrid(getGrid(),getLocation().getAdjacentLocation(getDirection() + 45*d));
								}
							}
							d++;
						}while( adjacentActor != null);
					}
					
					setDirection(getDirection() + ((int)(Math.random() * 6+1)*45));
				}
			}
		}
        else
        {
			steps++;
			Actor next = getGrid().get(loc);
			
			if(next!= null && (next instanceof Boulder))
			{
				Kaboom k = new Kaboom();
				Actor b = getGrid().get(loc);
				b.removeSelfFromGrid();
				k.putSelfInGrid(getGrid(),loc);
				removeSelfFromGrid();
				//steps = 0;
				return;
				
			}
			else
				moveTo(loc);
		}
    }
}


