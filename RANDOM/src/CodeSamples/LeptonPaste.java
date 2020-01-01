package CodeSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LeptonPaste {
	// vim: syntax=java
	/*
	 * Find the minimum spanning tree of a graph by taking the least weight
	 * edges without creating a cycle
	 * 
	 * O(ElogV)
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
	}

	private class subset {
		int parent;
		int rank;

		public subset(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}
	}

	private static int find(subset[] subsets, int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}

		return subsets[i].parent;
	}

	private static void union(subset[] subsets, int x, int y) {
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

	public static int kruskalmst(int vertices, edge[] edges) {
		edge[] result = new edge[vertices];
		int e = 0;
		for (int i = 0; i < vertices; i++) {
			result[i] = new edge();
		}

		Arrays.sort(edges);

		subset[] subsets = new subset[vertices];
		for (int i = 0; i < vertices; i++) {
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		int i = 0;
		while (e < vertices - 1) {
			edge next = new edge();
			next = edges[i++];

			int x = find(subsets, next.src);
			int y = find(subsets, next.dest);

			if (x != y) {
				result[e++] = next;
				union(subsets, x, y);
			}
		}
	}
}