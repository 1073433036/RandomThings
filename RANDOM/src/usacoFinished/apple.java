package usacoFinished;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class apple {
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
		int numPaths = scan.nextInt();
		int numPastures = scan.nextInt();
		// heap dijkstra
		// min= src->p1+p1->p2 src->p2+p2->p1
		// dijkstra from src, p1, p2

		int startloc = scan.nextInt() - 1;
		int cow1loc = scan.nextInt() - 1;
		int cow2loc = scan.nextInt() - 1;

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
		int[] distancesCow1 = new int[numPastures];
		int[] distancesCow2 = new int[numPastures];
		for (int i = 0; i < numPastures; i++) {
			distancesSRC[i] = Integer.MAX_VALUE;
			distancesCow1[i] = Integer.MAX_VALUE;
			distancesCow2[i] = Integer.MAX_VALUE;
		}
		distancesSRC[startloc] = 0;
		distancesCow1[cow1loc] = 0;
		distancesCow2[cow2loc] = 0;

		PriorityQueue<Edge> left = new PriorityQueue<>();
		boolean[] visited = new boolean[numPastures];
		left.add(new Edge(startloc, 0));
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
		left.clear();
		visited = new boolean[numPastures];
		left.add(new Edge(cow1loc, 0));
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
				if (distancesCow1[dest] > cost + weight) {
					distancesCow1[dest] = cost + weight;
					left.add(new Edge(dest, distancesCow1[dest]));
				}
			}
		}
		left.clear();
		visited = new boolean[numPastures];
		left.add(new Edge(cow2loc, 0));
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
				if (distancesCow2[dest] > cost + weight) {
					distancesCow2[dest] = cost + weight;
					left.add(new Edge(dest, distancesCow2[dest]));
				}
			}
		}

		System.out.println(Math.min(distancesSRC[cow1loc] + distancesCow1[cow2loc],
				distancesSRC[cow2loc] + distancesCow2[cow1loc]));

		scan.close();
	}
}
