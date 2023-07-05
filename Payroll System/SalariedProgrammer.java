package w3assigment2;

/**
    * File name:SalariedProgramer.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Lab 6
    * Date: 31/03/2023
    * Professor:Leanne Seaward
    * Purpose:Salary
    */
/**
 * The SalariedProgrammer class is a concrete subclass of the abstract 
 * class Programmer, and includes a private field called weeklySalary 
 * that is unique to this class
 * @author Hanak
 *
 */
	public class SalariedProgrammer extends Programmer {
		/**
		 * The SalariedProgrammer's weekly salary in $
		 */
	private double weeklySalary;
	/**

	Constructs a SalariedProgrammer object with the given first name, last name, social security number,
	and weekly salary.
	@param firstName the first name of the salaried programmer
	@param lastName the last name of the salaried programmer
	@param ssn the social security number of the salaried programmer
	@param weeklySalary the weekly salary of the salaried programmer
	@throws IllegalArgumentException if the weekly salary is less than 0.0
	*/

public SalariedProgrammer(String firstName, String lastName, String ssn,
		double weeklySalary) {
	
		super(firstName, lastName, ssn); 
		
		if (weeklySalary < 0.0) {
		  throw new IllegalArgumentException(
		     "Weekly salary must be >= 0.0");
		}
		
		this.weeklySalary = weeklySalary;
}

/**
 * Sets the weekly salary of the programmer.
 * @param weeklySalary the weekly salary to set
 * @throws IllegalArgumentException if the weekly salary is negative
 */
public void setWeeklySalary(double weeklySalary) {
if (weeklySalary < 0.0) {
  throw new IllegalArgumentException(
     "Weekly salary must be >= 0.0");
}

this.weeklySalary = weeklySalary;
} 
	/**
	 * Returns the weekly salary of the programmer.
	 * @return the weekly salary of the programmer
	 */

public double getWeeklySalary() {
return weeklySalary;
} 

	/**
	 * Returns the payment amount of the programmer.
	 * @return the payment amount of the programmer
	 */
@Override                                                           
public double getPaymentAmount() {                                          
return getWeeklySalary();                                        
}                                             
 

/**
 * Returns the String representation of the SalariedProgrammer object.
 * @return the String representation of the SalariedProgrammer object
 */
@Override        
public String toString() {
	  return String.format("""
salaried Programmer: %s %s
social security number: %s
weekly salary: $%,.2f""", 
getFirstName(), getLastName(), getSocialSecurityNumber(),getPaymentAmount());
	}                                        

}

