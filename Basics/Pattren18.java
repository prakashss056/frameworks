package testng.Basics;
import java.util.Scanner;

public class Pattren18 {
	public static void pat(int num) {
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=num;j++) {
				if(i==1||j==1||i==num||j==num) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		
	}
public static void main(String...args) {
	Scanner input=new Scanner(System.in);
	System.out.println("enter an input");
	int num=input.nextInt();
	pat(num);
	}
}
/* output
 
*****
*   *
*   *
*   *
*****				*/