package testng.Basics;

public class CheckingInagram {

	public boolean inagram(String s1, String s2) {
		char[] chr = s1.toCharArray();

		StringBuilder secondstring = new StringBuilder(s2);
		for (Character ch : chr) {

			// int index = s2.indexOf(ch);
			int index = secondstring.indexOf("" + ch);

			// if second string length not eqvals to -1 means in second string no more
			// charectotr to compare
			if (index != -1) {

				// string is immutable class we cant delete or modify that's the reason we
				// change to stringbuilder and for string there is no delete functions
				secondstring.deleteCharAt(index);
			}

		}
		if (secondstring.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String... args) {
		CheckingInagram ci = new CheckingInagram();
		boolean returndata = ci.inagram("abc", "bca");
		System.out.print(returndata);
	}

	/*
	 * Inagram means Charecters present in second string should match with the first
	 * string
	 */
}
