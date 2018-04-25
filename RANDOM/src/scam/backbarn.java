
package scam;

import java.util.Scanner;

public class backbarn
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		int max = scan.nextInt();
		boolean[][] maze = new boolean[r][c];
		for (int i = r - 1; i >= 0; i--)
		{
			String[] row = scan.next().split("");
			for (int j = 0; j < c; j++)
				maze[i][j] = row[j].equals(".");
		}

		System.out.println(dfs(maze, max, 0, 0, 0));
		scan.close();

	}

	public static int dfs(boolean[][] maze, int max, int r, int c, int length)
	{
		length++;
		if (length > max)
			return 0;
		if (r == maze.length - 1 && c == maze[0].length - 1)
			return 1;
		maze[r][c] = false;
		int[] dr =
			{ 0, 0, 1, -1 };
		int[] dc =
			{ 1, -1, 0, 0 };
		int total = 0;
		for (int i = 0; i < 4; i++)
			if (r + dr[i] < maze.length && r + dr[i] >= 0 && c + dc[i] < maze[0].length && c + dc[i] >= 0
					&& maze[r + dr[i]][c + dc[i]])
				total += dfs(maze, max, r + dr[i], c + dc[i], length);
		maze[r][c] = true;
		length--;
		return total;
	}
}
