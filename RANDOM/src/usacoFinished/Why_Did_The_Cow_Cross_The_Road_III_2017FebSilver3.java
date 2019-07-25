// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.LinkedList;

public class Why_Did_The_Cow_Cross_The_Road_III_2017FebSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());
		int numRoads = Integer.parseInt(st.nextToken());
		boolean[][][] cantMove = new boolean[size][size][4];		// up right
																	// down left
		for (int i = 0; i < numRoads; i++) {
			st = new StringTokenizer(f.readLine());
			int p1r = Integer.parseInt(st.nextToken()) - 1;
			int p1c = Integer.parseInt(st.nextToken()) - 1;
			int p2r = Integer.parseInt(st.nextToken()) - 1;
			int p2c = Integer.parseInt(st.nextToken()) - 1;

			if (p2c == p1c + 1) {		// right
				cantMove[p1r][p1c][1] = true;
				cantMove[p2r][p2c][3] = true;
			}
			if (p2c == p1c - 1) {		// left
				cantMove[p1r][p1c][3] = true;
				cantMove[p2r][p2c][1] = true;
			}
			if (p2r == p1r - 1) {		// up
				cantMove[p1r][p1c][0] = true;
				cantMove[p2r][p2c][2] = true;
			}
			if (p2r == p1r + 1) {		// down
				cantMove[p1r][p1c][2] = true;
				cantMove[p2r][p2c][0] = true;
			}
		}

		point[] locations = new point[numCows];
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			locations[i] = new point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}

		int count = 0;
		int[] ir = { -1, 0, 1, 0 };
		int[] ic = { 0, 1, 0, -1 };
		for (int cowi = 0; cowi < numCows; cowi++) {
			boolean[][] visited = new boolean[size][size];
			LinkedList<point> pointsleft = new LinkedList<>();
			pointsleft.add(new point(locations[cowi].r, locations[cowi].c));

			int cowsSeen = 0;
			while (!pointsleft.isEmpty()) {
				int curr = pointsleft.peek().r;
				int curc = pointsleft.poll().c;
				if (visited[curr][curc]) {
					continue;
				}
				if (cowsSeen == numCows) {
					break;
				}
				for (int pointi = 0; pointi < numCows; pointi++) {
					if (locations[pointi].r == curr && locations[pointi].c == curc) {
						cowsSeen++;
						break;
					}
				}
				visited[curr][curc] = true;
				for (int i = 0; i < 4; i++) {
					int nr = curr + ir[i];
					int nc = curc + ic[i];
					if (nr >= 0 && nr < size && nc >= 0 && nc < size && !visited[nr][nc] && !cantMove[curr][curc][i]) {
						pointsleft.add(new point(nr, nc));
					}
				}
			}

			count += numCows - cowsSeen;

		}

		out.println(count / 2);
		out.close();
		f.close();
	}

	private static class point {
		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
