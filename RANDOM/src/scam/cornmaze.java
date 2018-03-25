package scam;

import java.util.HashMap;
import java.util.Scanner;

class dposit
{
	public int x1;
	public int y1;
	public int x2;
	public int y2;

	public dposit(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

public class cornmaze
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		int[][] maze = new int[rows][cols];
		int sr = 0, sc = 0;
		int er = 0, ec = 0;
		HashMap<Integer, dposit> teleports = new HashMap<>();
		for (int i = 0; i < rows; i++)
		{
			String[] line = scan.next().split("");
			for (int j = 0; j < cols; j++)
				if (line[j].equals("."))
					maze[i][j] = 1;
				else if (line[j].equals("@"))
				{
					sr = i;
					sc = j;
				}
				else if (line[j].equals("="))
				{
					er = i;
					ec = j;
					maze[i][j] = 1;
				}
				else if (line[j].equals("#"))
					maze[i][j] = 0;
				else
				{
					maze[i][j] = (int) line[j].charAt(0);
					if (teleports.containsKey(maze[i][j]))
						teleports.put(maze[i][j],
								new dposit(teleports.get(line[j]).x1, teleports.get(line[j]).y2, i, j));
					else
						teleports.put(line[j], new dposit(i, j, 0, 0));
				}
		}
		scan.close();
	}
}
