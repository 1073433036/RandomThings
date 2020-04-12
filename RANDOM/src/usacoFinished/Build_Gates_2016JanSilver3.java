
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.LinkedList;

public class Build_Gates_2016JanSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gates.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numWalls = Integer.parseInt(st.nextToken());
		int farmsize = 2005;
		boolean[][][] walls = new boolean[farmsize][farmsize][4]; // 0=top,1=right,2=down,3=left

		String directions = f.readLine();
		int cx = farmsize / 2;
		int cy = farmsize / 2;
		for (int i = 0; i < numWalls; i++) {
			switch (directions.charAt(i)) {
				case 'N':
					walls[cx - 1][cy][1] = true;
					walls[cx][cy++][3] = true;
					break;
				case 'E':
					walls[cx][cy - 1][0] = true;
					walls[cx++][cy][2] = true;
					break;
				case 'S':
					walls[cx][--cy][3] = true;
					walls[cx - 1][cy][1] = true;
					break;
				case 'W':
					walls[--cx][cy][2] = true;
					walls[cx][cy - 1][0] = true;
					break;
			}
		}

		LinkedList<Integer> pos = new LinkedList<>();
		boolean[][] visited = new boolean[farmsize][farmsize];
		int count = 0;
		for (int i = 0; i < farmsize; i++) {
			for (int j = 0; j < farmsize; j++) {
				if (!visited[i][j]) {
					count++;
					pos.add(i * 10000 + j);
					while (!pos.isEmpty()) {
						int x = pos.peek() / 10000;
						int y = pos.poll() % 10000;

						if (visited[x][y]) {
							continue;
						}
						visited[x][y] = true;

						if (!walls[x][y][0] && y + 1 < farmsize) {
							pos.add(x * 10000 + y + 1);
						}
						if (!walls[x][y][1] && x + 1 < farmsize) {
							pos.add((x + 1) * 10000 + y);
						}
						if (!walls[x][y][2] && y - 1 >= 0) {
							pos.add(x * 10000 + y - 1);
						}
						if (!walls[x][y][3] && x - 1 >= 0) {
							pos.add((x - 1) * 10000 + y);
						}
					}
				}
			}
		}

		out.println(count - 1);
		out.close();
		f.close();
	}
}
