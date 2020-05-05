package scam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deliveryrobot {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<List<Integer>> grid = new ArrayList<>();
		int n = scan.nextInt();
		int m = scan.nextInt();
		for (int i = 0; i < n; i++) {
			grid.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid.get(i).add(scan.nextInt());
			}
		}
		System.out.println(uniquePaths(grid));
		scan.close();
	}

	public static int uniquePaths(List<List<Integer>> grid) {
		int n = grid.size();
		int m = grid.get(0).size();
		int[][] ways = new int[n][m];
		ways[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid.get(i).get(j) == 0) {
					if (j >= 1 && grid.get(i).get(j - 1) == 0) {
						ways[i][j] += ways[i][j - 1];
					}
					if (i >= 1 && grid.get(i - 1).get(j) == 0) {
						ways[i][j] += ways[i - 1][j];
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(ways[i][j] + " ");
			}
			System.out.println();
		}
		return ways[n - 1][m - 1];
	}
}
