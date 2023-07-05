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
	 * The main method creates a AlarmdClock object and tests its methods.
    This is a demo of the AlarmClock class that demonstrates how to 
    create an AlarmClock object and test its methods. In the main method of
    this class, the hours, minutes, and current time of the AlarmClock object
    are printed to the console
    */
  public class AlarmClockDemo {

		public static void main(String[] args) {
	
	      System.out.println("");
	      System.out.println("Testing AlarmClock class ");
	      AlarmClock Aclock = new AlarmClock(15, 50);
	      System.out.println("Hours: " + Aclock.getHours());
	      System.out.println("Minutes: " + Aclock.getMinutes());
	      System.out.println("Time: " + Aclock.getTime());
	      System.out.println("Time: " + Aclock.getTime());
	      

	}

}
