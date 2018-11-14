package testng.Basics;

public class Bubblesort {

	public static void bubble(int[] array) {
		int temp;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				
				if(array[i]>array[j]) {
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;	
				}	
			}
		}
		printarry(array);
	}
	public static void printarry(int[] input) {
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+",");
		}
		System.out.print("\n");
		
	}
	public static void main(String...args) {
		int[] array={2,5,1,30,5,4,7};
		bubble(array);
		
	}
	
	
	
	
	
	
	
	
	
	
}
