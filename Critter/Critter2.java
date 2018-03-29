/*
 * Critter2 tries to reproduce every time step and tries to run from fights (very peaceful so always says no to fight)
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

public class Critter2 extends Critter.TestCritter 
{
	static int runCount = 0;
	
	/**
	 * Attempts to reproduce every time if it has enough energy
	 */
	public void doTimeStep() 
	{
		Critter2 child = new Critter2();
		reproduce(child, 1);
	}

	
	@Override
	/**
	 * Tries to run from fight. Does not want to fight anyone so always returns false
	 * @param opponent The opponent it is going to fight
	 */
	public boolean fight(String opponent) 
	{
		run(getRandomInt(7));
		runCount++;
		return false;
			
	}
	
	/**
	 * Object is represented as a "2" on map
	 * @return Gives a String representation of the object
	 */
	public String toString() 
	{
		return "2";
	}
	
	/**
	 * Prints how many Critter2s there are in the world and how many times they tried to run away in a fight
	 * @param critters List of Critter2 objects from the current population
	 */
	public static void runStats(List<Critter> critters) 
	{
		System.out.println("" + critters.size() + " critter2s as follows -- " + "tried to run " + runCount + " times during fight.");
		
	}
}
