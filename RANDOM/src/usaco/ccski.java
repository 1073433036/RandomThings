package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class ccski {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ccski.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int cols = Integer.parseInt(st.nextToken());
		int[][] heights = new int[rows][cols];
		boolean[][] waypts = new boolean[rows][cols];
		int numWaypts = 0;

		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < cols; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < cols; j++) {
				waypts[i][j] = Integer.parseInt(st.nextToken()) == 1;
				numWaypts += waypts[i][j] ? 1 : 0;
			}
		}
		
		

		out.println();
		out.close();
		f.close();
	}
}
