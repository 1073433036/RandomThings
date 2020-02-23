
// package usacoFinished;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Milk_Pumping_2019DecGold1 {
	private static class edge implements Comparable<edge> {
		int dest;
		int cost;
		int flow;

		public edge(int d, int c, int f) {
			dest = d;
			cost = c;
			flow = f;
		}

		public int compareTo(edge o) {
			return this.cost - o.cost;
		}
	}

	private static int numNodes;
	private static ArrayList<ArrayList<edge>> connections;

	public static int sparsedijkstra(int src) {
		int[] distances = new int[numNodes];
		boolean[] visited = new boolean[numNodes];
		for (int i = 0; i < numNodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<edge> nextNodes = new PriorityQueue<>();
		nextNodes.add(new edge(src, 0, Integer.MAX_VALUE));
		distances[src] = 0;

		while (!nextNodes.isEmpty()) {
			int cur = nextNodes.peek().dest;
			int cost = nextNodes.peek().cost;
			int fl = nextNodes.poll().flow;
			if (visited[cur]) {
				continue;
			}
			if (cur == numNodes - 1) {
				return (int) (1000000 * (1.0 * fl / distances[numNodes - 1]));
			}

			visited[cur] = true;
			for (edge conn : connections.get(cur)) {
				int ncost = conn.cost + cost;
				if (distances[conn.dest] > ncost && conn.flow >= minflow) {
					distances[conn.dest] = ncost;
					nextNodes.add(new edge(conn.dest, ncost, Math.min(fl, conn.flow)));
				}
			}
		}

		return -1;
	}

	private static TreeSet<Integer> flows;
	private static int minflow;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pump.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		numNodes = Integer.parseInt(st.nextToken());
		int numConnections = Integer.parseInt(st.nextToken());
		connections = new ArrayList<>();
		for (int i = 0; i < numNodes; i++) {
			connections.add(new ArrayList<edge>());
		}

		flows = new TreeSet<>();
		for (int i = 0; i < numConnections; i++) {
			st = new StringTokenizer(f.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			int flow = Integer.parseInt(st.nextToken());
			connections.get(n1).add(new edge(n2, cost, flow));
			connections.get(n2).add(new edge(n1, cost, flow));
			flows.add(flow);
		}

		int result = 0;
		for (int fl : flows) {
			minflow = fl;
			int res = sparsedijkstra(0);
			if (res == -1) {
				break;
			}
			result = Math.max(result, res);
		}

		out.println(result);
		f.close();
		out.close();
	}

}
