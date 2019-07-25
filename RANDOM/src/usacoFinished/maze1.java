/*
ID: juskim81
LANG: JAVA
TASK: maze1
 */
import java.io.IOException;
import java.util.LinkedList;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class maze1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCols = Integer.parseInt(st.nextToken()) * 2 + 1;
		int numRows = Integer.parseInt(st.nextToken()) * 2 + 1;
		boolean[][] maze = new boolean[numRows][numCols];
		for (int r = 0; r < numRows; r++) {
			String line = f.readLine();
			for (int c = 0; c < numCols; c++) {
				maze[r][c] = line.charAt(c) == ' ';
			}
		}

		int maxDist = 0;
		boolean[][] visited;
		int[] ir = { 0, 0, -1, 1 };
		int[] ic = { 1, -1, 0, 0 };

		for (int sr = 1; sr < numRows - 1; sr += 2) {
			for (int sc = 1; sc < numCols - 1; sc += 2) {
				LinkedList<state> left = new LinkedList<>();
				visited = new boolean[numRows][numCols];
				left.add(new state(sr, sc, 1));
				while (!left.isEmpty()) {
					int r = left.peek().r;
					int c = left.peek().c;
					int cost = left.poll().cost;
					if (visited[r][c]) {
						continue;
					}
					visited[r][c] = true;

					for (int i = 0; i < 4; i++) {
						int nr = r + ir[i];
						int nc = c + ic[i];
						if (nr >= 0 && nr < numRows && nc >= 0 && nc < numCols && maze[nr][nc]) {
							left.add(new state(nr + ir[i], nc + ic[i], cost + 1));

							if (nr == 0 || nr == numRows - 1 || nc == 0 || nc == numCols - 1) {
								maxDist = Math.max(maxDist, cost);
								i = 10;
								left.clear();
							}
						}
					}
				}
			}
		}

		out.println(maxDist);
		out.close();
		f.close();
	}

	private static class state {
		int r;
		int c;
		int cost;

		public state(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
}
