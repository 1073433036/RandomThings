package foobar;

import java.util.LinkedList;
import java.util.Queue;

public class mazebreakwall {

	private static class state {
		int x;
		int y;
		boolean used;
		int dist;

		public state(int x, int y, int dist, boolean used) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.used = used;

		}
	}

	public static int answer(int[][] maze) {
		Queue<state> bfs = new LinkedList<>();
		boolean[][][] went = new boolean[maze.length][maze[0].length][2];
		went[0][0][0] = true;
		bfs.add(new state(0, 0, 1, false));
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		while (!bfs.isEmpty()) {
			state c = bfs.remove();

			if (c.x == maze.length - 1 && c.y == maze[0].length - 1) {
				return c.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && !went[nx][ny][c.used ? 1 : 0]) {
					went[nx][ny][c.used ? 1 : 0] = true;
					if (maze[nx][ny] == 1) {
						if (!c.used) {
							bfs.add(new state(nx, ny, c.dist + 1, true));
						}
					}
					else {
						bfs.add(new state(nx, ny, c.dist + 1, c.used));
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(answer(new int[][] { { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 0 } }));
		System.out.println(answer(new int[][] { { 0, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 1 },
				{ 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 } }));
		System.out.println(answer(new int[][] { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } }));

	}
}
