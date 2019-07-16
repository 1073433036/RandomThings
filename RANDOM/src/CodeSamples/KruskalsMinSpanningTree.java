package CodeSamples;

import java.util.Arrays;

class KruskalsMinSpanningTree {
	private static class Graph {
		private static class Edge implements Comparable<Edge> {
			int src;
			int dest;
			int weight;

			public Edge(int s, int d, int w) {
				src = s;
				dest = d;
				weight = w;
			}

			public Edge() {

			}

			public int compareTo(Edge other) {
				return weight - other.weight;
			}
		}

		private static class Subset {
			int parent;
			int rank;

			public Subset(int p, int r) {
				parent = p;
				rank = r;
			}
		}

		public static int find(Subset[] subsets, int target) {
			if (subsets[target].parent != target) {
				subsets[target].parent = find(subsets, subsets[target].parent);
			}

			return subsets[target].parent;
		}

		int vertexNum;
		int edgeNum;
		Edge[] edges;

		public Graph(int v, int e) {
			vertexNum = v;
			edgeNum = e;
			edges = new Edge[edgeNum];
			for (int i = 0; i < edgeNum; i++) {
				edges[i] = new Edge();
			}
		}

		public static void Union(Subset[] subsets, int x, int y) {
			int rootx = find(subsets, x);
			int rooty = find(subsets, y);
			if (subsets[rootx].rank < subsets[rooty].rank) {
				subsets[rootx].parent = rooty;
			}
			else if (subsets[rooty].rank > subsets[rootx].rank) {
				subsets[rooty].parent = rootx;
			}

			else {
				subsets[rooty].parent = rootx;
				subsets[rootx].rank++;
			}
		}

		public void krustalMST() {
			Edge[] result = new Edge[vertexNum];
			int e = 0;
			int index = 0;
			Arrays.sort(edges);
			Subset[] subsets = new Subset[vertexNum];
			for (int i = 0; i < vertexNum; i++) {
				subsets[i] = new Subset(i, 0);
			}

			while (e < vertexNum - 1) {
				Edge next = edges[index++];
				int x = find(subsets, next.src);
				int y = find(subsets, next.dest);

				if (x != y) {
					result[e++] = next;
					Union(subsets, x, y);
				}
			}

			for (int i = 0; i < vertexNum; i++) {
				System.out.print(result[i].src + "--" + result[i].dest + "==" + result[i].weight);
			}
		}
	}
}
