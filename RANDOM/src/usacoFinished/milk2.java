
/*
ID: juskim81
LANG: JAVA
TASK: milk2
 */

 import java.util.StringTokenizer;
 import java.io.BufferedReader;
 import java.io.PrintWriter;
 import java.io.BufferedWriter;
 import java.io.FileReader;
 import java.io.FileWriter;

import java.io.IOException;

public class milk2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFarmers = Integer.parseInt(st.nextToken());
		int maxSize = 1000001;
		int[] starts = new int[maxSize];
		int[] ends = new int[maxSize];
		int maxEnd = 0;
		int minBegin = maxSize;
		for (int i = 0; i < numFarmers; i++) {
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			starts[start]++;
			ends[end - 1]++;
			minBegin = Math.min(minBegin, start);
			maxEnd = Math.max(maxEnd, end - 1);
		}

		boolean[] milking = new boolean[maxSize];
		int farmers = 0;
		for (int i = minBegin; i <= maxEnd; i++) {
			if (starts[i] > 0) {
				farmers += starts[i];
			}
			if (farmers > 0) {
				milking[i] = true;
			}
			farmers -= ends[i];
		}

		int startOne = minBegin - 1;
		int maxOne = 0;
		for (int i = minBegin; i <= maxEnd; i++) {
			if (milking[i]) {
				maxOne = Math.max(maxOne, i - startOne);
			}
			else {
				startOne = i;
			}
		}

		int startNone = minBegin;
		int maxNone = 0;
		for (int i = minBegin; i <= maxEnd; i++) {
			if (!milking[i]) {
				maxNone = Math.max(maxNone, i - startNone);
			}
			else {
				startNone = i;
			}
		}

		out.println(maxOne + " " + maxNone);

		out.close();
		f.close();
	}
}
