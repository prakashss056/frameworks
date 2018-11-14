package testng.Basics;

public class Pattren12 {
	 public static void printNums(int num) 
	 {    
	     int n=1; 
	     int space=5;
	     for(int i=1; i<=num; i++){ 
	         for(int j=1; j<=space; j++) {
	        	 System.out.print(" ");
	         }
	         for(int k=1;k<=i;k++) {
	             System.out.print(n);
	             	n = n + 1; 
	         }  
	         space--;
	         System.out.println(); 
	     }
	 } 
	 public static void main(String args[]) 
	 { 
	     int num = 3; 
	     printNums(num); 
	 } 
} 
