package usacoFinished;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class packdel {
	private static class Edge implements Comparable<Edge> {
		int dest;
		int weight;

		public Edge(int d, int w) {
			dest = d;
			weight = w;
		}

		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numBarns = scan.nextInt();
		int numPaths = scan.nextInt();

		ArrayList<ArrayList<Edge>> paths = new ArrayList<>(numBarns);
		for (int i = 0; i < numBarns; i++) {
			paths.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < numPaths; i++) {
			int src = scan.nextInt() - 1;
			int dest = scan.nextInt() - 1;
			int weight = scan.nextInt();
			paths.get(src).add(new Edge(dest, weight));
			paths.get(dest).add(new Edge(src, weight));
		}

		// heap dijkstra
		int[] distances = new int[numBarns];
		for (int i = 0; i < numBarns; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[0] = 0;
		boolean[] visited = new boolean[numBarns];
		PriorityQueue<Edge> left = new PriorityQueue<>();
		left.add(new Edge(0, 0));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			int cost = left.poll().weight;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				int weight = paths.get(pos).get(i).weight;
				if (distances[dest] > cost + weight) {
					distances[dest] = cost + weight;
					left.add(new Edge(dest, distances[dest]));
				}
			}
		}

		System.out.println(distances[numBarns - 1]);
		scan.close();
	}
}
