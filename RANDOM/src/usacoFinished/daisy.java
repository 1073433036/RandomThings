package usacoFinished;

import java.util.ArrayList;
import java.util.Scanner;

public class daisy {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numVert = scan.nextInt();
		int numEdge = scan.nextInt();
		ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>(numVert);

		for (int i = 0; i < numVert; i++) {
			edgeList.add(new ArrayList<Integer>(numEdge));
		}
		for (int i = 0; i < numEdge; i++) {
			int start = scan.nextInt() - 1;
			int end = scan.nextInt() - 1;
			edgeList.get(start).add(end);
			edgeList.get(end).add(start);
		}

		visited = new boolean[numVert];
		dfs(edgeList, 0);
		boolean allconnected = true;
		for (int i = 0; i < numVert; i++) {
			if (!visited[i]) {
				System.out.println(i + 1);
				allconnected = false;
			}
		}
		if (allconnected) {
			System.out.println(0);
		}
		scan.close();
	}

	public static boolean[] visited;

	public static void dfs(ArrayList<ArrayList<Integer>> edgeList, int pos) {
		visited[pos] = true;
		for (int i = 0; i < edgeList.get(pos).size(); i++) {
			if (!visited[edgeList.get(pos).get(i)]) {
				dfs(edgeList, edgeList.get(pos).get(i));
			}
		}
	}
}
