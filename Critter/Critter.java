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


import java.lang.reflect.Method;
import java.util.List;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */


public abstract class Critter {
	private static String myPackage;
	private	static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();
	private static String[][] map = new String[Params.world_height][Params.world_width];
	private boolean moved = false;
	//private boolean fought = false;
	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	private static java.util.Random rand = new java.util.Random();
	/**
	 * Gets a random number with the given mx
	 * @param max Maximum number that random number can be
	 * @return Random number generated
	 */
	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	/**
	 * Sets the seed to the given value
	 * @param new_seed The seed it is going to be set to
	 */
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	public String toString() { return ""; }
	
	private int energy = 0;
	protected int getEnergy() { return energy; }
	
	private int x_coord;
	private int y_coord;
	
	/**
	 * Moves up, down, left, right and diagonally once based on direction, can only walk once per world step
	 * @param direction Gives the direction be moved to
	 */
	protected final void walk(int direction) 
	{
		//clears map coordinate initially
		map[y_coord][x_coord] = " ";
		//moves only if it hasn't moved already
		if (!moved)
		{
			//moves according to direction provided
			if (direction == 0)
			{
				x_coord = (x_coord + 1) % Params.world_width;
				moved = true;
			}
			else if (direction == 1)
			{
				moved = true;
				x_coord = (x_coord + 1) % Params.world_width;
				if (y_coord != 0)
				{
					y_coord = (y_coord - 1) % Params.world_height;
				}
				else
				{
					y_coord = Params.world_height - 1;
				}
			}
			else if (direction == 2)
			{
				moved = true;
				if (y_coord != 0)
				{
					y_coord = (y_coord - 1) % Params.world_height;
				}
				else
				{
					y_coord = Params.world_height - 1;
				}
			}
			else if (direction == 3)
			{
				moved = true;
				if (x_coord != 0)
				{
					x_coord = (x_coord - 1) % Params.world_width;
				}
				else
				{
					x_coord = Params.world_width - 1;
				}
				if (y_coord != 0)
				{
					y_coord = (y_coord - 1) % Params.world_height;
				}
				else
				{
					y_coord = Params.world_height - 1;
				}
			}
			else if (direction == 4)
			{
				moved = true;
				if (x_coord != 0)
				{
					x_coord = (x_coord - 1) % Params.world_width;
				}
				else
				{
					x_coord = Params.world_width - 1;
				}
			}
			else if (direction == 5)
			{
				moved = true;
				if (x_coord != 0)
				{
					x_coord = (x_coord - 1) % Params.world_width;
				}
				else
				{
					x_coord = Params.world_width - 1;
				}
				y_coord = (y_coord + 1) % Params.world_height;
			}
			else if (direction == 6)
			{
				moved = true;
				y_coord = (y_coord + 1) % Params.world_height;
			}
			else if (direction == 7)
			{
				moved = true;
				x_coord = (x_coord + 1) % Params.world_width;
				y_coord = (y_coord + 1) % Params.world_height;
			}
		}
		//puts the string of the object at its location
		map[y_coord][x_coord] = toString();
		//takes off walk_energy_cost every time
		energy -= Params.walk_energy_cost;
	}
	
