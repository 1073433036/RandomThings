package usaco.NO;

// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Fine_Dining_2018DecGold {
	private static class Edge implements Comparable<Edge> {
		int dest;
		int weight;
		int neg;

		public Edge(int d, int w, int n) {
			dest = d;
			weight = w;
			neg = n;
		}

		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dining.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numFields = Integer.parseInt(st.nextToken());
		int numPaths = Integer.parseInt(st.nextToken());
		int numHaybales = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Edge>> paths = new ArrayList<>(numFields);
		for (int i = 0; i < numFields; i++) {
			paths.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < numPaths; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			paths.get(src).add(new Edge(dest, weight, -1));
			paths.get(dest).add(new Edge(src, weight, -1));
		}

		int[] haybales = new int[numFields];
		for (int i = 0; i < numFields; i++) {
			haybales[i] = -1;
		}
		for (int i = 0; i < numHaybales; i++) {
			st = new StringTokenizer(f.readLine());
			int ind = Integer.parseInt(st.nextToken()) - 1;
			haybales[ind] = Math.max(haybales[ind], Integer.parseInt(st.nextToken()));
		}

		int[] distances = new int[numFields];
		for (int i = 0; i < numFields; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[numFields - 1] = 0;

		boolean[] usedHaybale = new boolean[numFields];
		PriorityQueue<Edge> left = new PriorityQueue<>();
		boolean[][] visited = new boolean[numFields][2];
		left.add(new Edge(numFields - 1, 0, -1));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			int cost = left.peek().weight;
			int neg = left.poll().neg;
			if (visited[pos][neg >= 0 ? 1 : 0]) {
				continue;
			}
			visited[pos][neg >= 0 ? 1 : 0] = true;
			int tempneg = neg;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				int weight = paths.get(pos).get(i).weight;
				if (distances[dest] > cost + weight) {
					distances[dest] = cost + weight;
					left.add(new Edge(dest, distances[dest], neg));
					if (haybales[dest] >= 0 && neg < 0) {
						distances[dest] -= haybales[dest];
						neg = dest;
						left.add(new Edge(dest, distances[dest], dest));
					}
					usedHaybale[dest] = neg > 0;
					neg = tempneg;
				}
			}
		}
		int[] nostopDist = new int[numFields];
		for (int i = 0; i < numFields; i++) {
			nostopDist[i] = Integer.MAX_VALUE;
		}
		nostopDist[numFields - 1] = 0;

		left.clear();
		boolean[] nostopvisited = new boolean[numFields];
		left.add(new Edge(numFields - 1, 0, -1));
		while (!left.isEmpty()) {
			int pos = left.peek().dest;
			int cost = left.poll().weight;
			if (nostopvisited[pos]) {
				continue;
			}
			nostopvisited[pos] = true;
			for (int i = 0; i < paths.get(pos).size(); i++) {
				int dest = paths.get(pos).get(i).dest;
				int weight = paths.get(pos).get(i).weight;
				if (nostopDist[dest] > cost + weight) {
					nostopDist[dest] = cost + weight;
					left.add(new Edge(dest, nostopDist[dest], -1));
				}
			}
		}

		for (int i = 0; i < numFields; i++) {
			System.out.println(distances[i] + " " + nostopDist[i] + usedHaybale[i]);
		}

		for (int i = 0; i < numFields - 1; i++) {
			if (distances[i] <= nostopDist[i] && usedHaybale[i]) {
				out.println(1);
			}
			else {
				out.println(0);
			}
		}

		out.close();
		f.close();
	}
}
