
/**
 * File name: CovidStatistic.java
 * @author Hana Kebede
 * Course: CST8284
 * Assignment: Lab 2
 * Date: 23/01/2023
 * Professor: Leanne Seaward
 * Purpose: covid Statistic
 */

/**
 * This class contains a main method which
 * drives the application
 */
public class CovidStatistic {

	
	/**
	 * This method is 2D array to print the 
	 * patients recovered  from Covid each month 
	 * and the total recovered patient total
	 * 
	*/
public static void main(String[] args)
 {
   final int ROWS = 7;
   final int COLUMNS = 8;

   int[][] patients = 
		  
		  
      { 
         {  2200, 1100, 1200, 1000, 1015, 2000, 1092, 2204 },
         {  5020, 6105, 2009, 9047, 1016, 2014, 2708, 2308 }, 
         {  1720, 2406, 3054, 1018, 1023, 3100, 1406, 1502 }, 
         {  1490, 2002, 2016, 5008, 2044, 1055, 1607, 2201 },
         {  1520, 1007, 1092, 2065, 1023, 1010, 1046, 1502 },
         {  1670, 1201, 2008, 2001, 1086, 1009, 1041, 1706 },
	     {  1870, 2001, 2078, 1006, 1053, 1702, 1009, 1406 }
         
      };

   String[] provinces = 
      { 
         "Ontario", 
         "Quebec", 
         "Nova Scotia",
         "New Brunswick", 
         "Manitoba", 
         "B Columbia",
	     "P E I   "         
      };
   
   System.out.println("            Month        Feb     March   April     May    June   July    Aug    Sept ");
   System.out.println();

 
   int totalpatients = 0;
   int recoverdperson = 0;
 
   /**
    * This is a nested loop to print the covid recovered 
    * patient table in all Canada's seven province 
    */
   	  for (int i=0; i < ROWS; i++) {
   		  System.out.printf("%19s", provinces[i]+ "");
   		  
   		  
   		 for(int j = 0; j < COLUMNS; j++ ) {
   			 System.out.printf("\t" + patients[i][j]);
   			 
   			 totalpatients += patients[i][j];
   			
   			 
   		 }
   System.out.println("  ");
   		 }
   	   	
   /** TASK: It is important to know the number of patients per province. So you need to print out the number of patients for all provinces (content of the array) for each month.
   * Update the code in this section by using a nested for loop. 
   * 
   */
   
   /** TASK: Update the code in this section by writing a nested for loop (for the columns and rows of the array) to compute the sum (column). 
   * Print the column sum using printf. Check the sample output file (CovidSample) to see the expected pattern to print the details using printf.
   */ 
   
   /**
    * This is a nested for loop to print  the sum of recovered covid 
    * patient table each month in all Provence by using 
    * 
   */
   System.out.println();
   System.out.printf("%19s", "Recovered Patients");
	for(int i=0;i<COLUMNS;i++) {
   		int sum =0;
  	   for(int j=0;j<ROWS;j++) {
  		   sum += patients[j][i];
  	   
  	   }
  	   
  	 System.out.printf("\t%s", sum);
  	   }
	
	System.out.printf("\n%21s%d"," Recovered total     =   ",totalpatients); 
  

   // TO DO: INSERT CODE HERE FOR THIS SECTION!!! Check the sample output file (CovidSample) to see the expected pattern.

   
   System.out.println(); 
   System.out.println(); 
   System.out.println("          Vaccinate and maintain good health practices!" );
}
   	}




   
   
   
   
   




