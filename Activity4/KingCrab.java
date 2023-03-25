import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{

	public void processActors(ArrayList<Actor> actors)
    {
		Location kingCrabLoc = getLocation();
        for (Actor a : actors)
        {
			Location temp =a.getLocation();
			Location move = temp.getAdjacentLocation(kingCrabLoc.getDirectionToward(temp));
			if( getGrid().isValid(move))
				a.moveTo(move);
			else
                a.removeSelfFromGrid();
        }
    }


}
