package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quicksort {
	static long count = 0;

	public static void qs(int[] array, int l, int r) {
		if (r - l + 1 <= 1) {
			return;
		}
		count += r - l;

		int m = (r + l) / 2;
		int ind = r;
		if (array[l] <= array[m]) {
			if (array[m] <= array[r]) {
				ind = m;
			}
			else {
				if (array[l] <= array[r]) {
					ind = r;
				}
				else {
					ind = l;
				}
			}
		}
		else {
			if (array[r] <= array[m]) {
				ind = m;
			}
			else {
				if (array[l] <= array[r]) {
					ind = l;
				}
				else {
					ind = r;
				}
			}
		}

		// System.out.println(array[l]+" "+array[m]+" "+array[r]+"
		// "+array[ind]);

		int t = array[ind];
		array[ind] = array[l];
		array[l] = t;

		int first = array[l];
		int i = l + 1;
		for (int j = l + 1; j <= r; j++) {
			if (array[j] < first) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;
			}
		}

		array[l] = array[i - 1];
		array[i - 1] = first;
		// System.out.println(Arrays.toString(array) + " chosen: " + t + " " + l
		// + " " + i + " " + r);
		qs(array, l, i - 2);
		qs(array, i, r);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("nums.txt"));
		StringTokenizer st;
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			st = new StringTokenizer(f.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		// int[] array = new int[] { 3, 8, 5, 6, 2, 1 };
		System.out.println(Arrays.toString(array));
		qs(array, 0, array.length - 1);

		for (int i = 1; i <= 10000; i++) {
			if (array[i - 1] != i) {
				System.out.println("wrong");
			}
		}

		System.out.println(Arrays.toString(array));
		System.out.println(count);
		f.close();
	}
}
