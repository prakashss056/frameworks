package testng.Basics;

public class Findmiddleindex {
	
	//{4,5,1,6,4,0}here we have to find the at what index leftside sum is equals to the right side sum
	public static int indexofnumber(int[] num) throws Exception {
		
		int leftsum=0;
		int rightsum=0;
		int leftindex=0;
		int rightindex=num.length-1;
		
		while(true) {
			if(leftsum>rightsum) {
				rightsum=rightsum+num[rightindex--];			
			}else {
				leftsum=leftsum+num[leftindex++];
			}
			if(leftindex>rightindex) {
				if(leftsum==rightsum) {
					break;
				}
				else {
					throw new Exception("please enter valid array");
				}
			}
		}
		return rightindex;
	}
	public static void main(String...args) throws Exception {
	
		int[] num= {4,5,1,6,4};
		indexofnumber(num);
		System.out.println("in this index both sides sums are equal"+"-----"+ indexofnumber(num));
	}
}
