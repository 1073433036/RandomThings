
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dueling_GPSs_2014USOpenSilver2 {
	private static class Road implements Comparable<Road> {
		int dest;
		long weight;

		public Road(int d, long w) {
			dest = d;
			weight = w;
		}

		public int compareTo(Road other) {
			if (this.weight > other.weight) {
				return 1;
			}
			if (this.weight < other.weight) {
				return -1;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gpsduel.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gpsduel.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		// dijkstra from end reverse connections *2
		// keep child array for both gps
		// new connections weights based on gps fight
		// dijkstra from 0 to n-1
		int numInter = Integer.parseInt(st.nextToken());
		int numRoads = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Road>> roads1 = new ArrayList<>(numInter);
		ArrayList<ArrayList<Road>> roads2 = new ArrayList<>(numInter);
		ArrayList<ArrayList<Road>> connections = new ArrayList<>(numInter);
		for (int i = 0; i < numInter; i++) {
			roads1.add(new ArrayList<Road>());
			roads2.add(new ArrayList<Road>());
			connections.add(new ArrayList<Road>());
		}

		for (int i = 0; i < numRoads; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			roads1.get(dest).add(new Road(src, Integer.parseInt(st.nextToken())));
			roads2.get(dest).add(new Road(src, Integer.parseInt(st.nextToken())));
			connections.get(src).add(new Road(dest, 0));
		}

		long[] distances1 = new long[numInter];
		long[] distances2 = new long[numInter];
		for (int i = 0; i < numInter; i++) {
			distances1[i] = Long.MAX_VALUE;
			distances2[i] = Long.MAX_VALUE;
		}

		distances1[numInter - 1] = 0;
		int[] child1 = new int[numInter];
		boolean[] visited = new boolean[numInter];
		PriorityQueue<Road> left = new PriorityQueue<>();
		left.add(new Road(numInter - 1, 0));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			long cost = left.poll().weight;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < roads1.get(pos).size(); i++) {
				int dest = roads1.get(pos).get(i).dest;
				long weight = roads1.get(pos).get(i).weight;
				if (distances1[dest] > cost + weight) {
					distances1[dest] = cost + weight;
					child1[dest] = pos;
					left.add(new Road(dest, distances1[dest]));
				}
			}
		}

		distances2[numInter - 1] = 0;
		int[] child2 = new int[numInter];
		visited = new boolean[numInter];
		left.clear();
		left.add(new Road(numInter - 1, 0));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			long cost = left.poll().weight;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < roads2.get(pos).size(); i++) {
				int dest = roads2.get(pos).get(i).dest;
				long weight = roads2.get(pos).get(i).weight;
				if (distances2[dest] > cost + weight) {
					distances2[dest] = cost + weight;
					child2[dest] = pos;
					left.add(new Road(dest, distances2[dest]));
				}
			}
		}

		// update bad gps connections
		for (int i = 0; i < numInter; i++) {
			for (int j = 0; j < connections.get(i).size(); j++) {
				int dest = connections.get(i).get(j).dest;
				int weight = 0;
				if (dest != child1[i]) {
					weight++;
				}
				if (dest != child2[i]) {
					weight++;
				}
				connections.get(i).set(j, new Road(dest, weight));
			}
		}

		// run Dijkstra
		long[] distances = new long[numInter];
		for (int i = 0; i < numInter; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[0] = 0;
		visited = new boolean[numInter];
		left.clear();
		left.add(new Road(0, 0));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			long cost = left.poll().weight;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < connections.get(pos).size(); i++) {
				int dest = connections.get(pos).get(i).dest;
				long weight = connections.get(pos).get(i).weight;
				if (distances[dest] > cost + weight) {
					distances[dest] = cost + weight;
					left.add(new Road(dest, distances[dest]));
				}
			}
		}

		out.println(distances[numInter - 1]);
		out.close();
		f.close();
	}
}
