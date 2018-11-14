package testng.Basics;
public class Patrren1 {
public static void pat(int num) {
	for(int i=1;i<=num;i++) {
		for(int j=1;j<=i;j++) {
			System.out.print(j+" ");
		}
		System.out.println("");
	}
}
public static void main(String...args) {
	int num=5;
	pat(num);
	}
}
/* output
 
	1 
	1 2 
	1 2 3 
	1 2 3 4 
	1 2 3 4 5 	*/
