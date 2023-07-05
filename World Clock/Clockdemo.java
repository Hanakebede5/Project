/**
    * File name: ClockDemo.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Assigment 2
    * Date: 24/03/2023
    * Professor:Leanne Seaward
    * Purpose: Clock
    */

public class Clockdemo {

	public static void main(String[] args) {
		
		/**
		 * The main method creates aClock object and tests its methods.
		This class is a demo of the Clock class. It creates a Clock object and 
		tests its methods.
		The main method of the class outputs the hours, minutes, and current 
		time of the Clock object.
		*/
	
      System.out.println("Testing Clock class");
      Clock clock = new Clock();
      System.out.println("Hours: " + clock.getHours());
      System.out.println("Minutes: " + clock.getMinutes());
      System.out.println("Time: " + clock.getTime());
		   }
}
	


