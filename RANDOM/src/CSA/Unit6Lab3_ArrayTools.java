/**
 * This class holds static methods for manipulating arrays
 */

package CSA;

import java.util.Arrays;

public class Unit6Lab3_ArrayTools {
	public static char minimum(char array[]) {
		char min = array[0];
		for (int i = 0; i < array.length; i++) {
			min = (char) Math.min(min, array[i]);
		}

		return min;
	}

	public static int minimum(int array[]) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}

		return min;
	}

	public static double minimum(double array[]) {
		double min = array[0];
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}

		return min;
	}

	public static char maximum(char array[]) {
		char max = array[0];
		for (int i = 0; i < array.length; i++) {
			max = (char) Math.max(max, array[i]);
		}

		return max;
	}

	public static int maximum(int array[]) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}

		return max;
	}

	public static double maximum(double array[]) {
		double max = array[0];
		for (int i = 0; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}

		return max;
	}

	public static int minimumAt(char array[]) {
		char min = array[0];
		int ind = 0;
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
				ind = i;
			}
		}

		return ind;
	}

	public static int minimumAt(int array[]) {
		int min = array[0];
		int ind = 0;
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
				ind = i;
			}
		}

		return ind;
	}

	public static int minimumAt(double array[]) {
		double min = array[0];
		int ind = 0;
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
				ind = i;
			}
		}

		return ind;
	}

	public static int maximumAt(char array[]) {
		char max = array[0];
		int ind = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
				ind = i;
			}
		}

		return ind;
	}

	public static int maximumAt(int array[]) {
		int max = array[0];
		int ind = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
				ind = i;
			}
		}

		return ind;
	}

	public static int maximumAt(double array[]) {
		double max = array[0];
		int ind = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
				ind = i;
			}
		}

		return ind;
	}

	public static double average(int[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		return sum / array.length;
	}

	public static double average(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		return sum / array.length;
	}

	public static boolean equals(char[] a1, char[] a2) {
		return Arrays.equals(a1, a2);
	}

	public static boolean equals(int[] a1, int[] a2) {
		return Arrays.equals(a1, a2);
	}

	public static boolean equals(double[] a1, double[] a2) {
		return Arrays.equals(a1, a2);
	}

	public static int find(char[] array, char key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}

		return -1;
	}

	public static int find(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}

		return -1;
	}

	public static int find(double[] array, double key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}

		return -1;
	}

	public static void sort(char[] array) {
		Arrays.sort(array);
	}

	public static void sort(int[] array) {
		Arrays.sort(array);
	}

	public static void sort(double[] array) {
		Arrays.sort(array);
	}

}
