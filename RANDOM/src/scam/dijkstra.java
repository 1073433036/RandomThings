package scam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra {
	// vim: syntax=java
	/*
	 * Find the shortest path from a node to all other nodes by finding the node
	 * with the minimum distance and updating nodes connected the minimum node
	 * Doesn't work for graphs with negative weights
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

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("weights.txt"));
		StringTokenizer st;
		connections = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			st = new StringTokenizer(f.readLine());
			st.nextToken();
			connections.add(new ArrayList<edge>());
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				String[] sp = s.split(",");
				int dest = Integer.parseInt(sp[0]) - 1;
				int weight = Integer.parseInt(sp[1]);
				connections.get(i).add(new edge(dest, weight));
			}
		}
		numNodes = 200;

		int[] res = densedijkstra(0);
		int[] want = new int[] { 7, 37, 59, 82, 99, 115, 133, 165, 188, 197 };

		for (int i = 0; i < want.length; i++) {
			System.out.print(res[want[i] - 1] + ",");
		}
		f.close();
	}
}
