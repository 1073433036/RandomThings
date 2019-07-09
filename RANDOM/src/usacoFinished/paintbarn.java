
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class paintbarn {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int[][] barn = new int[1002][1002];
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			barn[x1][y1]++;
			barn[x2][y1]--;
			barn[x1][y2]--;
			barn[x2][y2]++;
		}

		for (int i = 0; i < barn.length; i++) {
			for (int j = 1; j < barn[0].length; j++) {
				barn[i][j] += barn[i][j - 1];
			}
		}
		for (int i = 1; i < barn.length; i++) {
			for (int j = 0; j < barn[0].length; j++) {
				barn[i][j] += barn[i - 1][j];
			}
		}
		int area = 0;
		for (int i = 0; i < barn.length; i++) {
			for (int j = 0; j < barn[0].length; j++) {
				area += barn[i][j] == k ? 1 : 0;
			}
		}

		out.println(area);
		out.close();
		f.close();
	}
}
