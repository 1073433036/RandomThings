package scam;

import java.util.Arrays;
import java.util.Scanner;

public class bteamsrevisited {
	static int numCows = 16;
	static int numTeams = 4;
	static int[] cows = new int[numCows];
	static int[] xcows = new int[numCows];
	static int[] teams = new int[numTeams];
	static boolean[] visited = new boolean[numCows];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < numCows; i++) {
			cows[i] = scan.nextInt();
		}
		Arrays.sort(cows);

		xcows[0] = 0;
		teams[0] = cows[0];
		visited[0] = true;
		back(1);
		System.out.println(result);
		scan.close();
	}

	public static void back(int i) {
		if (i >= numCows) {
			updateResult();
			return;
		}

		if (i >= 4 && i <= 11 && !valid(i)) {
			return;
		}

		int startind = 1;
		if (i % 4 > 0) {
			startind = xcows[i - 1] + 1;
		}
		else if (i >= 4) {
			startind = xcows[i - 4] + 1;
		}

		for (int c = startind; c < numCows; c++) {
			if (!visited[c]) {
				xcows[i] = c;
				teams[i / 4] += cows[c];
				visited[c] = true;
				back(i + 1);
				visited[c] = false;
				teams[i / 4] -= cows[c];
			}
		}
	}

	public static void updateResult() {
		int max = teams[0];
		int min = teams[0];
		for (int i = 1; i < numTeams; i++) {
			max = Math.max(max, teams[i]);
			min = Math.min(min, teams[i]);
		}

		result = Math.min(result, max - min);
	}

	public static boolean valid(int i) {
		i = i / 4 - 1;
		int max = teams[0];
		int min = teams[0];
		for (int t = 1; t < i; t++) {
			max = Math.max(max, teams[i]);
			min = Math.min(min, teams[i]);
		}
		return Math.abs(teams[i] - min) < result && Math.abs(max - teams[i]) < result;
	}

}
