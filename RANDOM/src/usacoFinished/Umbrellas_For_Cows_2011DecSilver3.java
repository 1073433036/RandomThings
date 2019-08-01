package usacoFinished;

import java.util.Arrays;
import java.util.Scanner;

public class Umbrellas_For_Cows_2011DecSilver3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int maxLoc = scan.nextInt();
		int[] locs = new int[numCows + 1];
		for (int i = 1; i <= numCows; i++) {
			locs[i] = scan.nextInt();
		}

		Arrays.sort(locs);
		int[] prices = new int[maxLoc];
		for (int i = 0; i < maxLoc; i++) {
			prices[i] = scan.nextInt();
		}

		int[] cost = new int[numCows + 1];
		for (int i = 1; i <= numCows; i++) {
			int min = -1;
			int loc = i - 1;
			for (int j = 0; j < maxLoc; j++) {
				if (loc > 0 && locs[loc] >= locs[i] - j) {
					loc--;
				}
				if (min == -1 || cost[loc] + prices[j] < min) {
					min = cost[loc] + prices[j];
				}
			}
			cost[i] = min;
		}

		System.out.println(cost[numCows]);

		scan.close();
	}
}
