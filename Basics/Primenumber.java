package testng.Basics;

public class Primenumber {
	public static void prime(int num) {
		
		boolean flag=false;
		for(int i=2;i<num/2;i++) {	
			if(num%i==0) {
				flag=true;
						break;				
			}else {
				flag=false;
			}
		}
		if(flag) {
			System.out.println("it is not prime");			
		}
		else {
			System.out.println("it is prime");
		}
	}
	public static void main(String...args) {
		int num=7;
		prime(num);
	}

}
