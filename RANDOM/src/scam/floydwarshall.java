package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class floydwarshall {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("allpaths1.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numNodes = Integer.parseInt(st.nextToken());
		connections = new long[numNodes][numNodes];

		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (i != j) {
					connections[i][j] = Long.MAX_VALUE;
				}
			}
		}
		int numEdges = Integer.parseInt(st.nextToken());
		for (int i = 0; i < numEdges; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			connections[src][dest] = weight;
		}

		fw();
		long min = 0;
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				min = Math.min(min, distances[i][j]);
			}
		}
		System.out.println(min);
		// System.out.println(Long.MIN_VALUE);

		f.close();
	}

	// NULL
	// NULL
	// -19

	// vim: syntax=java
	/*
	 * Finds the shortest path from every node to every other node by getting
	 * the path for every middle node from every start node to every end node
	 * 
	 * O(V^3)
	 */

	private static int numNodes;
	private static long[][] connections;
	private static long[][] distances;

	public static void fw() {
		distances = new long[numNodes][numNodes];

		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				distances[i][j] = connections[i][j];
			}
		}

		for (int j = 0; j < numNodes; j++) {
			for (int i = 0; i < numNodes; i++) {
				for (int k = 0; k < numNodes; k++) {
					if (distances[i][j] != Long.MAX_VALUE && distances[j][k] != Long.MAX_VALUE) {
						distances[i][k] = Math.min(distances[i][k], distances[i][j] + distances[j][k]);
					}
				}
			}
		}
	}
}
