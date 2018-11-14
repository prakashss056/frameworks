package testng.Basics;
public class Pattren3 {
	public static void pat(int num) {	
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
	public static void main(String...args) {
		int num=5;
		pat(num);
		}
	}
/*output
 
	1 
	2 2 
	3 3 3 
	4 4 4 4 
	5 5 5 5 5 	*/