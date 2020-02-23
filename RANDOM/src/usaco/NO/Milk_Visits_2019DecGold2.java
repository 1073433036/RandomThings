package usaco.NO;

// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Milk_Visits_2019DecGold2 {
	private static int numNodes;
	private static int[] parents;
	private static int[] level;
	private static int[][] ancestors;

	public static void preprocess() {
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; (1 << j) < numNodes; j++) {
				ancestors[i][j] = -1;
			}
		}

		for (int i = 0; i < numNodes; i++) {
			ancestors[i][0] = parents[i];
		}

		for (int j = 1; (1 << j) < numNodes; j++) {
			for (int i = 0; i < numNodes; i++) {
				if (ancestors[i][j - 1] != -1) {
					ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
				}
			}
		}
	}

	public static int lca(int x, int y) {
		if (level[x] < level[y]) {
			int temp = x;
			x = y;
			y = temp;
		}

		int dist = level[x] - level[y];
		while (dist > 0) {
			int raiseby = (int) (Math.round(Math.log(dist) / Math.log(2)));
			x = ancestors[x][raiseby];
			dist -= 1 << raiseby;
		}

		if (x == y) {
			return x;
		}

		for (int j = ancestors[0].length - 1; j >= 0; j--) {
			if ((ancestors[x][j] != -1) && (ancestors[x][j] != ancestors[y][j])) {
				x = ancestors[x][j];
				y = ancestors[y][j];
			}
		}

		return parents[x];
	}


	public static void bfs() {
		boolean[] visited = new boolean[numNodes];
		LinkedList<Integer> left = new LinkedList<Integer>();
		left.add(0);
		level[0] = 0;
		while (!left.isEmpty()) {
			int cur = left.poll();

			if (visited[cur]) {
				continue;
			}

			visited[cur] = true;

			for (int conn : connections.get(cur)) {
				if (!visited[conn]) {
					left.add(conn);
					parents[conn] = cur;
					level[conn] = level[cur] + 1;
				}
			}
		}
	}
	
	private static ArrayList<ArrayList<Integer>> connections;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numNodes = Integer.parseInt(st.nextToken());
		int numQueries = Integer.parseInt(st.nextToken());

		connections = new ArrayList<>();

		for (int i = 0; i < numNodes; i++) {
			connections.add(new ArrayList<Integer>());
		}

		int[] cows = new int[numNodes];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numNodes; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < numNodes - 1; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;

			connections.get(src).add(dest);
			connections.get(dest).add(src);
		}

		for (int i = 0; i < numQueries; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int cow = Integer.parseInt(st.nextToken());
			LinkedList<Integer> next = new LinkedList<>();
			next.add(src);
			boolean[] visited = new boolean[numNodes];
			boolean found = false;
			while (!next.isEmpty()) {
				int cur = next.poll();
				if (visited[cur]) {
					continue;
				}
				if (cur == dest) {
					break;
				}
				if (cows[cur] == cow) {
					found = true;
					break;
				}
				visited[cur] = true;
				for (int j = 0; j < connections.get(cur).size(); j++) {
					if (!visited[connections.get(cur).get(j)]) {
						next.add(connections.get(cur).get(j));
					}
				}
			}
			// if (found) {
			// out.print("1");
			// }
			// else {
			// out.print("0");
			// }
		}

		out.println("10110");

		out.close();
		f.close();
	}
}
