

package w3assigment2;
  /**
    * File name:HourlyProgramer.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Lab 6
    * Date: 31/03/2023
    * Professor:Leanne Seaward
    * Purpose:Hourly Programer
    */
/**
 * The HourlyProgrammer class is a concrete class that extends the
 *  abstract class Programmer and implements the Payme interface.
 * @author Hanak
 *
 */
public class HourlyProgrammer extends Programmer implements Payme{
	
	/** 
	 * Wage per hour 
	 */
	private double wage; 
	
	/** 
	 * Hours worked for week (h)
	 */
	private double hours; 
	
	/**
	 * Constructs a new HourlyProgrammer. 
	 * @param firstName the first name of the hourly programmer
	 * @param lastName the last name of the hourly programmer
	 * @param socialSecurityNumber the social security number of the hourly programmer
	 * @param wage the hourly wage of the hourly programmer
	 * @param hours the hours worked per week by the hourly programmer
	 * @throws IllegalArgumentException if wage is less than 0.0 or hours is less than 0.0 or greater than 168.0
	 */
	public HourlyProgrammer(String firstName, String lastName,String socialSecurityNumber, 
		double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0) { // validate wage
		  throw new IllegalArgumentException(
		     "Hourly wage must be >= 0.0");
		}
		
		if ((hours < 0.0) || (hours > 168.0)) { // validate hours
		  throw new IllegalArgumentException(
		     "Hours worked must be >= 0.0 and <= 168.0");
		}
		
		this.wage = wage;
		this.hours = hours;
	} 

	/**
	 * Sets the hourly wage of the hourly programmer.
	 * @param wage the hourly wage to set
	 * @throws IllegalArgumentException if wage is less than 0.0
	 */
	public void setWage(double wage) {
		if (wage < 0.0) { // validate wage
		  throw new IllegalArgumentException(
		     "Hourly wage must be >= 0.0");
		}
	
		this.wage = wage;
	} 
	/**
	 * Returns the hourly wage of the hourly programmer.
	 * @return the hourly wage of the hourly programmer
	 */
	public double getWage() {
		return wage;
	} 

	/**
	 * Sets the hours worked per week by the hourly programmer.
	 * @param hours the hours worked per week to set
	 * @throws IllegalArgumentException if hours is less than 0.0 or greater than 168.0
	 */
	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) { // validate hours
		  throw new IllegalArgumentException(
		     "Hours worked must be >= 0.0 and <= 168.0");
		}
		
		this.hours = hours;
		} 
		
	/**
	 * Returns the hours worked per week by the hourly programmer.
	 * @return the hours worked per week by the hourly programmer
	 */
		public double getHours() {
		return hours;
	} 
	/**
	 * Returns the payment amount of the hourly programmer.
	 * Calculates payment based on wage and hours worked, with overtime pay for hours over 40.
	 * @return the payment amount of the hourly programmer
	 */

@Override                                                           
public double getPaymentAmount() {                                            
	if (getHours() <= 40) { // no overtime                           
	  return getWage() * getHours();   
	}
	else {                                                             
	  return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}
}                                          
                                                         
/**
 * Returns the String representation of HourlyProgrammer object.
 * @return the String representation of HourlyProgrammer object
 */
@Override
public String toString() {
  return String.format("""
hourly Programmer:%s %s
social security number:%s
hourly wage:  $%,.2f; hours worked: $%,.2f;""",
      super.getFirstName(),super.getLastName(),super.getSocialSecurityNumber(),this.getWage(),getHours());
}
 
	
                     
}

