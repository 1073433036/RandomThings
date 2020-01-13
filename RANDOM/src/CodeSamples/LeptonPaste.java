package CodeSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeptonPaste {

	// vim: syntax=java
	/*
	 * Find the shortest path from a node to all other nodes by finding the node
	 * with the minimum distance and updating nodes connected the minimum node
	 * Doesn't work for graphs with negative weights, use Bellman-Ford
	 *
	 * O(V^2) for dense graphs
	 * 
	 * O((E+V)logV) for sparse graphs
	 */

	private static int numNodes;
	private static ArrayList<ArrayList<edge>> connections;

	private static class edge {
		int dest;
		int weight;

		public edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static int[] densedijkstra(int src) {
		boolean[] visited = new boolean[numNodes];
		int[] distances = new int[numNodes];
		for (int i = 0; i < numNodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		distances[src] = 0;
		for (int i = 0; i < numNodes; i++) {
			int minind = -1;
			for (int j = 0; j < numNodes; j++) {
				if (!visited[j] && (minind == -1 || distances[j] < distances[minind])) {
					minind = j;
				}
			}

			visited[minind] = true;
			for (edge conn : connections.get(minind)) {
				if (!visited[conn.dest]) {
					distances[conn.dest] = Math.min(distances[conn.dest], conn.weight + distances[minind]);
				}
			}
		}

		return distances;
	}

	private static class pair implements Comparable<pair> {
		int id;
		int dist;

		public pair(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}

		public int compareTo(pair o) {
			return this.dist - o.dist;
		}
	}

	public static int[] sparsedijkstra(int src) {
		int[] distances = new int[numNodes];
		boolean[] visited = new boolean[numNodes];
		for (int i = 0; i < numNodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<pair> nextNodes = new PriorityQueue<>();
		nextNodes.add(new pair(src, 0));
		distances[src] = 0;

		while (!nextNodes.isEmpty()) {
			int cur = nextNodes.peek().id;
			int cost = nextNodes.poll().dist;
			if (visited[cur]) {
				continue;
			}

			visited[cur] = true;
			for (edge conn : connections.get(cur)) {
				int ncost = conn.weight + cost;
				if (distances[conn.dest] > ncost) {
					distances[conn.dest] = ncost;
					nextNodes.add(new pair(conn.dest, distances[conn.dest]));
				}
			}
		}

		return distances;
	}

	public static void main(String[] args) {
		// { {0, 1, 1}, {0, 3, 2}, {2, 1, 4}, {3, 2, 5}, {1, 3, 3} }
		Scanner scan = new Scanner(System.in);
		numNodes = scan.nextInt();
		int numConn = scan.nextInt();

		connections = new ArrayList<>();

		for (int i = 0; i < numNodes; i++) {
			connections.add(new ArrayList<edge>());
		}

		for (int i = 0; i < numConn; i++) {
			int p1 = scan.nextInt();
			int p2 = scan.nextInt();
			int weight = scan.nextInt();
			connections.get(p1).add(new edge(p2, weight));
			connections.get(p2).add(new edge(p1, weight));
		}

		System.out.println(Arrays.toString(densedijkstra(1)));
		scan.close();

	}
}