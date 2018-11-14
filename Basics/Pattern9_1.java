package testng.Basics;

public class Pattern9_1 {
public static void main(String...args) {
	int n=5;
	int space=4;
	int star=1;
	for(int i=1;i<=n;i++) {
		for(int j=1;j<=space;j++) {
			System.out.print(" ");
		}
		for(int k=1;k<=star;k++) {
			System.out.print("*");
			
		}
		space--;
		star++;
		System.out.println("");
		}
	}
}
/*output
 		*
 	   **
      ***
     ****
    *****	
if you want triangle insert one space with *
			
	* 
   * * 
  * * * 
 * * * * 
* * * * * 			 

if you want to print number with below pattern please put star variable in place of *
  		1
   	   22
      333
     4444
    55555				*/
