package usaco.NO;

import java.util.Scanner;

public class flow {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] adjmatrix = new int[52][52];
		int[] degrees = new int[52];

		int numConnections = scan.nextInt();
		for (int i = 0; i < numConnections; i++) {
			int first = scan.next().charAt(0);
			int second = scan.next().charAt(0);
			int flow = scan.nextInt();
			if (first < 97) {
				first -= 65;
			}
			else {
				first -= 97 - 26;
			}
			if (second < 97) {
				second -= 65;
			}
			else {
				second -= 97 - 26;
			}

			if (adjmatrix[first][second] == 0) {
				degrees[first]++;
				degrees[second]++;
			}
			adjmatrix[first][second] += flow;
			adjmatrix[second][first] += flow;
		}

		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 1; i < 52; i++) {
				if (degrees[i] == 1 && i != 25) {
					int j = 0;
					for (; j < 52; j++) {
						if (adjmatrix[i][j] > 0) {
							break;
						}
					}
					adjmatrix[i][j] = adjmatrix[j][i] = 0;
					degrees[i]--;
					degrees[j]--;
					flag = true;
				}
				else if (degrees[i] == 2) {
					int n1 = -1;
					int n2 = -1;
					for (int j = 0; j < 52; j++) {
						if (adjmatrix[i][j] > 0) {
							if (n1 == -1) {
								n1 = j;
							}
							else {
								n2 = j;
							}
						}
					}
					System.out.print(n1 + " " + i + " " + n2 + " ");
					if (adjmatrix[n1][n2] > 0) {
						degrees[n1]--;
						degrees[n2]--;
					}
					adjmatrix[n1][n2] += Math.min(adjmatrix[n1][i], adjmatrix[i][n2]);
					System.out.println(adjmatrix[n1][n2] + " " + degrees[n1] + " " + degrees[n2]);
					adjmatrix[n2][n1] = adjmatrix[n1][n2];
					adjmatrix[n1][i] = adjmatrix[i][n1] = adjmatrix[i][n2] = adjmatrix[n2][i] = 0;
					degrees[i] = 0;
					flag = true;
				}
			}
		}

		System.out.println(adjmatrix[0][25]);
		// rule 2 += new capacities
		// apply rule 1 and rule 3, count degree of nodes
		// degree=2, rule1, degree==1, rule 3
		// degree>2, next node
		scan.close();
	}
}