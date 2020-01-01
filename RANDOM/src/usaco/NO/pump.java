package usaco.NO;

// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

public class pump {
	private static class Edge {
		int dest;
		int cost;
		int flow;

		public Edge(int d, int c, int f) {
			dest = d;
			cost = c;
			flow = f;
		}
	}

	private static ArrayList<ArrayList<Edge>> connections;
	private static int bestflow = 0;
	private static int bestcost = 10000000;
	private static int result = 0;
	private static int numPoints;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pump.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numPoints = Integer.parseInt(st.nextToken());
		int numConnections = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Edge>> tempconnections = new ArrayList<>();
		connections = new ArrayList<>();

		for (int i = 0; i < numPoints; i++) {
			tempconnections.add(new ArrayList<Edge>());
			connections.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < numConnections; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			int flow = Integer.parseInt(st.nextToken());

			tempconnections.get(src).add(new Edge(dest, cost, flow));
			tempconnections.get(dest).add(new Edge(src, cost, flow));
		}

		LinkedList<Integer> next = new LinkedList<>();
		next.add(0);
		boolean[] visited = new boolean[numPoints];
		while (!next.isEmpty()) {
			int cur = next.poll();
			if (visited[cur]) {
				continue;
			}

			visited[cur] = true;
			for (Edge e : tempconnections.get(cur)) {
				next.add(e.dest);
				connections.get(cur).add(e);
			}
		}

		gvisited = new boolean[numPoints];
		gvisited[0] = true;
		dfs(0);

		out.println(result);
		out.close();
		f.close();
	}

	private static int curflow = Integer.MAX_VALUE;
	private static int curcost = 0;
	private static boolean[] gvisited;

	public static void dfs(int cur) {
		if (cur == numPoints - 1) {
			int curtry = (int) (1000000.0 * curflow / curcost);
			if (curtry > result) {
				result = curtry;
				bestflow = curflow;
				bestcost = curcost;
			}
			return;
		}
		if (curflow < bestflow && curcost > bestcost) {
			return;
		}

		for (int i = 0; i < connections.get(cur).size(); i++) {
			if (!gvisited[connections.get(cur).get(i).dest]) {
				int temp = curflow;
				curflow = Math.min(curflow, connections.get(cur).get(i).flow);
				curcost += connections.get(cur).get(i).cost;
				gvisited[connections.get(cur).get(i).dest] = true;
				dfs(connections.get(cur).get(i).dest);
				gvisited[connections.get(cur).get(i).dest] = false;
				curflow = temp;
				curcost -= connections.get(cur).get(i).cost;
			}
		}
	}
}
