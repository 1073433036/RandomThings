
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Snakes_2019USOpenGold1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("snakes.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snakes.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numSnakes = Integer.parseInt(st.nextToken());
		int numChanges = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());

		int[] groups = new int[numSnakes + 1];
		int total = 0;
		// minimum total net sum
		// cost of changing previous + cost to change up to this point
		int[][] minsum = new int[numSnakes + 1][numChanges + 1];
		int max = -1;
		for (int i = 1; i <= numSnakes; i++) {
			groups[i] = Integer.parseInt(st.nextToken());
			total += groups[i];
			max = Math.max(max, groups[i]);
			minsum[i][0] = i * max;
			for (int j = 1; j <= numChanges; j++) {
				minsum[i][j] = Integer.MAX_VALUE;
				int netmax = 0;
				for (int k = i - 1; k >= 0; k--) {
					netmax = Math.max(netmax, groups[k + 1]);
					minsum[i][j] = Math.min(minsum[i][j], minsum[k][j - 1] + (i - k) * netmax);
				}
			}
		}

		out.println(minsum[numSnakes][numChanges] - total);
		out.close();
		f.close();
	}
}
