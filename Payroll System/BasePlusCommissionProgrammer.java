 package w3assigment2;

/**
    * File name:BasePlusCommissionProgrammer.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Lab 6
    * Date: 31/03/2023
    * Professor:Leanne Seaward
    * Purpose:AlarmClock
    */

/**
 * The BasePlusCommissionProgrammer class is a type of programmer 
 * who receives a base salary as well as commission based on their
 *  gross sales. It is a subclass of the CommissionProgrammer class.
 * @author Hanak
 *
 */
public class BasePlusCommissionProgrammer extends CommissionProgrammer { 
	
	/** 
     * Base salary per week ($)
     */
private double baseSalary; 

/**
 * Constructs a BasePlusCommissionProgrammer .
 * @param firstName the first name of the programmer
 * @param lastName the last name of the programmer
 * @param socialSecurityNumber the social security number of the programmer
 * @param grossSales the gross sales of the programmer
 * @param commissionRate the commission rate of the programmer
 * @param baseSalary the base salary of the programmer
 * @throws IllegalArgumentException if the base salary is less than 0
 */
public BasePlusCommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber,  
double grossSales, double commissionRate, double baseSalary) {
super(firstName, lastName, socialSecurityNumber, 
      grossSales, commissionRate);

if (baseSalary < 0.0) { // validate baseSalary                  
  throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
}

/**
 * Sets the base salary of the programmer.
 * @param baseSalary the base salary to be set
 * @throws IllegalArgumentException if the base salary is less than 0
 */
public void setBaseSalary(double baseSalary) {
if (baseSalary < 0.0) { // validate baseSalary                  
  throw new IllegalArgumentException("Base salary must be >= 0.0");
}

this.baseSalary = baseSalary;                
} 

/** 
 * Returns the base salary
 * @return the base salary
 */
public double getBaseSalary() {
return baseSalary;
}

/** 
 * This method overrides the getPaymentAmount() method of the superclass, CommissionProgrammer.
 * It calculates and returns the payment amount for a BasePlusCommissionProgrammer by adding the base salary
 * to the amount calculated by the superclass method.
 * @return the payment amount for the BasePlusCommissionProgrammer
 */
@Override                                                            
public double getPaymentAmount() {                                             
return getBaseSalary() + super.getPaymentAmount();                        
} 
/**
 * Returns a string representation of the BasePlusCommissionProgrammer object, including its first and last name, social security number, gross sales, commission rate, and base salary.
 * The string is formatted using String.format method to include appropriate formatting for currency and decimal values.
 * @return a string representation of the BasePlusCommissionProgrammer object.
 */
@Override     
public String toString() {
	  return String.format("""
base-plus Commission Programmer: %s %s
social security number: %s
gross Sales: $%,.2f ;  commission rate: $%.2f ; base salary:$%.2f """,getFirstName(), getLastName(), getSocialSecurityNumber(),getPaymentAmount(),getGrossSales(),getCommissionRate(),getBaseSalary());
	}                                                    

}



