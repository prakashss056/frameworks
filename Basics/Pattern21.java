package testng.Basics;

public class Pattern21 {
	public static void main(String...args){
		String s= "java";
		int len=s.length();		
		
		for(int i=0;i<=len-1;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(s.charAt(j)+" ");
			}
			System.out.println("");
		}
	}
}
/*
j 
j a 
j a v 
j a v a 		*/
