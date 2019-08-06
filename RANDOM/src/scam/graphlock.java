package scam;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class graphlock {
	private static class Edge implements Comparable<Edge> {
		int dest;
		int time;

		public Edge(int d, int t) {
			dest = d;
			time = t;
		}

		public int compareTo(Edge other) {
			return this.time - other.time;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCities = scan.nextInt();
		int numPaths = scan.nextInt();
		int codeLen = scan.nextInt();

		String[] cityCodes = new String[numCities];
		for (int i = 0; i < numCities; i++) {
			cityCodes[i] = scan.next();
		}

		ArrayList<ArrayList<Edge>> paths = new ArrayList<>(numCities);

		for (int i = 0; i < numCities; i++) {
			paths.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < numPaths; i++) {
			int p1 = scan.nextInt() - 1;
			int p2 = scan.nextInt() - 1;
			paths.get(p1).add(new Edge(p2, 0));
			paths.get(p2).add(new Edge(p1, 0));
		}

		int[] timesSRC = new int[numCities];
		for (int i = 0; i < numCities; i++) {
			timesSRC[i] = Integer.MAX_VALUE;
		}
		timesSRC[0] = 0;

		PriorityQueue<Edge> left = new PriorityQueue<>();
		boolean[][] visited = new boolean[numCities][codeLen];
		left.add(new Edge(0, 0));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			int time = left.poll().time;
			if (visited[pos][time % codeLen]) {
				continue;
			}
			if (pos == numCities - 1) {
				System.out.println(time);
				scan.close();
				return;
			}
			visited[pos][time % codeLen] = true;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				for (int j = 0; j < 10; j++) {
					if (cityCodes[pos].charAt((time + j) % codeLen) == cityCodes[dest].charAt((time + j) % codeLen)) {
						timesSRC[dest] = Math.min(timesSRC[dest], time + j);
						left.add(new Edge(dest, time + j));
					}
				}
			}
		}

		System.out.println(-1);

		scan.close();
	}
}
