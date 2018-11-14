package testng.Basics;

import java.util.Scanner;

public class Pattern16 {
	public static void pat(int num) {
		for (int i=1;i<=num;i++) {
			for (int j=i;j>=1;j--) {
				System.out.print(j + " ");
			}
			System.out.println();
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
2 1 
3 2 1 
4 3 2 1 
5 4 3 2 1 			*/
