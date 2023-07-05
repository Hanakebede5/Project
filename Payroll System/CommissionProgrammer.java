
/**
    * File name:CommissionProgrammer.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Lab 6
    * Date: 31/03/2023
    * Professor:Leanne Seaward
    * Purpose:Commissions
    */
package w3assigment2;


	/**
	 * The CommissionProgrammer class is a concrete subclass of 
	 * the abstract class Programmer, and includes two private
	 *  fields called grossSales and commissionRate, which are 
	 *  unique to this class. This class overrides the getPaymentAmount 
	 *  and toString methods of the Programmer class to 
	 *  provide its own implementation.
	*/
public class CommissionProgrammer extends Programmer { 
	
	/**
	 * Gross sales
	 */
private double grossSales; 

/**
 * Commission percentage
 */
private double commissionRate; 

/**
 * Constructor to initialize CommissionProgrammer object.
 * @param firstName first name of programmer.
 * @param lastName last name of programmer.
 * @param socialSecurityNumber social security number of programmer.
 * @param grossSales gross sales of programmer.
 * @param commissionRate commission rate of programmer.
*/
public CommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber, 
double grossSales, double commissionRate) {
super(firstName, lastName, socialSecurityNumber);

if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
  throw new IllegalArgumentException(
     "Commission rate must be > 0.0 and < 1.0");
}

if (grossSales < 0.0) { // validate
  throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
this.commissionRate = commissionRate;
} 

/**
 * set gross sales amount on the creation of apps
 * @param grossSales Gross sales
 */
public void setGrossSales(double grossSales) {
if (grossSales < 0.0) { // validate
  throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
} 

	/** 
	 * Return gross sales amount 
	 * @return the gross sales amount 
	 */
public double getGrossSales() {
return grossSales;
} 
	
	/**
	 * Set commission rate
	 * @param commissionRate Commission percentage
	 */
public void setCommissionRate(double commissionRate) {
if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
  throw new IllegalArgumentException(
     "Commission rate must be > 0.0 and < 1.0");
}

this.commissionRate = commissionRate;
} 

/**
 * return commission rate
 * @return the commission rate
 */
public double getCommissionRate() {
return commissionRate;
} 

/**

 Calculates and retrieves the payment amount for the CommissionProgrammer
 based on the commission rate and gross sales.
 @return the payment amount for the CommissionProgrammer
*/

@Override                                                           
public double getPaymentAmount() {                                            
return getCommissionRate() * getGrossSales();                    
}                                             

/** 
 * Returns the String representation of CommissionProgrammer object.
 * @return the String representation of CommissionProgrammer object.
 */

@Override      
public String toString() {
		  return String.format("""
Commission Programmer: %s %s
social security number: %s
gross Sales: $%,.2f""", 
getFirstName(), getLastName(), getSocialSecurityNumber(),getPaymentAmount());
		}    
//TO DO: COMEPLETE THIS PORTION. Format your solution according to sample output.     
//START     
// INSERT YOUR CODE
//END

}

