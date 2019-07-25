
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.LinkedList;

public class Tractor_2013FebSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("tractor.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tractor.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		heights = new int[size][size];
		int maxHeight = 0;
		int minHeight = 100000000;
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < size; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, heights[i][j]);
				minHeight = Math.min(minHeight, heights[i][j]);
			}
		}

		half = (int) Math.ceil(size * size / 2.0);
		int left = 0;
		int right = maxHeight - minHeight;
		while (left < right) {
			int mid = (left + right) / 2;
			visited = new boolean[size][size];
			count = 0;

			boolean possible = false;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (!visited[i][j]) {
						count = 0;
						height = mid;
						possible = overHalf(i, j);
						if (possible) {
							i = size;
							j = size;
						}
					}
				}
			}
			if (possible) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}

		out.println(right);
		out.close();
		f.close();
	}

	static boolean[][] visited;
	static int[][] heights;
	static int height = 0;
	static int[] ix = { 0, 0, 1, -1 };
	static int[] iy = { 1, -1, 0, 0 };
	static int half;
	static int count = 0;

	public static boolean overHalf(int r, int c) {
		LinkedList<Integer> posq = new LinkedList<>();
		posq.add(r * 1000 + c);
		count = 0;
		while (!posq.isEmpty()) {
			int curr = (int) (posq.peek() / 1000);
			int curc = (int) (posq.poll() % 1000);
			if (visited[curr][curc]) {
				continue;
			}
			count++;
			if (count >= half) {
				return true;
			}
			visited[curr][curc] = true;
			for (int i = 0; i < 4; i++) {
				int nr = curr + ix[i];
				int nc = curc + iy[i];
				if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights.length) {
					if (!visited[nr][nc] && Math.abs(heights[nr][nc] - heights[curr][curc]) <= height) {
						posq.add(nr * 1000 + nc);
					}
				}
			}
		}

		return false;
	}
}