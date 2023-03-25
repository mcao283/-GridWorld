
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
	/*
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        
        Location leftLeft = ((getLocation().getAdjacentLocation(Location.LEFT+ getDirection() )).getAdjacentLocation(Location.LEFT + getDirection()));
        Location rightRight = ((getLocation().getAdjacentLocation(Location.RIGHT + getDirection())).getAdjacentLocation(Location.RIGHT + getDirection()));
        Location left = (getLocation().getAdjacentLocation(Location.LEFT + getDirection() ));
        Location right = (getLocation().getAdjacentLocation(Location.RIGHT + getDirection() ));
		
		if(gr.isValid(left) && gr.get(left) == null)
		{
			if(gr.isValid(leftLeft) && gr.get(leftLeft) == null)
				locs.add(leftLeft);
		}
		
		if(gr.isValid(right) && gr.get(right) == null)
		{
			if(gr.isValid(rightRight) && gr.get(rightRight) == null)
				locs.add(rightRight);
		}
		
		if(locs.size () > 0)
			return locs;
		
		return super.getMoveLocations();
		
		
    }


*/

 public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
		Location neighborLoc,nextneighborLoc;
        for (int d : directions)
        {
			neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            nextneighborLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc)&&gr.get(neighborLoc) == null && gr.isValid(nextneighborLoc)&&gr.get(nextneighborLoc) == null)
                locs.add(nextneighborLoc);
        }
        if (locs.size() == 0)
			return super. getLocationsInDirections(directions);
		else
			return locs;
    }    
}

