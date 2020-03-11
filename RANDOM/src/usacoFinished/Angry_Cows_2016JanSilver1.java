//package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class Angry_Cows_2016JanSilver1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("angry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numBales = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());

		int[] bales = new int[numBales];
		for (int i = 0; i < numBales; i++) {
			st = new StringTokenizer(f.readLine());
			bales[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(bales);

		int left = 0;
		int right = 500000000;
		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			int next = -1;
			for (int i = 0; i < numBales; i++) {
				if (bales[i] <= next) {
					continue;
				}

				next = bales[i] + mid * 2;
				count++;
			}

			if (count > numCows) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
			// System.out.println(right + " " + count);
		}

		out.println(left);
		out.close();
		f.close();
	}
}
