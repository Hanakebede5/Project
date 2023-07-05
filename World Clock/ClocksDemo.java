/**
    * File name: ClockDemo.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Assigment 2
    * Date: 24/03/2023
    * Professor:Leanne Seaward
    * Purpose: Clock
    */

	/**
	 * Tests the Clock class,WorldClock and AlarmClock Class.
     */	
    public class ClocksDemo
    
     {
    
    /**
     * The task is to generate three types of clocks namely Clock,
     * WorldClock, and AlarmClock, and then add them to a polymorphic array.
     * Finally, a test is performed on each clock in the array 
     * using a loop.
     * @param args an array of command-line arguments
     */
   public static void main(String[] args) {
	   /**
	    *This code creates three different clock objects:
        *clock1 is a regular clock object created using the default constructor.
        *clock2 is a WorldClock object created with an offset of -4 hours from GMT.
        *clock3 is an AlarmClock object set to 4:20.
        *These three clock objects are then added to an array called "clocks".
     */
	    
	   Clock clock1 = new Clock();
	   Clock clock2 = new WorldClock(-4);
	   Clock clock3 = new AlarmClock(4,20);
	   
       Clock[] clocks = {
    		   
    		   clock1,
    		   clock2, 
    		   clock3
                 
       };
       
       /**
        * This code iterates through an array of 
        * Clock objects and prints the current time of each
        * object to the console.
        */
       for (Clock clock : clocks) {
           System.out.printf("%s%n",clock.getTime());
           
       /**
        * Print the time for the AlarmClock at index 2 
        * of the array
        */
       }System.out.printf("%s%n",clocks[2].getTime());
 }
}