	/**
	 * Moves up, down, left, right and diagonally twice based on direction, can only walk once per world step
	 * @param direction Gives the direction be moved to
	 */
	protected final void run(int direction) 
	{
		//clears map coordinate initially
		map[y_coord][x_coord] = " ";
		//moves only if it hasn't moved already
		if (!moved)
		{
			//moves according to direction provided
			if (direction == 0)
			{
				moved = true;
				x_coord = (x_coord + 2) % Params.world_width;
			}
			else if (direction == 1)
			{
				moved = true;
				x_coord = (x_coord + 2) % Params.world_width;
				if (y_coord == 0)
				{
					y_coord = Params.world_height - 2;
					
				}
				else if (y_coord == 1)
				{
					y_coord = Params.world_height - 1;
				}
				else
				{
					y_coord = (y_coord - 2) % Params.world_height;
				}
			}
			else if (direction == 2)
			{
				moved = true;
				if (y_coord == 0)
				{
					y_coord = Params.world_height - 2;
					
				}
				else if (y_coord == 1)
				{
					y_coord = Params.world_height - 1;
				}
				else
				{
					y_coord = (y_coord - 2) % Params.world_height;
				}
			}
			else if (direction == 3)
			{
				moved = true;
				if (x_coord == 0)
				{
					x_coord = Params.world_width - 2;
					
				}
				else if (y_coord == 1)
				{
					x_coord = Params.world_width - 1;
				}
				else
				{
					x_coord = (x_coord - 2) % Params.world_width;
				}
				if (y_coord == 0)
				{
					y_coord = Params.world_height - 2;
					
				}
				else if (y_coord == 1)
				{
					y_coord = Params.world_height - 1;
				}
				else
				{
					y_coord = (y_coord - 2) % Params.world_height;
				}
				
			}
			else if (direction == 4)
			{
				moved = true;
				if (x_coord == 0)
				{
					x_coord = Params.world_width - 2;
				}
				else if (y_coord == 1)
				{
					x_coord = Params.world_width - 1;
				}
				else
				{
					x_coord = (x_coord - 2) % Params.world_width;
				}
			}
			else if (direction == 5)
			{
				moved = true;
				if (x_coord == 0)
				{
					x_coord = Params.world_width - 2;
				}
				else if (y_coord == 1)
				{
					x_coord = Params.world_width - 1;
				}
				else
				{
					x_coord = (x_coord - 2) % Params.world_width;
				}
				y_coord = (y_coord + 2) % Params.world_height;
			}
			else if (direction == 6)
			{
				moved = true;
				y_coord = (y_coord + 2) % Params.world_height;
			}
			else if (direction == 7)
			{
				moved = true;
				x_coord = (x_coord + 2) % Params.world_width;
				y_coord = (y_coord + 2) % Params.world_height;
			}
		}
		//puts the string of the object at its location
		map[y_coord][x_coord] = toString();
		//takes off run_energy_cost every time
		energy -= Params.run_energy_cost;
	}
	
	/**
	 * Creates a child of the object if it has more than min_reproduce_energy, child gets half of parents energy, child moves to its position
	 * @param offspring Child to be born potentially
	 * @param direction Direction in which the child will be placed
	 */
	protected final void reproduce(Critter offspring, int direction) 
	{
		if (energy <= Params.min_reproduce_energy)
		{
			return;
		}
		offspring.energy = energy/2;
		energy = energy/2 + (energy % 2);
		offspring.walk(direction);
		offspring.energy += Params.walk_energy_cost;
		babies.add(offspring);
	}

	/**
	 * Carries out everything an object does in its time step
	 */
	public abstract void doTimeStep();
	
	/**
	 * Critter figures out how to respond to fighting
	 * @param oponent The opponent the critter will if it fights
	 * @return Whether or not the critter wants to fight
	 */
	public abstract boolean fight(String oponent);
	
	/**
	 * create and initialize a Critter subclass.
	 * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
	 * an InvalidCritterException must be thrown.
	 * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
	 * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
	 * an Exception.)
	 * @param critter_class_name Class of the critter to be made
	 * @throws InvalidCritterException If class name is not valid, throws InvalidCritterException
	 */
	public static void makeCritter(String critter_class_name) throws InvalidCritterException 
	{
		try
		{
			//creates a new critter if class name is valid
			Class<?> c = Class.forName(myPackage + "." + critter_class_name);
			Critter v = (Critter) c.newInstance();
			population.add(v);
			//sets x, y and energy of the new critter to Params values
			v.x_coord = getRandomInt(Params.world_width);
			v.y_coord = getRandomInt(Params.world_height);
			v.energy = Params.start_energy;
			//adds it to map
			map[v.y_coord][v.x_coord] = v.toString();
		}
		catch  (Exception e)
		{
			throw new InvalidCritterException(critter_class_name);
		}
	}
	
