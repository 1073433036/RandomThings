package scam;

import java.util.Scanner;

public class castle {
	static int[] roomsize;
	static int[][] visited;
	static int[][] walls;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int col = scan.nextInt();
		int row = scan.nextInt();
		walls = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				walls[r][c] = scan.nextInt();
			}
		}

		visited = new int[row][col];
		int roomno = 1;
		roomsize = new int[row * col + 1];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (visited[r][c] == 0) {
					floodfill(r, c, roomno++);
				}
			}
		}
		System.out.println(roomno - 1);
		int max = 0;
		for (int i = 0; i < roomno; i++) {
			max = Math.max(max, roomsize[i]);
		}
		System.out.println(max);

		// 2 adjacent cells diff room->max total size
		max = 0;
		int[] nr = { 0, 0, -1, 1 };
		int[] nc = { 1, -1, 0, 0 };
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				for (int i = 0; i < 4; i++) {
					if (r + nr[i] >= 0 && r + nr[i] < row && c + nc[i] >= 0 && c + nc[i] < col) {
						if (visited[r][c] != visited[r + nr[i]][c + nc[i]]) {
							max = Math.max(max, roomsize[visited[r][c]] + roomsize[visited[r + nr[i]][c + nc[i]]]);
						}
					}
				}
			}
		}

		System.out.println(max);

		scan.close();
	}

	public static void floodfill(int r, int c, int roomno) {
		visited[r][c] = roomno;
		roomsize[roomno]++;
		if (c - 1 >= 0 && walls[r][c] % 2 == 0 && visited[r][c - 1] == 0) {
			floodfill(r, c - 1, roomno);
		}
		if (r - 1 >= 0 && (walls[r][c] / 2) % 2 == 0 && visited[r - 1][c] == 0) {
			floodfill(r - 1, c, roomno);
		}
		if (c + 1 < walls[0].length && (walls[r][c] / 4) % 2 == 0 && visited[r][c + 1] == 0) {
			floodfill(r, c + 1, roomno);
		}
		if (r + 1 < walls.length && walls[r][c] / 8 % 2 == 0 && visited[r + 1][c] == 0) {
			floodfill(r + 1, c, roomno);
		}
	}
}
