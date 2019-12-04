package scam;

import java.util.Arrays;
import java.util.Scanner;

public class CountInversions {
	static int count = 0;

	public static void mergeSort(int[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(array, l, m);
			mergeSort(array, m + 1, r);

			int[] left = new int[m - l + 1];
			int[] right = new int[r - m];

			for (int i = 0; i < left.length; i++) {
				left[i] = array[l + i];
			}
			for (int i = 0; i < right.length; i++) {
				right[i] = array[m + i + 1];
			}

			int i = 0, j = 0;
			int k = l;
			while (i < left.length && j < right.length) {
				if (left[i] <= right[j]) {
					array[k] = left[i];
					i++;
				}
				else {
					count += m - i + 1;
					array[k] = right[j];
					j++;
				}
				k++;
			}

			while (i < left.length) {
				array[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length) {
				array[k] = right[j];
				j++;
				k++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = { 1, 3, 5, 2, 4, 6 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

		System.out.println(count);
		scan.close();
	}
}
