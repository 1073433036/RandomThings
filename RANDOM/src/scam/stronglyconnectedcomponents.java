package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class stronglyconnectedcomponents {
	static HashMap<Integer, ArrayList<Integer>> conns = new HashMap<>();
	static HashMap<Integer, ArrayList<Integer>> rconns = new HashMap<>();

	static class pair implements Comparable<pair> {
		int f;
		int s;

		public pair(int first, int second) {
			f = first;
			s = second;
		}

		@Override
		public int compareTo(pair o) {
			return s - o.s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sccvert.txt"));
		StringTokenizer st;
		int v = 875714;
		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			if (!conns.containsKey(src)) {
				conns.put(src, new ArrayList<Integer>());
			}
			conns.get(src).add(dest);
			if (!rconns.containsKey(dest)) {
				rconns.put(dest, new ArrayList<Integer>());
			}
			rconns.get(dest).add(src);
		}
		System.out.println("inputdone");

		visited = new boolean[v];
		finish = new pair[v];
		for (int i = v - 1; i >= 0; i--) {
			if (!visited[i]) {
				dfs1(i);
			}
		}
		System.out.println("1stdfsdone");

		Arrays.sort(finish);
		visited = new boolean[v];
		leader = new int[v];
		for (int i = v - 1; i >= 0; i--) {
			if (!visited[finish[i].f]) {
				l = finish[i].f;
				dfs2(finish[i].f);
			}
		}
		System.out.println("2nddfsdone");

		visited = new boolean[v];
		size = new int[v];
		for (int i = v - 1; i >= 0; i--) {
			if (!visited[i]) {
				dfs3(i);
			}
		}
		System.out.println("countdone");

		Arrays.sort(size);
		for (int i = v - 1; i >= v - 5; i--) {
			System.out.println(size[i]);
		}

		f.close();
	}

	static int t = 0;
	static int l;
	static boolean[] visited;
	static pair[] finish;
	static int[] leader;
	static int[] size;

	public static void dfs1(int i) {
		visited[i] = true;
		if (rconns.containsKey(i)) {
			for (Integer src : rconns.get(i)) {
				if (!visited[src]) {
					dfs1(src);
				}
			}
		}

		t++;
		finish[i] = new pair(i, t);
	}

	public static void dfs2(int i) {
		visited[i] = true;
		leader[i] = l;
		if (conns.containsKey(i)) {
			for (Integer dest : conns.get(i)) {
				if (!visited[dest]) {
					dfs2(dest);
				}
			}
		}
	}

	public static void dfs3(int i) {
		visited[i] = true;
		size[leader[i]]++;
		if (conns.containsKey(i)) {
			for (Integer dest : conns.get(i)) {
				if (!visited[dest]) {
					dfs3(dest);
				}
			}
		}
	}
}
