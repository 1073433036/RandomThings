
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Overplanting_2012FebBronze2 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numRegions = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[20000][20000];
		for (int i = 0; i < numRegions; i++) {
			st = new StringTokenizer(f.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 10000;
			int y1 = Integer.parseInt(st.nextToken()) + 10000;
			int x2 = Integer.parseInt(st.nextToken()) + 10000;
			int y2 = Integer.parseInt(st.nextToken()) + 10000;
			for (int r = y1; r > y2; r--) {
				for (int c = x1; c < x2; c++) {
					map[r][c] = true;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < 20000; i++) {
			for (int j = 0; j < 20000; j++) {
				if (map[i][j]) {
					count++;
				}
			}
		}

		out.println(count);

		out.close();
		f.close();
	}
}
