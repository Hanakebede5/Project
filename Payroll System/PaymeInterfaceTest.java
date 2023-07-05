package w3assigment2;

/**
    * File name:Paymeinterface.java
    * @author Hana Kebede
    * Course: CST8284
    * Assignment: Lab 6
    * Date: 31/03/2023
    * Professor:Leanne Seaward
    * Purpose:AlarmClock
    */

/**
 * The PaymeInterfaceTest class demonstrates polymorphic 
 * processing of objects that implement the Payme interface.
 * @author Hanak
 *
 */
public class PaymeInterfaceTest  {
	
/**
 * The main method creates an array of Payme objects with different 
 * implementations of the interface. The getPaymentAmount method is
 * called on each object to demonstrate polymorphic processing.
 * @param args the command-line arguments as an array of String objects
 */
public static void main(String[] args) {
	
 
	       Payme[] paymeObjects = new Payme[6];

			paymeObjects[0]= new Invoice("22776", "Brakes",3,300); 
			paymeObjects[1]= new Invoice("33442", "Gear",5, 90.99);
			paymeObjects[2]= new SalariedProgrammer("Chioma","Kebede","345-67-0001",320.00 );
			paymeObjects[3]= new HourlyProgrammer("Amara","Kebede","234-56-7770",40.00,18.95);
			paymeObjects[4]= new CommissionProgrammer("Hana","Kebede","123-45-6999",16500,0.44 );
			paymeObjects[5]= new BasePlusCommissionProgrammer("Esther","Kebede","102-34-5888",1200,0.04,720);

 System.out.println(
    "Payment for Invoices and Programmers are processed polymorphically:\n"); 

 
 // generically process each element in array paymeObjects
 for (Payme currentPayme : paymeObjects) {
	// output currentPayme and its appropriate payment amount
    System.out.printf("%s \n",currentPayme.toString()); 
       
    if (currentPayme instanceof BasePlusCommissionProgrammer) {
    	   // downcast Payme reference to 
	       // BasePlusCommissioProgrammer reference
       BasePlusCommissionProgrammer programmer = 
          (BasePlusCommissionProgrammer) currentPayme;

       double oldBaseSalary = programmer.getBaseSalary();
       programmer.setBaseSalary(1.10 * oldBaseSalary);
       System.out.printf(
          "new base salary with 10%% increase is: $%,.2f\n",
          programmer.getBaseSalary());
         }
   System.out.printf("payment due: $%,.2f\n\n",currentPayme.getPaymentAmount());



 }
}
}


