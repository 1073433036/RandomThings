package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class twosat {
	static HashMap<Integer, ArrayList<Integer>> conns = new HashMap<>();
	static HashMap<Integer, ArrayList<Integer>> rconns = new HashMap<>();

	public static void main(String[] args) throws IOException { // 101100
		BufferedReader f = new BufferedReader(new FileReader("2sat6.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int v = Integer.parseInt(st.nextToken());
		int[][] clauses = new int[v][2];
		int count = 0;
		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			int src = 0;
			int dest = 0;
			int nsrc = 0;
			int ndest = 0;
			if (first.matches("\\d+")) {
				src = Integer.parseInt(first) - 1;
				nsrc = src + v;
				clauses[count][0] = src;
			}
			else {
				src = Integer.parseInt(first.substring(1)) - 1 + v;
				nsrc = src - v;
				clauses[count][0] = nsrc;
			}
			if (second.matches("\\d+")) {
				dest = Integer.parseInt(second) - 1;
				ndest = dest + v;
				clauses[count][1] = dest;
			}
			else {
				dest = Integer.parseInt(second.substring(1)) - 1 + v;
				ndest = dest - v;
				clauses[count][1] = ndest;
			}
			if (!conns.containsKey(nsrc)) {
				conns.put(nsrc, new ArrayList<Integer>());
			}
			conns.get(nsrc).add(dest);
			if (!conns.containsKey(ndest)) {
				conns.put(ndest, new ArrayList<Integer>());
			}
			conns.get(ndest).add(src);

			if (!rconns.containsKey(dest)) {
				rconns.put(dest, new ArrayList<Integer>());
			}
			rconns.get(dest).add(nsrc);
			if (!rconns.containsKey(src)) {
				rconns.put(src, new ArrayList<Integer>());
			}
			rconns.get(src).add(ndest);
			count++;
		}
		System.out.println("inputdone");

		visited = new boolean[v * 2];
		finish = new Stack<>();
		for (int i = v * 2 - 1; i >= 0; i--) {
			if (!visited[i]) {
				dfs1(i);
			}
		}
		System.out.println("1stdfsdone");

		visited = new boolean[v * 2];
		leader = new int[v * 2];
		for (int i = v * 2 - 1; i >= 0; i--) {
			int x = finish.pop();
			if (!visited[x]) {
				l = x;
				dfs2(x);
			}
		}
		System.out.println("2nddfsdone");

		for (int i = 0; i < v; i++) {
			if (leader[clauses[i][0]] == leader[clauses[i][0] + v]) {
				System.out.println("no");
				break;
			}
			if (leader[clauses[i][1]] == leader[clauses[i][1] + v]) {
				System.out.println("no");
				break;
			}
		}

		f.close();
	}

	static int l;
	static boolean[] visited;
	static Stack<Integer> finish;
	static int[] leader;

	public static void dfs1(int i) {
		visited[i] = true;
		if (rconns.containsKey(i)) {
			for (Integer src : rconns.get(i)) {
				if (!visited[src]) {
					dfs1(src);
				}
			}
		}

		finish.add(i);
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

}
