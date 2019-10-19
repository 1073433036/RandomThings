package usaco.NO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Lilypad_Pond_3271 {
	private static class point {
		HashMap<state, Long> beforeAdded;
		long numTimes;
		long cost;

		public point(long numTimes, long cost) {
			beforeAdded = new HashMap<state, Long>();
			this.numTimes = numTimes;
			this.cost = cost;
		}
	}

	private static class state {
		int x;
		int y;

		public state(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int hashCode() {
			return x + y;
		}

		public boolean equals(Object o) {
			return ((state) o).x == x && ((state) o).y == y;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numRows = scan.nextInt();
		int numCols = scan.nextInt();
		int[][] pondmap = new int[numRows][numCols];

		int startx = 0;
		int starty = 0;
		int endx = 0;
		int endy = 0;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				pondmap[i][j] = scan.nextInt();
				if (pondmap[i][j] == 3) {
					startx = i;
					starty = j;
					pondmap[i][j] = 1;
				}
				if (pondmap[i][j] == 4) {
					endx = i;
					endy = j;
					pondmap[i][j] = 1;
				}
			}
		}

		LinkedList<state> left = new LinkedList<state>();
		point[][] pond = new point[numRows][numCols];
		int[] cx = { 2, 2, -2, -2, 1, -1, 1, -1 };
		int[] cy = { 1, -1, 1, -1, 2, 2, -2, -2 };

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				pond[i][j] = new point(0, Long.MAX_VALUE);
			}
		}
		left.add(new state(startx, starty));
		pond[startx][starty].cost = 0;
		pond[startx][starty].numTimes = 1;
		while (!left.isEmpty()) {
			int x = left.peek().x;
			int y = left.poll().y;
			if (x == endx && y == endy) {
				continue;
			}
			// System.out.println(x + " " + y);
			// for (int i = 0; i < numRows; i++) {
			// for (int j = 0; j < numCols; j++) {
			// System.out.print(pond[i][j].cost);
			// }
			// System.out.println();
			// }
			// System.out.println();
			// for (int i = 0; i < numRows; i++) {
			// for (int j = 0; j < numCols; j++) {
			// System.out.print(pond[x][y].numTimes);
			// }
			// System.out.println();
			// }
			// System.out.println();

			for (int i = 0; i < 8; i++) {
				int nx = x + cx[i];
				int ny = y + cy[i];
				if (nx >= 0 && nx < numRows && ny >= 0 && ny < numCols && pondmap[nx][ny] != 2) {
					long prevcost = pond[x][y].cost;
					long oldcost = pond[nx][ny].cost;
					long ncost = prevcost + (pondmap[nx][ny] == 0 ? 1 : 0);

					if (ncost < oldcost) {
						pond[nx][ny].cost = ncost;
						pond[nx][ny].numTimes = pond[x][y].numTimes;
						pond[nx][ny].beforeAdded.clear();
						if (pondmap[x][y] == 0) {
							pond[nx][ny].beforeAdded.put(new state(x, y), pond[x][y].numTimes);
						}
						else {
							pond[nx][ny].beforeAdded.putAll(pond[x][y].beforeAdded);
						}
						left.add(new state(nx, ny));
					}
					else if (ncost == oldcost) {
						long numTimesOld = pond[nx][ny].numTimes;
						if (pondmap[x][y] == 0) {
							if (pond[nx][ny].beforeAdded.containsKey(new state(x, y))) {
								pond[nx][ny].numTimes += pond[x][y].numTimes
										- pond[nx][ny].beforeAdded.get(new state(x, y));
								pond[nx][ny].beforeAdded.put(new state(x, y), pond[x][y].numTimes);
							}
							else {
								pond[nx][ny].beforeAdded.put(new state(x, y), pond[x][y].numTimes);
								pond[nx][ny].numTimes += pond[x][y].numTimes;
							}
						}
						else {
							for (state key : pond[x][y].beforeAdded.keySet()) {
								if (pond[nx][ny].beforeAdded.containsKey(new state(key.x, key.y))) {
									pond[nx][ny].numTimes += pond[key.x][key.y].numTimes
											- pond[nx][ny].beforeAdded.get(new state(key.x, key.y));
									pond[nx][ny].beforeAdded.put(new state(key.x, key.y), pond[key.x][key.y].numTimes);
								}
								else {
									pond[nx][ny].beforeAdded.put(new state(key.x, key.y), pond[key.x][key.y].numTimes);
									pond[nx][ny].numTimes += pond[key.x][key.y].numTimes;
								}
							}
						}
						if (numTimesOld < pond[nx][ny].numTimes) {
							left.add(new state(nx, ny));
						}
					}
				}
			}
		}

		if (pond[endx][endy].cost != Long.MAX_VALUE) {
			System.out.println(pond[endx][endy].cost);
			System.out.println(pond[endx][endy].numTimes);
		}
		else {
			System.out.println(-1);
		}
		scan.close();
	}
}
