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

import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.lang.reflect.*;

/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
       /* try 
        {*/
        		//Critter.clearWorld();
        		String nextCom = "";
        		while (!nextCom.equals("quit"))
        		{
        			System.out.print("critters>");
        			nextCom = kb.nextLine();
        			String[] arr = nextCom.split(" ");
        			if (nextCom.equals("show"))
        			{
        				Critter.displayWorld();
        			}
        			
        			else if (arr[0].equals("step"))
        			{
        				/*try
        				{
        					List<Critter> ck = Critter.getInstances("Craig");
        					Class<?> cs = Class.forName(myPackage + "." + "Craig");
        					Method method1 = cs.getMethod("runStats", ck.getClass().getInterfaces()[0]);
        					method1.invoke(cs, ck);
        				}
        				catch (Exception e)
        				{
        					
        				}*/
        				if (arr.length == 1)
        				{
        					Critter.worldTimeStep();
        				}
        				else
        				{
        					try 
        					{
        						int num = Integer.parseInt(arr[1]);
            					for (int i = 0; i < num; i++)
            					{
            						Critter.worldTimeStep();
            						
            					}
        					}
        					catch (Exception e)
        					{
        						System.out.print("error processing: " + nextCom + "\n");
        					}
        				}
        			}
        			else if (arr[0].equals("seed"))
        			{
        				if (arr.length == 2)
        				{
        					try
        					{
        						Critter.setSeed(Long.parseLong(arr[1]));
        					}
        					catch (Exception e)
        					{
        						System.out.print("error processing: " + nextCom + "\n");
        					}
        					
        				}
        				else
        				{
        					System.out.print("error processing: " + nextCom + "\n");
        				}
        			}
        			else if (arr[0].equals("make"))
        			{
        				if (arr.length == 3)
        				{
        					try 
        					{
        						for (int i = 0; i < Integer.parseInt(arr[2]); i++)
            					{
            						try 
            						{
            							Critter.makeCritter(arr[1]);
            						}
            						catch (InvalidCritterException e)
            						{
            							System.out.print("error processing: " + nextCom + "\n");
            						}
            					}
        					}
        					catch (NumberFormatException e)
        					{
        						System.out.print("error processing: " + nextCom + "\n");
        					}
        				
        				}
        				else if (arr.length == 2)
        				{
        					try 
    						{
    							Critter.makeCritter(arr[1]);
    						}
    						catch (InvalidCritterException e)
    						{
    							System.out.print("error processing: " + nextCom + "\n");
    						}
        				}
        				else
        				{
        					System.out.print("error processing: " + nextCom + "\n");
        				}
        			}
        			else if (arr[0].equals("stats"))
        			{
        				if (arr.length == 2)
        				{
        					try
        					{
        						if (!arr[1].equals("Critter"))
        						{
        							List<Critter> cr = Critter.getInstances(arr[1]);
                					Class<?> c = Class.forName(myPackage + "." + arr[1]);
                					Method method = c.getMethod("runStats", cr.getClass().getInterfaces()[0]);
                					method.invoke(c, cr);
        						}
        						else
        						{
        							System.out.print("error processing: " + nextCom + "\n");
        						}
        					}
        					catch (Exception e)
        					{
        						System.out.print("error processing: " + nextCom + "\n");
        					}
        					
    
        				}
        			}
        			else if (!nextCom.equals("quit"))
        			{
        				System.out.print("invalid command: " + nextCom + "\n");
        			}
        		}
        		//Critter.clearWorld();
        		System.out.println();
        		
        /*}
        catch (InvalidCritterException e)
        {
        		System.out.println(e);
        }*/
        
        /* Write your code above */
        System.out.flush();

    }
}
