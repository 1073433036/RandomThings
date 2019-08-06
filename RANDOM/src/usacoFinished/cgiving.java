package usacoFinished;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class cgiving {
	private static class Edge implements Comparable<Edge> {
		int weight;
		int dest;

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
		int numPastures = scan.nextInt();
		int numPaths = scan.nextInt();
		int numQueries = scan.nextInt();

		ArrayList<ArrayList<Edge>> paths = new ArrayList<>(numPastures);

		for (int i = 0; i < numPastures; i++) {
			paths.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < numPaths; i++) {
			int p1 = scan.nextInt() - 1;
			int p2 = scan.nextInt() - 1;
			int weight = scan.nextInt();
			paths.get(p1).add(new Edge(p2, weight));
			paths.get(p2).add(new Edge(p1, weight));
		}

		int[] distancesSRC = new int[numPastures];
		for (int i = 0; i < numPastures; i++) {
			distancesSRC[i] = Integer.MAX_VALUE;
		}
		distancesSRC[0] = 0;

		PriorityQueue<Edge> left = new PriorityQueue<>();
		boolean[] visited = new boolean[numPastures];
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
				if (distancesSRC[dest] > cost + weight) {
					distancesSRC[dest] = cost + weight;
					left.add(new Edge(dest, distancesSRC[dest]));
				}
			}
		}

		for (int i = 0; i < numQueries; i++) {
			int b = scan.nextInt();
			int c = scan.nextInt();
			System.out.println(distancesSRC[b - 1] + distancesSRC[c - 1]);
		}

		scan.close();
	}
}
