package scam;

import java.util.Scanner;

public class cost
{
	static int[][] mc;
	static int[][] cost;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt(), n = scan.nextInt();
		mc = new int[m][n];
		cost = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				cost[i][j] = scan.nextInt();

		System.out.println(solve(m - 1, n - 1) + 1);

		scan.close();
	}

	public static int solve(int r, int c)
	{
		if (r < 0 || c < 0)
			return 0;
		if (mc[r][c] == 0)
			mc[r][c] = Math.min(solve(r - 1, c), Math.min(solve(r - 1, c - 1), solve(r, c - 1))) + cost[r][c];
		return mc[r][c];
	}
}
