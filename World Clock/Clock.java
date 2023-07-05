   /**
    * File name: Clock.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Assigment 2
    * Date: 24/03/2023
    * Professor:Leanne Seaward
    * Purpose: Clock
    */

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

 /**
   Part I: Implement a class Clock whose getHours, getMinutes and
   getTime methods return the current time at your location.
   Return the time as a string.
 */

	/**
	  The Clock class represents a clock with hours and minutes.
	*/
	public class Clock
    {
	/** The current hours of the clock. */
	   private int hours;
   /** The current minutes of the clock. */
	   private int minutes;
	
   /**
    * This constructor initializes a new Clock object by 
    * setting its instance variables to the current system time 
    * in the local time zone
    */
  public Clock() {
	 String Local = LocalDateTime.ofInstant(Instant.now(),
		          ZoneId.systemDefault()).toString(); 
	     hours= Integer.parseInt(Local.substring(11,13));
	     minutes = Integer.parseInt(Local.substring(14,16));
  }
	 
 
  /**
    *This method returns the hours value of the Clock object.
    *@return The current hours value of the Clock object.
  */
	public int getHours() {
		return hours;  
}
	/**
     * This method returns the minutes value of the Clock object.
	 * @return The current minutes value of the Clock object.
	*/
  public int getMinutes() {
		return 	minutes;
}

    /**
	 * The method returns the current local time as a string, 
	 * formatted in a particular format
	 * @return the current local time as a String
	 */
	public String getTime() {
	  return "The Time now is " + getHours()+":"+getMinutes() ;
	 	 
 }

}
