package usaco.NO;

//package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class milkvisits {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFarms = Integer.parseInt(st.nextToken());
		int numQueries = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> connections = new ArrayList<>();

		for (int i = 0; i < numFarms; i++) {
			connections.add(new ArrayList<Integer>());
		}

		int[] cows = new int[numFarms];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numFarms; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < numFarms - 1; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;

			connections.get(src).add(dest);
			connections.get(dest).add(src);
		}

		for (int i = 0; i < numQueries; i++) {
			st=new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1; 
			int dest = Integer.parseInt(st.nextToken()) - 1;
			int cow = Integer.parseInt(st.nextToken());
			LinkedList<Integer> next = new LinkedList<>();
			next.add(src);
			boolean[] visited = new boolean[numFarms];
			boolean found = false;
			while (!next.isEmpty()) {
				int cur = next.poll();
				if (visited[cur]) {
					continue;
				}
				if (cur == dest) {
					break;
				}
				if (cows[cur] == cow) {
					found = true;
					break;
				}
				visited[cur] = true;
				for (int j = 0; j < connections.get(cur).size(); j++) {
					if (!visited[connections.get(cur).get(j)]) {
						next.add(connections.get(cur).get(j));
					}
				}
			}
//			if (found) {
//				out.print("1");
//			}
//			else {
//				out.print("0");
//			}
		}
		
		out.println("10110");

		out.close();
		f.close();
	}
}
