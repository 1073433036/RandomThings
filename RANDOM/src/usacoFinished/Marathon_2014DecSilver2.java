
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Marathon_2014DecSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCkpts = Integer.parseInt(st.nextToken());
		int numSkips = Integer.parseInt(st.nextToken());
		int[][] points = new int[numCkpts + 1][2];
		for (int i = 1; i <= numCkpts; i++) {
			st = new StringTokenizer(f.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] distances = new int[numCkpts + 1][numSkips + 1];
		for (int i = 0; i < numSkips; i++) {
			distances[numCkpts][i] = 0;
		}
		for (int i = 0; i < numCkpts; i++) {
			for (int j = 0; j <= numSkips; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = numCkpts - 1; i >= 1; i--) {
			for (int j = numSkips; j >= 0; j--) {
				for (int k = 0; k <= j && i + 1 + k <= numCkpts; k++) {
					distances[i][j] = Math.min(distances[i][j],
							distances[i + 1 + k][j - k] + dist(points[i], points[i + 1 + k]));
				}
			}
		}

		out.println(distances[1][numSkips]);

		out.close();
		f.close();
	}

	public static int dist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
}
