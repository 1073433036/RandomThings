
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class I_Would_Walk_500_Miles_2019USOpenGold2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("walk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("walk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numCows = Integer.parseInt(st.nextToken());
		int numGroups = Integer.parseInt(st.nextToken());

		long[] distances = new long[numCows + 1];
		boolean[] visited = new boolean[numCows + 1];

		for (int i = 1; i <= numCows; i++) {
			distances[i] = 2019201997;
		}
		visited[0] = true;
		for (int i = 0; i < numCows; i++) {
			int minind = 0;
			for (int j = 1; j <= numCows; j++) {
				if (!visited[j] && (minind == 0 || distances[j] < distances[minind])) {
					minind = j;
				}
			}
			visited[minind] = true;
			for (int j = 1; j <= numCows; j++) {
				if (!visited[j]) {
					distances[j] = Math.min(distances[j],
							(2019201913l * Math.min(minind, j) + 2019201949l * Math.max(minind, j)) % 2019201997l);
				}
			}
		}

		Arrays.sort(distances);

		out.println(distances[numCows - numGroups + 1]);

		out.close();
		f.close();
	}
}
