
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

public class Bovine_Alliance_2012JanGold3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("alliance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("alliance.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		// how many different ways to convert a graph into a dirgraph
		// connected components
		// how many different ways to put directed edges in a component
		// bfs
		// calculate result of each component one by one, keep running product
		// tree-n-1 edges is n
		// 1cycle-n edges is 2
		int numFarms = Integer.parseInt(st.nextToken());
		int numConnections = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
		for (int i = 0; i < numFarms; i++) {
			connections.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < numConnections; i++) {
			st = new StringTokenizer(f.readLine());
			int f1 = Integer.parseInt(st.nextToken()) - 1;
			int f2 = Integer.parseInt(st.nextToken()) - 1;
			connections.get(f1).add(f2);
			connections.get(f2).add(f1);
		}

		long result = 1;
		boolean[] visited = new boolean[numFarms];
		for (int i = 0; i < numFarms; i++) {
			if (!visited[i]) {
				LinkedList<Integer> farmsLeft = new LinkedList<>();
				int farms = 0;
				int edges = 0;
				farmsLeft.add(i);
				while (!farmsLeft.isEmpty()) {
					int cur = farmsLeft.poll();

					if (visited[cur]) {
						continue;
					}

					visited[cur] = true;
					farms++;
					for (int conn : connections.get(cur)) {
						if (!visited[conn]) {
							farmsLeft.add(conn);
						}
						edges++;
					}
				}

				edges /= 2;
				if (edges == farms) {
					result *= 2;
				}
				else if (edges == farms - 1) {
					result *= farms;
				}
				else {
					result = 0;
					break;
				}
				result %= 1000000007;
			}
		}

		out.println(result);
		out.close();
		f.close();
	}
}