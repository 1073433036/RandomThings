package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class clustering {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("clustering2.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numNodes = Integer.parseInt(st.nextToken());

		// int count = 0;
		// edges = new edge[500*499];
		// while (f.ready()) {
		// st = new StringTokenizer(f.readLine());
		// int src = Integer.parseInt(st.nextToken()) - 1;
		// int dest = Integer.parseInt(st.nextToken()) - 1;
		// int weight = Integer.parseInt(st.nextToken());
		// edges[count++] = new edge(src, dest, weight);
		// edges[count++] = new edge(dest, src, weight);
		// }
		// System.out.println(count);

		edges = new edge[717582];
		edgelist = new LinkedList<>();
		BigInteger[] nodes = new BigInteger[numNodes];
		for (int i = 0; i < numNodes; i++) {
			String n = f.readLine().replaceAll(" ", "");
			nodes[i] = new BigInteger(n, 2);
		}

		int a = 0;
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (i != j) {
					int w = nodes[i].xor(nodes[j]).bitCount();
					// edgelist.add(new edge(i, j, w));
					if (w < 3) {
						edges[a++] = new edge(i, j, w);
					}
				}
			}
		}
		System.out.println(a);

		 kruskalmst();

		f.close();
	}

	// vim: syntax=java
	/*
	 * Find the minimum spanning tree of a graph by adding the minimum edge
	 * weight if it doesn't form a cycle
	 * 
	 * O(ElogE)
	 */
	private static class edge implements Comparable<edge> {
		int src;
		int dest;
		int weight;

		public edge() {

		}

		public edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(edge other) {
			return this.weight - other.weight;
		}

		public String toString() {
			return "(" + src + "," + dest + ") " + weight;
		}
	}

	private static class subset {
		int parent;
		int rank;

		public subset(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}
	}

	public static int find(subset[] subsets, int element) {
		if (subsets[element].parent != element) {
			subsets[element].parent = find(subsets, subsets[element].parent);
		}
		return subsets[element].parent;
	}

	public static void union(subset[] subsets, int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		}
		else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		}
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	private static int numNodes;
	private static edge[] edges;

	private static LinkedList<edge> edgelist;

	public static void kruskalmst() {
		edge[] result = new edge[numNodes];
		int resind = 0;
		int i = 0;
		for (i = 0; i < numNodes; i++) {
			result[i] = new edge();
		}

		Arrays.sort(edges);

		subset[] subsets = new subset[numNodes];
		for (i = 0; i < numNodes; i++) {
			subsets[i] = new subset(i, 0);
		}

		i = 0;
		while (resind < numNodes - 1) {
			edge next = edges[i++];

			int x = find(subsets, next.src);
			int y = find(subsets, next.dest);

			// forms a cycle when both are parts of the same subset
			if (x != y) {
				result[resind++] = next;
				union(subsets, x, y);
			}
		}
		System.out.println(Arrays.toString(result));

	}
}

// 106