	/**
	 * Gets a list of critters of a specific type.
	 * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
	 * @return List of Critters.
	 * @throws InvalidCritterException If class name is not valid, throws InvalidCritterException
	 */
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException 
	{
		
		List<Critter> result = new java.util.ArrayList<Critter>();
		//adds crtters of the class given into result
		for (Critter c: population) 
		{
			try 
			{
				if (c.getClass().getName().equalsIgnoreCase(myPackage + "." + critter_class_name))
				{
					result.add(c);			
				}
			}
			catch  (Exception e)
			{
				throw new InvalidCritterException(critter_class_name);
			}
		}
		return result;
	}
	
	/**
	 * Prints out how many Critters of each type there are on the board.
	 * @param critters List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string,  1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();		
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure that the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctly update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			map[super.y_coord][super.x_coord] = " ";
			super.x_coord = new_x_coord;
			map[super.y_coord][super.x_coord] = this.toString();
		}
		
		protected void setY_coord(int new_y_coord) {
			map[super.y_coord][super.x_coord] = " ";
			super.y_coord = new_y_coord;
			map[super.y_coord][super.x_coord] = this.toString();
		}
		
		protected int getX_coord() {
			return super.x_coord;
		}
		
		protected int getY_coord() {
			return super.y_coord;
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		protected static List<Critter> getPopulation() {
			return population;
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies;
		}
	}

	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() 
	{
		babies.clear();
		population.clear();
		// Complete this method.
		for (int i = 0; i < population.size(); i++)
		{
			population.remove(population.get(i));
		}
		for (int i = 0; i < Params.world_height; i++)
		{
			for (int j = 0; j < Params.world_width; j++)
			{
				map[i][j] = null;
			}
		}
	}
	
	/**
	 *  Invoke the doTimeStep method on every living critter, deals with encounters, decreases rest energy from each critter, removes dead critters, adds babies to population and generates more algae 
	 */
	public static void worldTimeStep() 
	{
		//sets each critter's moved to false
		for (int i = 0; i < population.size(); i++)
		{
			population.get(i).moved = false;
		}
		
		//carries out doTimeStep for every living critter, if it dies during the process, it is removed
		for (int i = 0; i < population.size(); i++)
		{
			
			if (population.get(i).energy > 0 && i < population.size())
			{
				map[population.get(i).y_coord][population.get(i).x_coord] = null;
				(population.get(i)).doTimeStep();
				if (population.get(i).energy > 0)
				{
					map[population.get(i).y_coord][population.get(i).x_coord] = population.get(i).toString();
				}
				else
				{
					map[population.get(i).y_coord][population.get(i).x_coord] = null;
					population.remove(population.get(i));
					i--;
				}
			}
			else
			{
				map[population.get(i).y_coord][population.get(i).x_coord] = null;
				population.remove(population.get(i));
				i--;
			}
		}
		
		 //List of critters to be removed
		List<Critter> rem = new java.util.ArrayList<Critter>();
		
		//handles encouters
		for (int i = 0; i < population.size(); i++)
		{
			for (int j = i+1; j < population.size(); j++)
			{
				//2 critters found on the same coordinate
				if (population.get(i).x_coord == population.get(j).x_coord && population.get(i).y_coord == population.get(j).y_coord)
				{
					int Ax = population.get(i).x_coord;
					int Ay = population.get(i).y_coord;
					int Bx = population.get(j).x_coord;
					int By = population.get(j).y_coord;
					boolean Afight = population.get(i).fight(population.get(j).toString());
					boolean Bfight = population.get(j).fight(population.get(i).toString());
					
					//if critters moved to a space that is already occupied, it is moved back to where it was before
					if (population.get(i).moved)
					{
						for (int k = 0; k < population.size(); k++)
						{
							if (population.get(k) != population.get(i) && population.get(k) != population.get(j))
							{
								if (population.get(k).x_coord == population.get(i).x_coord && population.get(k).y_coord == population.get(i).y_coord)
								{
									population.get(i).x_coord = Ax;
									population.get(i).y_coord = Ay;
								}
							}
						}
					}
					if (population.get(j).moved)
					{
						for (int k = 0; k < population.size(); k++)
						{
							if (population.get(k) != population.get(j) && population.get(k) != population.get(i))
							{
								if (population.get(k).x_coord == population.get(j).x_coord && population.get(k).y_coord == population.get(j).y_coord)
								{
									population.get(j).x_coord = Bx;
									population.get(j).y_coord = By;
								}
							}
						}
					}
					
					//if the both critters are alive, they fight
					if (population.get(i).energy > 0 && population.get(j).energy > 0)
					{
						if (population.get(i).x_coord == population.get(j).x_coord && population.get(i).y_coord == population.get(j).y_coord)
						{							
							int Anum;
							int Bnum;
							if (Afight)
							{
								Anum = getRandomInt(population.get(i).energy);
							}
							else
							{
								Anum = 0;
							}
							if (Bfight)
							{
								Bnum = getRandomInt(population.get(j).energy);
							}
							else
							{
								Bnum = 0;
							}
							
							//loser is added to rem List
							if (Anum > Bnum)
							{
								population.get(i).energy += population.get(j).energy;
								map[population.get(j).y_coord][population.get(j).x_coord] = " ";
								rem.add(population.get(j));							
							}
							else if (Bnum > Anum)
							{
								population.get(j).energy += population.get(i).energy;
								map[population.get(i).y_coord][population.get(i).x_coord] = " ";
								rem.add(population.get(i));
							}
							else
							{
								population.get(i).energy += population.get(j).energy;
								map[population.get(j).y_coord][population.get(j).x_coord] = " ";
								rem.add(population.get(j));
							}
						}
					}
				}		
			}
		}
		
		//removes everything in rem from population and clears rem
		for (int i = 0; i < rem.size(); i++)
		{
			population.remove(rem.get(i));
			map[population.get(i).y_coord][population.get(i).x_coord] = null;
		}
		rem.clear();
		
		//decreases resting cost from critters
		for (int i = 0; i < population.size(); i++)
		{
			population.get(i).energy -= Params.rest_energy_cost;
		}
		
		//removes dead critters from population
		for (int i = 0; i < population.size(); i++)
		{
			if (population.get(i).energy <= 0)
			{
				map[population.get(i).y_coord][population.get(i).x_coord] = null;
				population.remove(i);
				i--;
			}
		}
		
		//adds babies if there are any
		if (babies.size() != 0)
		{
			for (int i = 0; i < babies.size(); i++)
			{
				population.add(babies.get(i));
			}
			babies.clear();
		}
		
		//adds refresh_algae_count number of algaes to population
		for (int i = 0; i < Params.refresh_algae_count; i++)
		{
			try 
			{
				makeCritter("Algae");
			}
			catch (InvalidCritterException e)
	        {
	        		System.out.println(e);
	        }
		}
	}
	
	public static void displayWorld() 
	{
		//prints the top margin
		System.out.print("+");
		for (int i = 0; i < Params.world_width; i++)
		{
			System.out.print("-");
		}
		System.out.println("+");
		
		//prints the critters
		for (int i = 0; i < Params.world_height; i++)
		{
			System.out.print("|");
			for (int j = 0; j < Params.world_width; j++)
			{
				if (map[i][j] == null)
				{
					System.out.print(" ");
				}
				else
					System.out.print(map[i][j]);
			}
			System.out.println("|");
		}
		
		//prints the bottom margin
		System.out.print("+");
		for (int i = 0; i < Params.world_width; i++)
		{
			System.out.print("-");
		}
		System.out.println("+");
		
	}
	
	
}
