

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>Dancing Bug</code> creates a bug that "dances" turns randomy depending on number in an array <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int [] turns;
    private int counter;
	

    /**
     * Constructs a box bug that traces a Z of a given side length
     * @param length the side length
     */
    public DancingBug(int length, int[] turns)
    {
        steps = 0;
        sideLength = length;
		this.turns = turns;
        counter = 1;
        
        for(int i = 0 ; i < turns[0] ; i ++)
        {
			turn();
		}
		
    }

    /**
     * Moves to the next location of the "dance".
     */
    
	public void act()
    {
		if(counter == turns.length)
			counter = 0;
		
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
           
			for(int i = 0 ; i < turns[counter] ; i ++)
			{
				turn();
			}
			counter++;
            steps = 0;
        }
	}
}

        
    

