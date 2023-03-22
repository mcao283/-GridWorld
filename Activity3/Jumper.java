import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;


public class Jumper extends Bug
{
	
	private int numberTurn;
	public Jumper()
    {
		numberTurn = 0;
        setColor(Color.BLUE);
    }
    
    public Jumper(Color jumperColor)
    {
		numberTurn = 0;
        setColor(jumperColor);
    }
    
     /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove())
        {
            move();
            numberTurn = 0;
		}
        else
        {
			if(numberTurn > 8)
				removeSelfFromGrid();
			else
			{
				super.turn();
				numberTurn++;
			}
		}
		
    }
    
     /**
     * Moves the jumper forward two spaces, putting a blossom into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
		next = next.getAdjacentLocation(getDirection());
         
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Blossom blossom = new Blossom();
        blossom.putSelfInGrid(gr, loc);
    }
    
    /**
     * Tests whether this jumper can move forward into a location that is empty or
     * contains a flower.
     * @return true if this jumper can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        next = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Blossom);
       
        // ok to move into empty location or onto Blossom
        // not ok to move onto any other actor
    }
}
