package scam;

import java.util.LinkedList;
import java.util.Scanner;

class pos
{
	public int x;
	public int y;

	public pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class bronlily
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		int j1 = scan.nextInt();
		int j2 = scan.nextInt();
		boolean[][] pond = new boolean[rows][cols];
		int sr = 0, sc = 0;
		int er = 0, ec = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
			{
				int cur = scan.nextInt();
				if (cur == 3)
				{
					sr = i;
					sc = j;
				}
				else if (cur == 4)
				{
					er = i;
					ec = j;
					pond[i][j] = true;
				}
				else
					pond[i][j] = cur == 1;
			}
		int[][] dist = new int[rows][cols];
		LinkedList<pos> q = new LinkedList<>();
		q.add(new pos(sr, sc));
		dist[sr][sc] = 0;
		while (!q.isEmpty())
		{
			pos curr = q.pop();
			if (curr.x == er && curr.y == ec)
				break;
			int[] dx =
				{ -j1, j1, -j1, j1, j2, -j2, j2, -j2 };
			int[] dy =
				{ j2, j2, -j2, -j2, j1, j1, -j1, -j1 };
			for (int i = 0; i < 8; i++)
				if (curr.x + dx[i] >= 0 && curr.x + dx[i] < rows && curr.y + dy[i] >= 0 && curr.y + dy[i] < cols
						&& pond[curr.x + dx[i]][curr.y + dy[i]])
				{
					pond[curr.x + dx[i]][curr.y + dy[i]] = false;
					q.add(new pos(curr.x + dx[i], curr.y + dy[i]));
					dist[curr.x + dx[i]][curr.y + dy[i]] = dist[curr.x][curr.y] + 1;
				}
		}

		System.out.println(dist[er][ec]);
		scan.close();
	}
}
