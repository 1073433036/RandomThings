package scam;

import java.util.Arrays;
import java.util.Scanner;

public class water {
	private static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
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

	static int numPastures;
	static Edge[] edges;

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

	public static Edge[] krustalMST() {
		Edge[] result = new Edge[numPastures];
		int e = 0;
		int index = 0;
		Arrays.sort(edges);
		Subset[] subsets = new Subset[numPastures];
		for (int i = 0; i < numPastures; i++) {
			subsets[i] = new Subset(i, 0);
		}

		while (e < numPastures) {
			Edge next = edges[index++];
			int x = find(subsets, next.src);
			int y = find(subsets, next.dest);

			if (x != y) {
				result[e++] = next;
				Union(subsets, x, y);
			}
			if (next.src == next.dest) {
				result[e++] = next;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		numPastures = scan.nextInt();
		int[] wellCost = new int[numPastures];
		for (int i = 0; i < numPastures; i++) {
			wellCost[i] = scan.nextInt();
		}
		edges = new Edge[(numPastures * numPastures - numPastures) / 2 + numPastures];
		int count = 0;
		for (int i = 0; i < numPastures; i++) {
			for (int j = 0; j < i; j++) {
				edges[count++] = new Edge(i, j, scan.nextInt());
			}
			for (int j = i; j < numPastures; j++) {
				scan.nextInt();
			}
			edges[count++] = new Edge(i, i, wellCost[i]);
		}

		Edge[] result = krustalMST();

		int total = 0;
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i].src + " " + result[i].dest + " " + result[i].weight);
			total += result[i].weight;
		}
		System.out.println(total);
		scan.close();
	}
}
