package scam;

import java.util.Scanner;

public class maze
{
	// public static void main(String[] args)
	// {
	// System.out.println(solve());
	// }

	String solve()
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		String[][] maze = new String[n][m];
		int r = 0, c = 0;
		for (int i = 0; i < n; i++)
		{
			maze[i] = scan.next().split("");
			for (int j = 0; j < m; j++)
				if (maze[i][j].equals("S"))
				{
					r = i;
					c = j;
				}
		}

		scan.close();
		return dfs(maze, r, c);
	}

	String dfs(String[][] maze, int r, int c)
	{
		if (maze[r][c].equals("F"))
			return "";
		String result = "1";
		maze[r][c] = "#";
		boolean done = false;
		if (!maze[r - 1][c].equals("#"))
		{
			String temp = dfs(maze, r - 1, c);
			if (!temp.equals("1"))
			{
				result = "U" + temp;
				done = true;
			}
		}
		if (!maze[r + 1][c].equals("#") && !done)
		{
			String temp = dfs(maze, r + 1, c);
			if (!temp.equals("1"))
			{
				result = "D" + temp;
				done = true;
			}
		}
		if (!maze[r][c + 1].equals("#") && !done)
		{
			String temp = dfs(maze, r, c + 1);
			if (!temp.equals("1"))
			{
				result = "R" + temp;
				done = true;
			}
		}
		if (!maze[r][c - 1].equals("#") && !done)
		{
			String temp = dfs(maze, r, c - 1);
			if (!temp.equals("1"))
			{
				result = "L" + temp;
				done = true;
			}
		}
		return result;
	}
}
