
package usaco.NO;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.PrintWriter;
// import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class snakes {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("snakes.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snakes.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numGroups = Integer.parseInt(st.nextToken());
		int numChanges = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		groups = new int[numGroups + 1];
		for (int i = 1; i <= numGroups; i++) {
			groups[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[numGroups + 1][numChanges + 1];
		for (int i = 0; i <= numGroups; i++) {
			for (int j = 0; j <= numChanges; j++) {
				dp[i][j] = -1;
			}
		}

		out.println(cost(0, numChanges));

		for (int i = 0; i <= numGroups; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		out.close();
		f.close();
	}

	static int[] groups;
	static int[][] dp;
	static int max;

	public static int cost(int ind, int ch) {
		if (dp[ind][ch] != -1) {
			return dp[ind][ch];
		}
		if (ind == groups.length - 1) {
			if (ch == 0) {
				if (groups[ind] > max) {
					return 400000001;
				}
				return max - groups[ind];
			}
			return 0;
		}
		int min = Integer.MAX_VALUE;
		if (max < groups[ind + 1]) {
			if (ch == 0) {
				return 400000001;
			}
			int c = max - groups[ind];
			for (int i = ind + 1; i < groups.length; i++) {
				if (groups[i] > max) {
					max = groups[i];
					min = Math.min(min, cost(ind + 1, ch - 1) + c);
				}
			}
			dp[ind][ch] = min;
		}
		else {
			if (ch == 0) {
				min = cost(ind + 1, ch) + max - groups[ind];
			}
			else {
				int c = max - groups[ind];
				for (int i = ind + 1; i < groups.length; i++) {
					max = groups[i];
					min = Math.min(min, cost(ind + 1, ch - 1) + c);
				}
			}
			dp[ind][ch] = min;
		}

		return min;
	}
}
