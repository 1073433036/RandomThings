package usacoFinished;

import java.util.Scanner;

public class Main {
	static boolean[][] canTravel;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int numPastures = scan.nextInt();
		int numPaths = scan.nextInt();
		int[] pastureStart = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			pastureStart[i] = scan.nextInt() - 1;
		}

		canTravel = new boolean[numPastures][numPastures];
		for (int i = 0; i < numPaths; i++) {
			canTravel[scan.nextInt() - 1][scan.nextInt() - 1] = true;
		}

		for (int pasture : pastureStart) {
			visited = new boolean[numPastures];
			visited[pasture] = true;
			fill(pasture, pasture);
		}

		int count = 0;
		for (int i = 0; i < numPastures; i++) {
			boolean ok = true;
			for (int j = 0; j < numCows; j++) {
				if (!canTravel[pastureStart[j]][i]) {
					ok = false;
					break;
				}
			}
			if (ok) {
				count++;
			}
		}

		System.out.println(count);
		scan.close();
	}

	public static void fill(int start, int pos) {
		canTravel[start][pos] = true;
		visited[pos] = true;
		for (int i = 0; i < canTravel.length; i++) {
			if (canTravel[pos][i] && !visited[i]) {
				fill(start, i);
			}
		}
	}
}
