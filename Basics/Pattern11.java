package testng.Basics;

public class Pattern11 {
	public static void pat(int n) {
		int i,j;
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				System.out.print(i+2+" ");
			}
			System.out.println("");
		}
		for(i=4;i>=1;i--) {
			for(int k=1;k<=i;k++){
				System.out.print(i+2+" ");
			}
			System.out.println("");
		}
	}
	public static void main(String...args) {
		int n=3;
		pat(n);
	}
}

/*output
 
	3
	4 4
	5 5 5
	6 6 6 6
	5 5 5
	4 4
	3		*/