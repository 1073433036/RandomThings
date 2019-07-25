package usacoFinished;

import java.util.Scanner;

public class bestspot {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numPastures = scan.nextInt();
		int numFavorites = scan.nextInt();
		int numConnections = scan.nextInt();
		int[] favorites = new int[numFavorites];
		for (int i = 0; i < numFavorites; i++) {
			favorites[i] = scan.nextInt() - 1;
		}
		int[][] costs = new int[numPastures][numPastures];
		for (int i = 0; i < numPastures; i++) {
			for (int j = 0; j < numPastures; j++) {
				costs[i][j] = Integer.MAX_VALUE;
				if (i == j) {
					costs[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < numConnections; i++) {
			int src = scan.nextInt() - 1;
			int dest = scan.nextInt() - 1;
			int weight = scan.nextInt();
			costs[src][dest] = weight;
			costs[dest][src] = weight;
		}

		for (int intermediate = 0; intermediate < numPastures; intermediate++) {
			for (int src = 0; src < numPastures; src++) {
				if (src != intermediate && costs[src][intermediate] != Integer.MAX_VALUE) {
					for (int dest = 0; dest < numPastures; dest++) {
						if (intermediate != dest && src != dest && costs[intermediate][dest] != Integer.MAX_VALUE) {
							if (costs[src][dest] > costs[src][intermediate] + costs[intermediate][dest]
									&& costs[src][intermediate] + costs[intermediate][dest] >= 0) {
								costs[src][dest] = costs[src][intermediate] + costs[intermediate][dest];
							}
						}
					}
				}
			}
		}

		int min = numPastures * 1000;
		int minInd = -1;
		for (int i = 0; i < numPastures; i++) {
			int total = 0;
			for (int j = 0; j < numFavorites; j++) {
				total += costs[i][favorites[j]];
			}
			if (total < min) {
				min = total;
				minInd = i;
			}
		}

		System.out.println(minInd + 1);
		scan.close();
	}
}
