package scam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class shortestpathkremovals {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<List<Integer>> grid = new ArrayList<>();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		for (int i = 0; i < n; i++) {
			grid.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid.get(i).add(scan.nextInt());
			}
		}
		System.out.println(shortestPath(grid, k));
		scan.close();
	}

	public static class state {
		int x, y, k;
		int cost = 0;

		public state(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	public static int shortestPath(List<List<Integer>> grid, int k) {
		n = grid.size();
		m = grid.get(0).size();
		visited = new boolean[n][m][k + 1];
		LinkedList<state> q = new LinkedList<>();
		state start = new state(0, 0, k);
		q.add(start);
		while (!q.isEmpty()) {
			state cur = q.poll();
			if (visited[cur.x][cur.y][cur.k]) {
				continue;
			}
			visited[cur.x][cur.y][cur.k] = true;
			if (cur.x == n - 1 && cur.y == m - 1) {
				return cur.cost;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + cx[i];
				int ny = cur.y + cy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}

				if (grid.get(nx).get(ny) == 1) {
					if (cur.k >= 1 && !visited[nx][ny][cur.k - 1]) {
						state st = new state(nx, ny, cur.k - 1);
						st.cost = cur.cost + 1;
						q.add(st);
					}
				}
				else {
					if (!visited[nx][ny][cur.k]) {
						state st = new state(nx, ny, cur.k);
						st.cost = cur.cost + 1;
						q.add(st);
					}
				}
			}
		}
		return -1;
	}

	static int n, m;
	static boolean[][][] visited;
	static int[] cx = { 0, 0, -1, 1 };
	static int[] cy = { 1, -1, 0, 0 };

}
