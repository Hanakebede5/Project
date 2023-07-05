
   /**
    * File name: WorldClock.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Assigment 2
    * Date: 24/03/2023
    * Professor:Leanne Seaward
    * Purpose: Clock
    */
   import java.time.*;

	/**
	 * A class that represents a clock in a specific time zone 
	 * offset from the default time zone.
	 */
    public class WorldClock extends Clock {

/**
 * The offset, measured in minutes, is used 
 * to align the displayed time on a clock with
 * the local time by accounting for 
 * any differences in time zones.
 */
    private int offset;
    
    /**
     * Creates a new WorldClock object with the specified time zone offset.
     * @param offset The number of hours by which this clock's time zone 
     * differs from the default time zone.
     */
    public WorldClock(int offset) {  
        super();
        this.offset = offset;
    }

    /**
     * Creates a new `WorldClock` object with the specified date and time initialized 
     * to the current local time.
     * @param date a `LocalDate` object representing the date to be used 
     * for the `WorldClock` object
     */

	public WorldClock(LocalDate date) {
		super();
		this.offset = 0;
	}

	/**
	 * return the Offset
	 * @return the Offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * Overrides the `getTime()` method to return a string representation of 
	 * the current time with a specified offset from UTC.
	 */
	
	 /** @param offset Offset an integer representing the number of hours to add or subtract 
	  * from the UTC time*/
	 /**
	 * @return a formatted string representing the adjusted time in the format "HH:mm "
	 */
	
	@Override
	public String getTime() {


	        String utcDate = LocalDateTime.ofInstant(Instant.now(),ZoneId.of("UTC")).toString();
	        int uHours = Integer.parseInt(utcDate.substring(11, 13));
	        
	        int calc;
	        int newTime;
	        
	        if (offset <=0 ) {
	        	calc= Integer.parseInt(utcDate.substring(11, 13)) - Math.abs(offset);
	        }
	        else {
	        	calc = Integer.parseInt(utcDate.substring(11, 13)) + offset;
	        	
	        }
	        newTime = calc;
	        
	        if(newTime >= 24) {
	        	newTime = (newTime - 24);
	        }
	        return String.format("%02d:%02d ", newTime, getMinutes());
	          
	}
}