
   /**
    * File name: WorldClockDemo.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Assigment 2
    * Date: 24/03/2023
    * Professor:Leanne Seaward
    * Purpose: WorldClock
    */
/**
 * Tests the Clock and WorldClock Classes.
 */
public class WorldClockDemo
{
	/*
	  The main method creates a WorldClock object and tests its methods.
	  This is a demo of the WorldClock class that demonstrates how to create 
	  a WorldClock object with a specified offset and test its methods. 
	  In the main method of this class, the hours, minutes, and current 
	  time of the WorldClock object are printed to the console
	*/
   public static void main(String[] args)
   {
      
      System.out.println("");
      System.out.println("Testing WorldClock class");
      int offset = -4;
      System.out.println("Offset: " + offset);
      WorldClock wclock = new WorldClock(offset);
      System.out.println("Hours: " + wclock.getHours());
      System.out.println("Minutes: " + wclock.getMinutes());
      System.out.println("Time: " + wclock.getTime());
   }
}
