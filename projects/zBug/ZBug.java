

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
 * A <code>Spiral Bug</code> traces out a Z of a given size <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int counter;

    /**
     * Constructs a box bug that traces a Z of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        counter = 0;
		turn();
        turn();
         
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
		if (steps < sideLength && canMove() && counter <= 2)
        {
            move();
            steps++;
            if(steps == sideLength)
				counter++;
        }
        else
        {
			if(counter == 1)
			{
				turn();
				turn();
				turn();
			}
			else if( counter == 2)
			{
				turn();
				turn();
				turn();
				turn();
				turn();
			}
			
			steps = 0;
				
		}
       
	}

        
    }

