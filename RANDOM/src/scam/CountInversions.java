package scam;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class CountInversions {
	// vim: syntax=java
	/*
	 * Finds all inversions of given array where i<j and array[i]>array[j]
	 * 
	 * O(NlogN)
	 */

	public static long countInversions(int[] array, int l, int r) {
		long inv = 0;
		if (l < r) {
			int m = (l + r) / 2;
			inv += countInversions(array, l, m);
			inv += countInversions(array, m + 1, r);

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
					array[k] = right[j];
					j++;
					inv += m + 1 - l - i;
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
		return inv;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("nums.txt"));
		StringTokenizer st;
		int[] array = new int[100000];
		for (int i = 0; i < array.length; i++) {
			st = new StringTokenizer(f.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(countInversions(array, 0, array.length - 1));
		f.close();
	}
}
