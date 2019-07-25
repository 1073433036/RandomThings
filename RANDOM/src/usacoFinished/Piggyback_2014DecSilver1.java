
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Piggyback_2014DecSilver1 {
	private static class Edge {
		int dest;

		public Edge(int d) {
			dest = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("piggyback.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("piggyback.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int bessiecost = Integer.parseInt(st.nextToken());
		int elsiecost = Integer.parseInt(st.nextToken());
		int piggycost = Integer.parseInt(st.nextToken());
		int numFields = Integer.parseInt(st.nextToken());
		int numPaths = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Edge>> paths = new ArrayList<>(numFields);
		for (int i = 0; i < numFields; i++) {
			paths.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < numPaths; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			paths.get(src).add(new Edge(dest));
			paths.get(dest).add(new Edge(src));
		}

		int[] distances1 = new int[numFields];
		int[] distances2 = new int[numFields];
		int[] distancesN = new int[numFields];
		for (int i = 0; i < numFields; i++) {
			distances1[i] = Integer.MAX_VALUE;
			distances2[i] = Integer.MAX_VALUE;
			distancesN[i] = Integer.MAX_VALUE;
		}

		LinkedList<Edge> left = new LinkedList<>();
		distances1[0] = 0;
		left.add(new Edge(0));
		boolean[] visited = new boolean[numFields];
		while (!left.isEmpty()) {
			int pos = left.poll().dest;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				if (distances1[dest] == Integer.MAX_VALUE) {
					distances1[dest] = distances1[pos] + 1;
					left.add(new Edge(dest));
				}
			}
		}

		left.clear();
		distances2[1] = 0;
		left.add(new Edge(1));
		visited = new boolean[numFields];
		while (!left.isEmpty()) {
			int pos = left.poll().dest;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				if (distances2[dest] == Integer.MAX_VALUE) {
					distances2[dest] = distances2[pos] + 1;
					left.add(new Edge(dest));
				}
			}
		}

		left.clear();
		distancesN[numFields - 1] = 0;
		left.add(new Edge(numFields - 1));
		visited = new boolean[numFields];
		while (!left.isEmpty()) {
			int pos = left.poll().dest;
			if (visited[pos]) {
				continue;
			}
			visited[pos] = true;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				if (distancesN[dest] == Integer.MAX_VALUE) {
					distancesN[dest] = distancesN[pos] + 1;
					left.add(new Edge(dest));
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < numFields; i++) {
			min = Math.min(min, distances1[i] * bessiecost + distances2[i] * elsiecost + distancesN[i] * piggycost);
		}

		out.println(min);
		out.close();
		f.close();
	}
}
