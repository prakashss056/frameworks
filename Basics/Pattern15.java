package testng.Basics;

import java.util.Scanner;

public class Pattern15 {
	public static void pat(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			for (int k = i; k >= 1; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int num = input.nextInt();
		System.out.println("Here is your pattern....!!!");
		pat(num);
	}
}
/* output
	1 
	1 2 1 
	1 2 3 2 1 
	1 2 3 4 3 2 1 
	1 2 3 4 5 4 3 2 1 			*/