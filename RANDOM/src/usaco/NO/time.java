
package usaco.NO;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.PrintWriter;
// import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class time {
	// vim: syntax=java
	/*
	 * Finds the shortest path from any node to all other nodes by finding the
	 * shortest paths from least amount of edges to greatest
	 * 
	 * O(VE)
	 */

	private static int numNodes;
	private static int numEdges;
	private static ArrayList<edge> edges;
	private static int[] distances;
	private static int[] day;
	private static int C;

	private static class edge {
		int src;
		int dest;
		int weight;

		public edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static void bellmanford(int src) {
		for (int i = 0; i < numNodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		distances[src] = 0;

		boolean changed = true;
		while (changed) {
			changed = false;
			for (int j = 0; j < numEdges; j++) {
				int n1 = edges.get(j).src;
				int n2 = edges.get(j).dest;
				int weight = edges.get(j).weight;
				int cost = distances[n1] + weight + day[n1] * 2 * C + C;
				if (distances[n1] != Integer.MAX_VALUE && distances[n2] > cost) {
					distances[n2] = cost;
					day[n2] = day[n1] + 1;
					changed = true;
					System.out.println(n1 + " " + n2 + " " + day[n1] + " " + day[n2] + " " + cost);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("time.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("time.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		numNodes = Integer.parseInt(st.nextToken());
		numEdges = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] moneys = new int[numNodes];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numNodes; i++) {
			moneys[i] = Integer.parseInt(st.nextToken());
		}

		edges = new ArrayList<>(numEdges);
		distances = new int[numNodes];
		day = new int[numNodes];
		for (int i = 0; i < numEdges; i++) {
			st = new StringTokenizer(f.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			edges.add(new edge(n1, n2, -moneys[n2]));
		}

		bellmanford(0);

		System.out.println(Arrays.toString(distances));
		System.out.println(Arrays.toString(day));
		out.println(-distances[0]);
		out.close();
		f.close();
	}
}
