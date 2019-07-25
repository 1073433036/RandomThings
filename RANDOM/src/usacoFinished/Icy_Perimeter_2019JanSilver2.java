
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Icy_Perimeter_2019JanSilver2 {
	private static class Pair {
		int area;
		int perimeter;

		public Pair(int a, int p) {
			area = a;
			perimeter = p;
		}
	}

	private static boolean[][] machine;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int size = Integer.parseInt(st.nextToken());
		machine = new boolean[size][size];
		visited = new boolean[size][size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(f.readLine());
			String[] chars = st.nextToken().split("");
			for (int j = 0; j < size; j++) {
				machine[i][j] = chars[j].equals("#");
				visited[i][j] = !machine[i][j];
				count += machine[i][j] ? 1 : 0;
			}
		}

		if (count == size * size) {
			out.println(count + " " + size * 4);
			out.close();
			f.close();
			return;
		}
		int area = 0;
		int perimeter = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j]) {
					Pair ic = floodfill(i, j);
					if (ic.area == area) {
						perimeter = Math.min(perimeter, ic.perimeter);
					}
					if (ic.area > area) {
						area = ic.area;
						perimeter = ic.perimeter;
					}
				}
			}
		}

		out.println(area + " " + perimeter);
		out.close();
		f.close();
	}

	public static Pair floodfill(int x, int y) {
		int area = 1;
		int perimeter = 0;

		int[] ax = { 0, 0, 1, -1 };
		int[] ay = { 1, -1, 0, 0 };
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			if (x + ax[i] >= 0 && x + ax[i] < machine.length && y + ay[i] >= 0 && y + ay[i] < machine.length) {
				if (!visited[x + ax[i]][y + ay[i]]) {
					Pair ic = floodfill(x + ax[i], y + ay[i]);
					area += ic.area;
					perimeter += ic.perimeter;
				}
				else if (!machine[x + ax[i]][y + ay[i]]) {
					perimeter++;
				}
			}
			else {
				perimeter++;
			}
		}

		return new Pair(area, perimeter);
	}
}
