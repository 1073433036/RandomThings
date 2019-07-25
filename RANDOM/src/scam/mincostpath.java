package scam;

import java.util.Scanner;

public class mincostpath {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt(), n = scan.nextInt();
		int[][] costs = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				costs[i][j] = scan.nextInt();

		int[][] minCost = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			minCost[i][0] = Integer.MAX_VALUE;
		}
		for (int j = 0; j <= n; j++) {
			minCost[0][j] = Integer.MAX_VALUE;
		}

		minCost[0][0] = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				minCost[i][j] = Math.min(minCost[i - 1][j], Math.min(minCost[i][j - 1], minCost[i - 1][j - 1]))
						+ costs[i][j];
			}
		}

		System.out.println(minCost[m][n]);

		scan.close();
	}

}
