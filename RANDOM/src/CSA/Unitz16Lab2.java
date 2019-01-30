/**
 * This program is bubble sort
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz16Lab2 {
	public static void main(String[] args) {
		int[] scrambled = new int[] { 21, 5, 1, 23, 3, 56, 7, 7, 7, 23, 4123, 1290 };

		// bubble sort
		for (int i = 0; i < scrambled.length; i++) {
			for (int j = 0; j + 1 < scrambled.length; j++) {
				if (scrambled[j] > scrambled[j + 1]) {
					swap(scrambled, j, j + 1);
				}
			}
		}

		// print
		for (int i = 0; i < scrambled.length; i++) {
			System.out.print(scrambled[i] + " ");
		}

		// it is O(n^2) because it has to go through the entire array for each
		// element of the array in order to make the largest element bubble up
		// to the end
	}

	// swaps ints at point a and b in arr
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
