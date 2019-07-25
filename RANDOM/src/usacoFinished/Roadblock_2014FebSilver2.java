//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Roadblock_2014FebSilver2 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("rblock.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rblock.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFields = Integer.parseInt(st.nextToken());
		int numPaths = Integer.parseInt(st.nextToken());
		int[][] paths = new int[numFields][numFields];
		for (int i = 0; i < numFields; i++) {
			for (int j = 0; j < numFields; j++) {
				paths[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < numPaths; i++) {
			st = new StringTokenizer(f.readLine());
			int p1 = Integer.parseInt(st.nextToken()) - 1;
			int p2 = Integer.parseInt(st.nextToken()) - 1;
			int length = Integer.parseInt(st.nextToken());
			paths[p1][p2] = length;
			paths[p2][p1] = length;
		}

		int[] parent = new int[numFields];
		long[] dist = new long[numFields];
		boolean[] visited = new boolean[numFields];
		for (int i = 0; i < numFields; i++) {
			dist[i] = Long.MAX_VALUE;
		}
		dist[0] = 0;
		for (int fields = 0; fields < numFields; fields++) {
			int min = -1;
			for (int i = 0; i < numFields; i++) {
				if (!visited[i] && (min == -1 || dist[i] < dist[min])) {
					min = i;
				}
			}
			if (min == numFields - 1) {
				break;
			}
			visited[min] = true;
			for (int i = 0; i < numFields; i++) {
				if (!visited[i] && paths[min][i] != Integer.MAX_VALUE && dist[i] > paths[min][i] + dist[min]) {
					dist[i] = dist[min] + paths[min][i];
					parent[i] = min;
				}
			}
		}

		long actual = dist[numFields - 1];

		Stack<Integer> path = new Stack<>();
		int cur = numFields - 1;
		while (cur != 0) {
			path.add(cur);
			cur = parent[cur];
			path.add(cur);
		}

		long max = 0;
		while (!path.isEmpty()) {
			int chngsrc = path.pop();
			int chngdest = path.pop();
			paths[chngsrc][chngdest] *= 2;
			parent = new int[numFields];
			dist = new long[numFields];
			visited = new boolean[numFields];
			for (int i = 0; i < numFields; i++) {
				dist[i] = Long.MAX_VALUE;
			}
			dist[0] = 0;
			for (int fields = 0; fields < numFields; fields++) {
				int min = -1;
				for (int i = 0; i < numFields; i++) {
					if (!visited[i] && (min == -1 || dist[i] < dist[min])) {
						min = i;
					}
				}
				if (min == numFields - 1) {
					break;
				}
				visited[min] = true;
				for (int i = 0; i < numFields; i++) {
					if (!visited[i] && paths[min][i] != Integer.MAX_VALUE && dist[i] > paths[min][i] + dist[min]) {
						dist[i] = dist[min] + paths[min][i];
						parent[i] = min;
					}
				}
			}
			max = Math.max(max, dist[numFields - 1]);
			paths[chngsrc][chngdest] /= 2;
		}

		out.println(max - actual);
		out.close();
		f.close();
	}
}
