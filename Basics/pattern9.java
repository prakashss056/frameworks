package testng.Basics;
public class pattern9 {
	  public static void printStars(int num) 
	    {
	        for(int i=1; i<=num; i++) 
	        { 
	  	            for(int j=2*(num-i); j>=1; j--) 
	            { 
	                System.out.print(" "); 
	            }
	            for(int k=1; k<=i; k++) 
	            { 
	                System.out.print(k+" "); 
	            } 
	            System.out.println(); 
	        } 
	    }  
	    public static void main(String args[]) 
	    { 
	        int num = 5; 
	        printStars(num); 
	    } 
	} 

/*output

        1 
      1 2 
    1 2 3 
  1 2 3 4 
1 2 3 4 5 

put star to in place of k to get this pattern
		* 
	  * * 
    * * * 
  * * * * 
* * * * * 			*/

