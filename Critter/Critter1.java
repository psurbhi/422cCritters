/*
 * Critter1 walks up, down, left or right each time step and when fighting, tries to reproduce. If successful, returns true, if not, return false
 */
package assignment4;
/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Prachi Surbhi
 * ps28324
 * <Student1 5-digit Unique No.>
 * 15470
 * Spring 2018
 */

import java.util.List;

public class Critter1 extends Critter.TestCritter
{
	private static int babiesCount = 0;
	private static int up = 0;
	private static int down = 0;
	private static int left = 0;
	private static int right = 0;
	@Override
	/**
	 * Walks only up, down, left and right
	 */
	public void doTimeStep() 
	{
		int rand = getRandomInt(15)/2;
		if (rand == 0)
		{
			right++;
		}
		if (rand == 2)
		{
			up++;
		}
		if (rand == 4)
		{
			left++;
		}
		if (rand == 6)
		{
			down++;
		}
		walk(rand);
	}

	
	@Override
	/**
	 * Tries to reproduce, if successful, returns true, otherwise false
	 */
	public boolean fight(String opponent) 
	{
		Critter1 child = new Critter1();
		reproduce(child, getRandomInt(16) / 2);
		List<Critter> babies = getBabies();
		if (babies.contains(child))
		{
			babiesCount++;
			return true;
		}
		else
			return false;
		
	}
	
	/**
	 * Object is represented as a "1" on map
	 * @return Gives a String representation of the object
	 */
	public String toString() 
	{
		return "1";
	}
	
	/**
	 * Prints how many Critter1s there are in the world and how many times Critter1s have moved up, down, left, right and how many babies were produced
	 * @param critters List of Critter1 objects from the current population
	 */
	public static void runStats(List<Critter> critters) 
	{
		System.out.println("" + critters.size() + " critter1s as follows -- " + up + "ups\t" + down + "downs\t" + right + "right\t" + babiesCount + "babies");
		
	}
}
