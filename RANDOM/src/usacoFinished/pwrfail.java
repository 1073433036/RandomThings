package usacoFinished;

import java.util.Scanner;

public class pwrfail {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numPoles = scan.nextInt();
		int numWires = scan.nextInt();
		double maxcost = scan.nextDouble();
		int[][] poles = new int[numPoles][2];
		for (int i = 0; i < numPoles; i++) {
			poles[i][0] = scan.nextInt();
			poles[i][1] = scan.nextInt();
		}
		double[][] costs = new double[numPoles][numPoles];
		for (int i = 0; i < numPoles; i++) {
			for (int j = 0; j < numPoles; j++) {
				double dist = Math
						.sqrt(Math.pow(poles[i][0] - poles[j][0], 2) + Math.pow(poles[i][1] - poles[j][1], 2));
				if (dist <= maxcost) {
					costs[i][j] = dist;
				}
				else {
					costs[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < numWires; i++) {
			int src = scan.nextInt() - 1;
			int dest = scan.nextInt() - 1;
			costs[src][dest] = 0;
			costs[dest][src] = 0;
		}

		double[] dist = new double[numPoles];
		for (int i = 0; i < numPoles; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		boolean[] visited = new boolean[numPoles];
		boolean ok = true;
		for (int pole = 0; pole < numPoles; pole++) {
			int min = -1;
			for (int i = 0; i < numPoles; i++) {
				if (!visited[i] && (min == -1 || dist[min] > dist[i])) {
					min = i;
				}
			}
			if (dist[min] == Integer.MAX_VALUE) {
				ok = false;
				break;
			}
			if (min == numPoles - 1) {
				break;
			}
			visited[min] = true;

			for (int i = 0; i < numPoles; i++) {
				if (dist[i] > costs[min][i] + dist[min]) {
					dist[i] = dist[min] + costs[min][i];
				}
			}
		}

		if (!ok) {
			System.out.println(-1);
		}
		else {
			System.out.println((int) (dist[numPoles - 1] * 1000));
		}

		scan.close();
	}
}
