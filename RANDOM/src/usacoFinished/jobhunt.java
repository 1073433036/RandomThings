package usacoFinished;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class jobhunt {
	private static class Node implements Comparable<Node> {
		int weight;
		int dest;

		public Node(int d, int w) {
			weight = w;
			dest = d;
		}

		public int hashCode() {
			return weight + dest;
		}

		public boolean equals(Object other) {
			return ((Node) other).dest == dest;
		}

		public int compareTo(Node other) {
			return this.dest - other.dest;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maxMoney = scan.nextInt();
		int numPaths = scan.nextInt();
		int numCities = scan.nextInt();
		int numPlanes = scan.nextInt();
		int startCity = scan.nextInt() - 1;

		ArrayList<TreeSet<Node>> cityConnections = new ArrayList<>();
		for (int i = 0; i < numCities; i++) {
			cityConnections.add(new TreeSet<Node>());
		}
		for (int i = 0; i < numPaths; i++) {
			cityConnections.get(scan.nextInt() - 1).add(new Node(scan.nextInt() - 1, -maxMoney));
		}
		for (int i = 0; i < numPlanes; i++) {
			int src = scan.nextInt() - 1;
			int dest = scan.nextInt() - 1;
			int cost = -maxMoney + scan.nextInt();
			cityConnections.get(src).add(new Node(dest, cost));
		}

		int[] distances = new int[numCities];
		for (int i = 0; i < numCities; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[startCity] = 0;
		boolean noLimit = false;
		for (int city = 0; city <= numCities; city++) {
			boolean updated = false;
			for (int i = 0; i < numCities; i++) {
				for (Node connection : cityConnections.get(i)) {
					if (distances[connection.dest] > distances[i] + connection.weight
							&& distances[i] != Integer.MAX_VALUE) {
						distances[connection.dest] = distances[i] + connection.weight;
						updated = true;
					}
				}
			}
			if (!updated) {
				break;
			}
			else if (city == numCities) {
				noLimit = true;
			}
		}

		if (noLimit) {
			System.out.println(-1);
			scan.close();
			return;
		}

		int min = 0;
		for (int i = 0; i < numCities; i++) {
			min = Math.min(min, distances[i]);
		}

		System.out.println(maxMoney - min);
		scan.close();
	}
}
