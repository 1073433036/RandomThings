package scam;

import java.util.Scanner;

public class space
{
	public static boolean[][] grid;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int side = scan.nextInt();
		grid = new boolean[side][side];
		for (int i = 0; i < side; i++)
		{
			String[] line = scan.next().split("");
			for (int j = 0; j < side; j++)
				if (line[j].equals("*"))
					grid[i][j] = true;
		}

		int count = 0;
		for (int i = 0; i < side; i++)
			for (int j = 0; j < side; j++)
				if (grid[i][j])
				{
					flood(i, j);
					count++;
				}

		System.out.println(count);
		scan.close();
	}

	public static void flood(int row, int col)
	{
		grid[row][col] = false;

		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++)
			if (row + dx[i] > -1 && row + dx[i] < grid.length && col + dy[i] > -1 && col + dy[i] < grid[0].length
					&& grid[row + dx[i]][col + dy[i]])
				flood(row + dx[i], col + dy[i]);
	}
}
