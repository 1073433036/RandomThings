package usaco.NO;

import java.util.LinkedList;
import java.util.Scanner;

public class Lilypad_Pond_3271 {
	private static class state {
		int x;
		int y;

		public state(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numRows = scan.nextInt();
		int numCols = scan.nextInt();
		int[][] map = new int[numRows][numCols];

		int startx = 0;
		int starty = 0;
		int endx = 0;
		int endy = 0;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				map[i][j] = scan.nextInt();
				if (map[i][j] == 3) {
					startx = i;
					starty = j;
				}
				if (map[i][j] == 4) {
					endx = i;
					endy = j;
				}
			}
		}

		LinkedList<state> left = new LinkedList<state>();
		long[][] numTimes = new long[numRows][numCols];
		boolean[][] visited = new boolean[numRows][numCols];
		long[][] distances = new long[numRows][numCols];
		int[] cx = { 2, 2, -2, -2, 1, -1, 1, -1 };
		int[] cy = { 1, -1, 1, -1, 2, 2, -2, -2 };

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				distances[i][j] = numRows * numCols;
			}
		}
		left.add(new state(startx, starty));
		numTimes[startx][starty] = 1;
		distances[startx][starty] = 0;
		while (!left.isEmpty()) {
			int x = left.peek().x;
			int y = left.poll().y;
			if (visited[x][y]) {
				continue;
			}

			visited[x][y] = true;
			for (int i = 0; i < 8; i++) {
				int nx = x + cx[i];
				int ny = y + cy[i];
				if (nx >= 0 && nx < numRows && ny >= 0 && ny < numCols && map[nx][ny] != 2) {
					LinkedList<state> inleft=new LinkedList<state>();
					inleft.add(new state(nx,ny));
					
//					long ncost = distances[x][y] + (map[nx][ny] == 0 ? 1 : 0);
//					if (ncost < distances[nx][ny]) {
//						numTimes[nx][ny] = numTimes[x][y];
//						distances[nx][ny] = ncost;
//						visited[nx][ny] = false;
//						left.add(new state(nx, ny));
//					}
//					else if (ncost == distances[nx][ny]) {
//						numTimes[nx][ny] += numTimes[x][y];
//						if (map[x][y] + map[nx][ny] <= 1) {
//							visited[nx][ny] = false;
//						}
//						left.add(new state(nx, ny));
//					}
				}
			}
		}
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.print(distances[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.print(numTimes[i][j] + "\t");
			}
			System.out.println();
		}

		if (distances[endx][endy] != numRows * numCols)

		{
			System.out.println(distances[endx][endy]);
			System.out.println(numTimes[endx][endy]);
		}
		else {
			System.out.println(-1);
		}
		scan.close();
	}
}
