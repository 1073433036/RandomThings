package usaco.NO;

// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.IOException;

public class haircut {
	public static long mergeSort(int[] array, int l, int r) {
		long inv = 0;
		if (l < r) {
			int m = (l + r) / 2;
			inv += mergeSort(array, l, m);
			inv += mergeSort(array, m + 1, r);

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
		BufferedReader f = new BufferedReader(new FileReader("haircut.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haircut.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numHairs = Integer.parseInt(st.nextToken());
		int[] hairs = new int[numHairs];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numHairs; i++) {
			hairs[i] = Math.min(Integer.parseInt(st.nextToken()), numHairs - 1);
		}

		long[] res = new long[numHairs];
		res[0] = mergeSort(Arrays.copyOf(hairs, numHairs), 0, numHairs - 1);
		for (int i = 1; i < numHairs; i++) {
			long result = res[i - 1];
			int max = numHairs - i - 1;
			int at = 0;
			int below = 0;
			for (int j = numHairs - 1; j >= 0; j--) {
				if (hairs[j] > max) {
					hairs[j] = max;
					result -= at;
				}
				else if (hairs[j] == max) {
					at++;
				}
				else {
					below++;
				}
			}
			res[i] = result;
		}

		for (int i = numHairs - 1; i >= 0; i--) {
			out.println(res[i]);
		}

		out.close();
		f.close();
	}
}
