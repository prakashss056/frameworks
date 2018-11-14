package testng.Basics;

public class Fibbonenency {
	public static void main(String...args) {
		int firstnumber=0;
		int secondnumber=1;
		
		
		System.out.print(firstnumber+" ");
		System.out.print(secondnumber+" ");
		
		for(int i=0;i<10;i++) {
			int thirdnumber=firstnumber+secondnumber;
			System.out.print(thirdnumber+" ");		
			firstnumber=secondnumber;
			secondnumber=thirdnumber;
		}
	}

}
