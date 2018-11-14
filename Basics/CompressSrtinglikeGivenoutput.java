package testng.Basics;

public class CompressSrtinglikeGivenoutput {
	

	public void compressString(String s1) {
		
		int count=0;
		char temp=s1.charAt(0);
		
		for(int i=0;i<s1.length();i++) {
			
			if(s1.charAt(i)==temp) {
				
				count++;
			}
			else {
				System.out.print(temp+""+count);
				count=1;
				temp=s1.charAt(i);
			}		
		}
		System.out.print(temp+""+count);
	}
	
	
	public static void main(String...args) {
		
		String s1="aaabbferss";
		//i want output like a3b2f1e1r1s2	
		
		CompressSrtinglikeGivenoutput str=new CompressSrtinglikeGivenoutput();
		str.compressString(s1);
		
	}
}









