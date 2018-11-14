package testng.Basics;

public class Pattern13{
	public static void pat(int num) {
	for(int i=num;i>=1;i--) 
    {
        for (int j=num;j>=i; j--)
        {
            System.out.print(j+" ");
        }
        System.out.println();
    	}
	}
	public static void main(String...args) {
		int num=7;
		pat(num);	
	}
}

/*


7
7 6
7 6 5
7 6 5 4
7 6 5 4 3
7 6 5 4 3 2
7 6 5 4 3 2 1			*/