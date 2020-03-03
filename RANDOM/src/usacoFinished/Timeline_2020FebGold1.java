//package usacoFinished;

 import java.util.StringTokenizer;
 import java.io.BufferedReader;
 import java.io.PrintWriter;
 import java.io.BufferedWriter;
 import java.io.FileReader;
 import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Timeline_2020FebGold1 {
	private static class edge {
		int dest;
		int weight;

		public edge(int d, int w) {
			dest = d;
			weight = w;
		}

		public boolean equals(Object o) {
			return ((edge) o).dest == dest;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("timeline.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("timeline.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numSessions = Integer.parseInt(st.nextToken());
		int maxDays = Integer.parseInt(st.nextToken());
		int numMemories = Integer.parseInt(st.nextToken());

		int[] result = new int[numSessions];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numSessions; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<ArrayList<edge>> connections = new ArrayList<>();
		for (int i = 0; i < numSessions; i++) {
			connections.add(new ArrayList<edge>());
		}
		for (int i = 0; i < numMemories; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken());
			int alreadyin = connections.get(src).indexOf(new edge(dest, 0));
			if (alreadyin != -1 && connections.get(src).get(alreadyin).weight < time) {
				connections.get(src).set(alreadyin, new edge(dest, time));
			}
			else {
				connections.get(src).add(new edge(dest, time));
			}
		}

		int[] indegrees = new int[numSessions];
		for (ArrayList<edge> dests : connections) {
			for (edge conn : dests) {
				indegrees[conn.dest]++;
			}
		}

		LinkedList<edge> nodesleft = new LinkedList<>();
		for (int i = 0; i < numSessions; i++) {
			if (indegrees[i] == 0) {
				nodesleft.add(new edge(i, result[i]));
			}
		}

		while (!nodesleft.isEmpty()) {
			edge cur = nodesleft.poll();

			// System.out.println(cur.dest + " " + cur.weight);
			cur.weight = Math.max(cur.weight, result[cur.dest]);
			result[cur.dest] = cur.weight;
			for (edge conn : connections.get(cur.dest)) {
				indegrees[conn.dest]--;
				result[conn.dest] = Math.max(result[conn.dest], cur.weight + conn.weight);
				if (indegrees[conn.dest] == 0) {
					nodesleft.add(new edge(conn.dest, cur.weight + conn.weight));
				}
			}
		}

		for (int i = 0; i < numSessions; i++) {
			out.println(result[i]);
		}

		out.close();
		f.close();
	}

}
