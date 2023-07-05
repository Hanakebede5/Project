   /**
    * File name:Alarm Clock.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Assigment 2
    * Date: 24/03/2023
    * Professor:Leanne Seaward
    * Purpose:AlarmClock
    */

import java.time.LocalTime;
/**
 * This class represents an alarm clock that extends the Clock
 * class and adds alarm functionality.
 * @author Hanak
 */

/**
*The AlarmClock class is used to model an 
*alarm clock that can sound an alarm at a 
*specified time, in addition to telling the 
*current time. It inherits properties and
*behaviors from the Clock class and includes 
*additional attributes to store the 
*alarm hours and minutes
*/
public class AlarmClock extends Clock{
	
	/** The hours of the alarm. */
	private int  alarmHours;
	
	/** The minutes of the alarm. */
	private int  alarmMinute;
		
/**
 * This code snippet defines a constructor for a class named AlarmClock that
 * takes two integer arguments alarmHours and alarmMinute.
 * It calls the constructor of its superclass using the super() statement	
 * @param alarmHours alarmHoures alarmClock is set off
 * @param alarmMinute alarmMinute alarmClock is set off
 */
 public AlarmClock(int alarmHours , int alarmMinute){
	 super();
	 this.alarmHours = alarmHours;
	 this.alarmMinute = alarmMinute;
  }


/**
 * returns an integer value corresponding to the 
 * hour at which the alarm is set
 * @return the alarmClock an integer value
 * corresponding to the 
 * hour at which the alarm is set
 */
public int getAlarmHours() {
	return alarmHours;
}


/**
 * Sets the hour for the alarm clock.
 * @param alarmHours the hour to set for the alarm clock
 */
public void setAlarmClock(int alarmHours) {
	this.alarmHours = alarmHours;
}

/**
 * Returns the minute of the alarm.
 * @return the minute of the alarm
 */
public int getAlarmMinute() {
	return alarmMinute;
}


	/**
	 * alarmMinute the alarmMinute to set
	 * @param alarmMinute the alarmMinute to set
	 */
   public void setAlarmMinute(int alarmMinute) {
	  this.alarmMinute = alarmMinute;
}

   /**
    * Returns a string representing the current time, with an appended "ALARM" 
    * message if the current time is past the alarm time.
    * @return A string representing the current time, with an appended 
    * "ALARM" message if the current time is past the alarm time.
    */
@Override
   public String getTime() {
	
	if (alarmHours >=0 && alarmMinute >=0) {

		LocalTime now = LocalTime.of(getHours(),getMinutes());
	LocalTime alarm = LocalTime.of(alarmHours, alarmMinute);
	
	if (now.isAfter(alarm) || now.equals(alarm)){
		resetAlarm();
		return super.getTime()+"ALARM";
		
	}
	else
		return super.getTime();
	}else {
		return super.getTime();
	}
   }

	/**
	 * resets the alarm by setting the alarm hours and
	 * alarm minutes to -1
	 */
    public void resetAlarm() {
	setAlarmClock(-1);
	setAlarmMinute(-1);
	System.out.println("alarm has been reset");

}

}