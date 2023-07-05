package w3assigment2;
/**
    * File name:Programer.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Lab 6
    * Date: 31/03/2023
    * Professor:Leanne Seaward
    * Purpose:Programer class
    */

/**
 * This is an abstract superclass that IMPLEMENTS the Payme interface.
 */
 public abstract class Programmer implements Payme  {
	
	 /**
	   * First name of the programmer.
	   */
	private String firstName;
	
	/**
     * Last name of the programmer.
     */	
	private String lastName;
	
	/**
     * Social security number of the programmer.
     */
	private String socialSecurityNumber;

	/**
	   Constructor for Programmer class with the specified first name, last name, and social security number.
	   @param first the first name of the programmer
	   @param last the last name of the programmer
	   @param ssn the social security number of the programmer
	*/
	public Programmer(String first, String last, String ssn) {
		 firstName = first;
		 lastName = last;
		 socialSecurityNumber = ssn;
		
		}

		
	/**
     * Gets the first name of the programmer.
     * @return the first name of the programmer
     */
	public String getFirstName() {
		return firstName;
	}

	/**
     * Sets the first name of the programmer.
     * @param firstName the new first name of the programmer
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
     * Gets the last name of the programmer.
     * @return the last name of the programmer
     */
	public String getLastName() {
		return lastName;
	}

	/**
     * Sets the last name of the programmer.
     * @param lastName the new last name of the programmer
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	 /**
     * Gets the social security number of the programmer.
     * @return the social security number of the programmer
     */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

  

@Override
public String toString() {
return String.format("%s %s\n%s:%s\n%s: %s", 
  getFirstName(), getLastName(), getSocialSecurityNumber());
} 

/**
 * Sets the social security number of the programmer.
 * @param socialSecurityNumber the new social security number of the programmer
 */
		public void setSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
		}

		/**

		Retrieves the payment amount as a double value.
		@return the payment amount as a double value
		*/
   public abstract double getPaymentAmount(); 
       } 


