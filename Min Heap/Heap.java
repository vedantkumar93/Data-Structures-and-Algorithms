
/**
 * Minimum Heap
 * 
 * @author vedant
 *
 */
public class Heap {

	public static void main(String[] args) {
		int arr[] = new int[] { 12, 120, 147, 22, 68, 5, 99, 121, 33, 57, 87, 71, 42 };

		System.out.print("Array before converted to Min Heap: ");
		printArray(arr);

		arr = balanceHeap(arr);
		System.out.print("\nArray after converted to Min Heap: ");
		printArray(arr);

		arr = insert(arr, 14);
		System.out.print("\nAfter inserting value in Min Heap: ");
		printArray(arr);

		arr = delete(arr);
		System.out.print("\nAfter deleting value in Min Heap:");
		printArray(arr);
	}

	private static int[] delete(int[] arr) {
		int array[] = new int[arr.length - 1];
		for (int i = 0; i < array.length; i++)
			array[i] = arr[i];
		array[0]--;
		array[1] = arr[arr.length - 1];
		return balanceHeap(array);
	}

	private static int[] insert(int[] arr, int num) {
		int array[] = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++)
			array[i] = arr[i];
		array[0]++;
		array[array.length - 1] = num;
		return balanceHeap(array);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static int[] balanceHeap(int[] arr) {
		int parIndex = arr[0] / 2;
		while (parIndex > 0) {
			if (arr[0] >= parIndex * 2 + 1) { // Check for Both Child Existence
				if (arr[parIndex] > arr[parIndex * 2] || arr[parIndex] > arr[parIndex * 2 + 1]) { // When parent value
																									// is more than
																									// either of the
																									// child value

					// Swapping the values of parent and minimum child when parent is more than child

					int minValue = Math.min(arr[parIndex * 2], arr[parIndex * 2 + 1]);
					int minIndex = arr[parIndex * 2] == minValue ? parIndex * 2 : parIndex * 2 + 1;
					arr[minIndex] = arr[parIndex];
					arr[parIndex] = minValue;

					arr = percolateDown(arr, minIndex);
				}

			} else if (arr[0] >= parIndex * 2) { // If only Left Child is present
				if (arr[parIndex] > arr[parIndex * 2]) {

					// Swapping the values of parent and only child when parent is more than child

					int temp = arr[parIndex];
					arr[parIndex] = arr[parIndex * 2];
					arr[parIndex * 2] = temp;

					arr = percolateDown(arr, parIndex * 2);
				}
			}
			parIndex--;
		}
		return arr;
	}

	private static int[] percolateDown(int[] arr, int parIndex) {
		int minIndex = 0;
		while (arr[0] >= parIndex * 2 + 1 && minIndex != -1) { // Both child exists
			minIndex = -1;
			if (arr[parIndex] > arr[parIndex * 2] || arr[parIndex] > arr[parIndex * 2 + 1]) {

				// Swapping the values of parent and minimum child when parent is more than child

				int minValue = Math.min(arr[parIndex * 2], arr[parIndex * 2 + 1]);
				minIndex = arr[parIndex * 2] == minValue ? parIndex * 2 : parIndex * 2 + 1;
				arr[minIndex] = arr[parIndex];
				arr[parIndex] = minValue;
			}
			parIndex = minIndex;
		}
		while (arr[0] >= parIndex * 2 && minIndex != -1) { // Only Left Child exists
			minIndex = -1;
			if (arr[parIndex] > arr[parIndex * 2]) {

				// Swapping the values of parent and child when parent is more than child

				int temp = arr[parIndex];
				arr[parIndex] = arr[parIndex * 2];
				arr[parIndex * 2] = temp;
			}
			parIndex = parIndex * 2;
		}
		return arr;
	}
}