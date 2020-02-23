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
import java.util.TreeSet;

public class Cow_Land_2019FebGold1 {
	private static int numNodes;
	private static int[] parents;
	private static int[] level;
	private static int[][] ancestors;
	private static ArrayList<TreeSet<Integer>> connections;
	private static int[] enjoyment;
	private static int[] xors;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowland.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numNodes = Integer.parseInt(st.nextToken());
		int numQueries = Integer.parseInt(st.nextToken());
		enjoyment = new int[numNodes];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numNodes; i++) {
			enjoyment[i] = Integer.parseInt(st.nextToken());
		}

		connections = new ArrayList<>();
		for (int i = 0; i < numNodes; i++) {
			connections.add(new TreeSet<Integer>());
		}

		for (int i = 0; i < numNodes - 1; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			connections.get(src).add(dest);
			connections.get(dest).add(src);
		}
		xors = new int[numNodes];
		parents = new int[numNodes];
		level = new int[numNodes];
		update(true);
		ancestors = new int[numNodes][(int) (Math.ceil(Math.log(numNodes) / Math.log(2)))];
		preprocess();

		// result=xor[a]^xor[b]^enjoyment[lca(a^b)]
		boolean changes = false;
		for (int i = 0; i < numQueries; i++) {
			st = new StringTokenizer(f.readLine());
			if (Integer.parseInt(st.nextToken()) == 2) {
				if (changes) {
					update(false);
					changes = false;
				}
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				out.println(xors[a] ^ xors[b] ^ enjoyment[lca(a, b)]);
			}
			else {
				changes = true;
				enjoyment[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
			}
		}

		out.close();
		f.close();
	}

	private static class state {
		int ind;
		int xor;

		public state(int ind, int xor) {
			this.ind = ind;
			this.xor = xor;
		}
	}

	public static void update(boolean first) {
		boolean[] visited = new boolean[numNodes];
		LinkedList<state> left = new LinkedList<state>();
		left.add(new state(0, enjoyment[0]));
		level[0] = 0;
		while (!left.isEmpty()) {
			int cur = left.peek().ind;
			int cxor = left.poll().xor;

			if (visited[cur]) {
				continue;
			}

			visited[cur] = true;
			xors[cur] = cxor;

			for (int conn : connections.get(cur)) {
				if (!visited[conn]) {
					left.add(new state(conn, cxor ^ enjoyment[conn]));
					parents[conn] = cur;
					level[conn] = level[cur] + 1;
					if (first) {
						connections.get(conn).remove(cur);
					}
				}
			}
		}
	}

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
			int raiseby = (int) (Math.log(dist) / Math.log(2));
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
}
