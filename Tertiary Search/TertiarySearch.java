package Recursion;

public class TertiarySearch {

	public static void main(String[] args) {
		int[] x1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int[] x2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		// First Test Case
		Integer a1 = search(x1, 4, 0, x1.length - 1);
		if (a1 != null)
			System.out.println("Number found at index: " + a1);
		else
			System.out.println("Number not found");

		// Second Test Case
		Integer a2 = search(x1, 65, 0, x1.length - 1);
		if (a2 != null)
			System.out.println("Number found at index: " + a2);
		else
			System.out.println("Number not found");

		// Third Test Case
		Integer a3 = search(x2, 14, 0, x2.length - 1);
		if (a3 != null)
			System.out.println("Number found at index: " + a3);
		else
			System.out.println("Number not found");

		// Fourth Test Case
		Integer a4 = search(x2, 99, 0, x2.length - 1);
		if (a4 != null)
			System.out.println("Number found at index: " + a4);
		else
			System.out.println("Number not found");
	}

	/**
	 * Tertiary Search Recursive Algorithm
	 * 
	 * @param x
	 * @param i
	 * @param low
	 * @param high
	 * @return
	 */
	private static Integer search(int[] x, int i, int low, int high) {
		int first = low + (high - low) / 3;
		int second = low + (2 * (high - low)) / 3;
		if (low > high) {
			return null;
		} else {
			if (x[first] == i)
				return first;
			else if (x[second] == i)
				return second;
			else if (i < x[first])
				return search(x, i, low, first - 1);
			else if (i > x[first] && i < x[second])
				return search(x, i, first + 1, second - 1);
			else
				return search(x, i, second + 1, high);
		}
	}
}
