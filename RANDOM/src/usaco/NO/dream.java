package usaco.NO;

// package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class dream
{
	private static class state
	{
		int x;
		int y;
		boolean smell;
		int dir;
		int dist;

		public state(int x, int y, boolean smell, int dir, int dist)
		{
			this.x = x;
			this.y = y;
			this.smell = smell;
			this.dir = dir;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("dream.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dream.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] maze = new int[n][m];
		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < m; j++)
				maze[i][j] = Integer.parseInt(st.nextToken());
		}

		boolean[][][][] visited = new boolean[n][m][2][4];
		Queue<state> bfs = new LinkedList<>();
		bfs.add(new state(0, 0, false, 5, 0));
		for (int i = 0; i < 4; i++)
			visited[0][0][0][i] = true;

		int[] dx =
			{ 0, 1, 0, -1 };
		int[] dy =
			{ 1, 0, -1, 0 };
		int minDis = -1;
		while (!bfs.isEmpty())
		{
			state curr = bfs.remove();
			System.out.println(curr.x + " " + curr.y + " " + curr.smell + " " + curr.dir + " " + curr.dist + " "
					+ maze[curr.x][curr.y]);

			if (curr.x == n - 1 && curr.y == m - 1)
			{
				minDis = curr.dist;
				break;
			}

			int min = 0;
			int max = 3;
			if (maze[curr.x][curr.y] == 4)
			{
				min = curr.dir;
				max = min;
			}
			for (int i = min; i <= max; i++)
			{
				int nx = dx[i] + curr.x;
				int ny = dy[i] + curr.y;
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][curr.smell ? 1 : 0][i]
						&& maze[nx][ny] != 0)
				{
					if (maze[nx][ny] == 1)
					{
						for (int j = 0; j < 4; j++)
							visited[nx][ny][curr.smell ? 1 : 0][j] = true;
						bfs.add(new state(nx, ny, curr.smell, i, curr.dist + 1));
					}
					else if (maze[nx][ny] == 2)
					{
						for (int j = 0; j < 4; j++)
							for (int k = 0; k < 2; k++)
								visited[nx][ny][k][j] = true;
						bfs.add(new state(nx, ny, true, i, curr.dist + 1));
					}
					else if (maze[nx][ny] == 3)
					{
						if (curr.smell)
						{
							for (int j = 0; j < 4; j++)
								visited[nx][ny][1][j] = true;
							bfs.add(new state(nx, ny, curr.smell, i, curr.dist + 1));
						}
					}
					else if (maze[nx][ny] == 4)
					{
						visited[nx][ny][0][i] = true;
						visited[nx][ny][1][i] = true;
						bfs.add(new state(nx, ny, false, i, curr.dist + 1));
					}
				}
			}
		}

		out.println(minDis);
		out.close();
		f.close();
	}
}
