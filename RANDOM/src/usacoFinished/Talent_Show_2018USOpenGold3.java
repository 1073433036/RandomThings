
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.Arrays;
import java.io.IOException;

public class Talent_Show_2018USOpenGold3 {
	private static class cow implements Comparable<cow> {
		int talent;
		int weight;

		public cow(int w, int t) {
			talent = t;
			weight = w;
		}

		public int compareTo(cow o) {
			if (o.talent == this.talent) {
				return o.weight - this.weight;
			}
			return o.talent - this.talent;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("talent.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numCows = Integer.parseInt(st.nextToken());
		int minWeight = Integer.parseInt(st.nextToken());

		cow[] cows = new cow[numCows];
		int total = 0;
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			total += cows[i].talent;
		}

		Arrays.sort(cows);

		int[][] dp = new int[numCows + 1][total + 1];
		for (int i = 1; i <= numCows; i++) {
			dp[i][cows[i - 1].talent] = cows[i - 1].weight;
		}
		for (int i = 1; i <= numCows; i++) {
			for (int j = cows[i - 1].talent; j <= total; j++) {
				if (dp[i - 1][j] != 0) {
					dp[i][j] = dp[i - 1][j];
				}

				int back = j - cows[i - 1].talent;
				if (dp[i - 1][back] != 0) {
					int nc = dp[i - 1][back] + cows[i - 1].weight;
					if (dp[i][j] == 0 || nc < dp[i][j]) {
						dp[i][j] = nc;
					}
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= total; i++) {
			int test = (int) Math.floor(i * 1000.0 / dp[numCows][i]);
			if (dp[numCows][i] >= minWeight) {
				max = Math.max(max, test);
			}
		}

		out.println(max);
		out.close();
		f.close();
	}
}
