package testng.Basics;

public class PrintCommonElentsInanArray {
	
	public static void main(String...args) {
		
		int[] arr1= {3,5,6,7,32,5};
		
		int[] arr2= {5,6,89,8,3,9,10,11,14,15,15,17};
		
		for(int i=0;i<arr1.length;i++) {
			
			for(int j=0;j<arr2.length;j++) {
				
				if(arr1[i]==arr2[j]) {
					System.out.print(arr1[i]+",");
				}
				
			}
		}
	}
}
