package usacoFinished;

import java.util.Scanner;

public class heatwv {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numTowns = scan.nextInt();
		int numConnections = scan.nextInt();
		int startTown = scan.nextInt() - 1;
		int endTown = scan.nextInt() - 1;
		int[][] connections = new int[numTowns][numTowns];
		for (int i = 0; i < numTowns; i++) {
			for (int j = 0; j < numTowns; j++) {
				connections[i][j] = 1000000;
			}
		}
		for (int i = 0; i < numConnections; i++) {
			int t1 = scan.nextInt() - 1;
			int t2 = scan.nextInt() - 1;
			int weight = scan.nextInt();
			connections[t1][t2] = Math.min(connections[t1][t2], weight);
			connections[t2][t1] = Math.min(connections[t2][t1], weight);
		}

		int[] distances = new int[numTowns];
		boolean[] visited = new boolean[numTowns];
		for (int i = 0; i < numTowns; i++) {
			distances[i] = 1000000;
		}
		distances[startTown] = 0;
		for (int i = 0; i < numTowns; i++) {
			int cur = -1;
			for (int j = 0; j < numTowns; j++) {
				if (!visited[j] && (cur == -1 || distances[j] < distances[cur])) {
					cur = j;
				}
			}
			if (cur == endTown) {
				break;
			}
			visited[cur] = true;
			for (int j = 0; j < numTowns; j++) {
				if (distances[j] > distances[cur] + connections[cur][j]) {
					distances[j] = distances[cur] + connections[cur][j];
				}
			}
		}
		System.out.println(distances[endTown]);

		scan.close();
	}
}
