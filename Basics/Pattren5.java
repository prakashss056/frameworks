package testng.Basics;
public class Pattren5 {
	public static void pat(int num) {    
		for(int i=1;i<=num;i++){
			for(int j=num;j>=i;j--) {
				System.out.print("*"+" ");
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
 
 * * * * * 
 * * * * 
 * * * 
 * * 
 * 			*/

