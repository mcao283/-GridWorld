
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class CoyoteRunner
{
    public static void main(String[] args)
    {
        BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(10,10);
        ActorWorld world = new ActorWorld(mygrid);
        
        // Upper left grid
		world.add(new Location(3,3),new Coyote());
		world.add(new Location(7,7),new Coyote());

        world.show();
    }
}
