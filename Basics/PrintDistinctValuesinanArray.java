package testng.Basics;

public class PrintDistinctValuesinanArray {

	public static void main(String... args) {
		int[] arry = { 1, 5, 6, 5, 8, 2, 1, 6 };

		for (int i = 0; i < arry.length; i++) {
			boolean isDistinct = false;

			for (int j = 0; j < i; j++) {

				if (arry[i] == arry[j]) {

					isDistinct = true;

					break;
				}
			}

			if (!isDistinct) {
				System.out.print(arry[i] + ",");

			}
		}
	}
}
