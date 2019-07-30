package scam;

import java.util.Scanner;

public class coinchange {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();
		int numCoins = scan.nextInt();
		int[] coins = new int[numCoins + 1];
		for (int i = 1; i <= numCoins; i++) {
			coins[i] = scan.nextInt();
		}
		int[][] possible = new int[numCoins + 1][target + 1];
		for (int i = 1; i <= target; i++) {
			possible[0][i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i <= numCoins; i++) {
			if (coins[i] <= target) {
				possible[i][coins[i]] = 1;
			}
			for (int j = 0; j <= target; j++) {
				if (j - coins[i] < 0) {
					possible[i][j] = possible[i - 1][j];
					continue;
				}
				possible[i][j] = Math.min(possible[i - 1][j], possible[i][j - coins[i]] + 1);
			}
		}

		for (int i = 0; i <= numCoins; i++) {
			for (int j = 0; j <= target; j++) {
				System.out.print(possible[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < target; i++) {
			System.out.print(i % 10 + " ");
		}
		System.out.println();
		System.out.println(possible[numCoins][target]);
		scan.close();
	}
}
