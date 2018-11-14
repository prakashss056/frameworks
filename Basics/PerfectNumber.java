package testng.Basics;

public class PerfectNumber {
	
	public static void perfectnum(int num) {
		int temp=0;
		for(int i=1;i<=num/2;i++) {
			if(num%i==0) {
				temp=temp+i;
			}
		}
		if(num==temp) {
			System.out.println(num+" is a perfect number");
		}
		else {
			System.out.println(num+" is not a perfect number");
		}
	}
	public static void main(String...args) {
		perfectnum(28);
		//perfectnum(8);
	}
}
