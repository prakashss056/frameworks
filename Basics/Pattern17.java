package testng.Basics;
import java.util.Scanner;

public class Pattern17 {
	public static void pat(int num) {
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				if(j%2==0) {
					System.out.print("0"+" ");
				}else {
					System.out.print("1"+" ");
				}
			}
			System.out.println("");
		}		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int num = input.nextInt();
		System.out.println("Here is your pattern....!!!");
		pat(num);
	}
}
/*output
 
1 
1 0 
1 0 1 
1 0 1 0 
1 0 1 0 1 
1 0 1 0 1 0 				*/
