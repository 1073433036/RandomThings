package usacoFinished;

import java.util.Scanner;

public class ttime {
	static boolean[][] knowEachOther;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int numPairings = scan.nextInt();
		int numQueries = scan.nextInt();
		knowEachOther = new boolean[numCows][numCows];
		for (int i = 0; i < numPairings; i++) {
			int p1 = scan.nextInt() - 1;
			int p2 = scan.nextInt() - 1;
			knowEachOther[p1][p2] = true;
			knowEachOther[p2][p1] = true;
		}

		for (int i = 0; i < numCows; i++) {
			visited = new boolean[numCows];
			visited[i] = true;
			fill(i, i);
		}

		for (int i = 0; i < numQueries; i++) {
			if (knowEachOther[scan.nextInt() - 1][scan.nextInt() - 1]) {
				System.out.println("Y");
			}
			else {
				System.out.println("N");
			}
		}

		scan.close();
	}

	public static void fill(int start, int pos) {
		knowEachOther[start][pos] = true;
		knowEachOther[pos][start] = true;
		visited[pos] = true;
		for (int i = 0; i < knowEachOther.length; i++) {
			if (!visited[i] && knowEachOther[pos][i]) {
				fill(start, i);
			}
		}
	}
}
