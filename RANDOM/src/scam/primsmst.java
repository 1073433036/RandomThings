package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class primsmst {// vim: syntax=java
	/*
	 * Find the minimum spanning tree of a graph by finding the minimum of the
	 * non visited nodes and updating the weights of other vertices connected to
	 * the current node
	 * 
	 * O((V+E)logV) for sparse graphs
	 *
	 * O(V^2) for dense graphs
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

	public static int denseprim() {
		boolean[] visited = new boolean[numNodes];
		int[] distances = new int[numNodes];
		for (int i = 0; i < numNodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		distances[0] = 0;
		int cost = 0;
		for (int i = 0; i < numNodes; i++) {
			int minind = -1;
			for (int j = 0; j < numNodes; j++) {
				if (!visited[j] && (minind == -1 || distances[j] < distances[minind])) {
					minind = j;
				}
			}

			visited[minind] = true;
			cost += distances[minind];
			for (edge conn : connections.get(minind)) {
				if (!visited[conn.dest]) {
					distances[conn.dest] = Math.min(distances[conn.dest], conn.weight);
				}
			}
		}

		return cost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("edges.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numNodes = Integer.parseInt(st.nextToken());
		int numEdges = Integer.parseInt(st.nextToken());
		connections = new ArrayList<ArrayList<edge>>();
		for (int i = 0; i < numNodes; i++) {
			connections.add(new ArrayList<edge>());
		}
		for (int i = 0; i < numEdges; i++) {
			st = new StringTokenizer(f.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			connections.get(n1).add(new edge(n2, weight));
			connections.get(n2).add(new edge(n1, weight));
		}

		System.out.println(denseprim());
		f.close();
	}
}
