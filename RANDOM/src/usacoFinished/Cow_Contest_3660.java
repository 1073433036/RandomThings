package usacoFinished;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static boolean[][] winsAgainst;
	static boolean[][] tc;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int numFights = scan.nextInt();

		winsAgainst = new boolean[numCows][numCows];
		for (int i = 0; i < numFights; i++) {
			int winner = scan.nextInt() - 1;
			int loser = scan.nextInt() - 1;
			winsAgainst[winner][loser] = true;
		}

		tc = new boolean[numCows][numCows];
		for (int i = 0; i < numCows; i++) {
			fill(i, i);
		}

		int[] indegrees = new int[numCows];
		int[] outdegrees = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			for (int j = 0; j < numCows; j++) {
				if (tc[i][j]&&i!=j) {
					indegrees[j]++;
					outdegrees[i]++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < numCows; i++) {
			if (indegrees[i] + outdegrees[i] == numCows - 1) {
				count++;
			}
		}

		System.out.println(count);
		scan.close();
	}

	public static void fill(int start, int pos) {
		tc[start][pos] = true;
		for (int i = 0; i < winsAgainst.length; i++) {
			if (!tc[start][i] && winsAgainst[pos][i]) {
				fill(start, i);
			}
		}
	}
}
