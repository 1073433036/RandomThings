
//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Grazing_Patterns_2012JanBronze3 {
	public static int obstacle = 0;
	public static boolean[][] maze = new boolean[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("grazing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("grazing.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		obstacle = Integer.parseInt(st.nextToken());
		for (int i = 0; i < obstacle; i++) {
			st = new StringTokenizer(f.readLine());
			maze[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}

		out.println(dfs(0, 0));
		f.close();
		out.close();
	}

	public static int dfs(int x, int y) {
		if (x < 0 || x > 4 || y < 0 || y > 4 || maze[x][y])
			return 0;
		obstacle++;
		maze[x][y] = true;
		int total = 0;
		if (x == 4 && y == 4 && obstacle == 25)
			total = 1;
		else
			total = dfs(x, y + 1) + dfs(x, y - 1) + dfs(x + 1, y) + dfs(x - 1, y);
		maze[x][y] = false;
		obstacle--;

		return total;
	}
}
