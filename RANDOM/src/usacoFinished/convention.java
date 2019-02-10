
//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class convention {
	static int n, m, c;
	static int[] arrivalTime;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("convention.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arrivalTime = new int[n];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < n; i++) {
			arrivalTime[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrivalTime);

		int left = 0;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (works(mid)) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

		out.println(left);
		out.close();
		f.close();
	}

	public static boolean works(int time) {
		int count = 0;
		for (int i = 0; i < m; i++) {
			int start = arrivalTime[count];
			int cows = 1;
			while (arrivalTime[count] - start <= time && cows <= c) {
				if (count == n - 1) {
					return true;
				}
				count++;
				cows++;
			}
		}

		return count == n;
	}
}
