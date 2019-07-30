package usacoFinished;

import java.util.Scanner;

public class divgold {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCoins = scan.nextInt();
		int[] coins = new int[numCoins + 1];
		int sum = 0;
		for (int i = 1; i <= numCoins; i++) {
			coins[i] = scan.nextInt();
			sum += coins[i];
		}
		boolean[][] possible = new boolean[2][sum / 2 + 1];
		// possible[i][j]= using coin i is possible to create amount j
		// possible[i][j]= possible[i-1][j]||possible[i-1][j-coin[i]]
		possible[0][0] = true;
		for (int i = 1; i <= numCoins; i++) {
			possible[i % 2][0] = true;
			for (int j = 1; j <= sum / 2; j++) {
				if (j - coins[i] < 0) {
					possible[i % 2][j] = possible[(i - 1) % 2][j];
					continue;
				}
				possible[i % 2][j] = possible[(i - 1) % 2][j] || possible[(i - 1) % 2][j - coins[i]];
			}
		}

		int maxClosestToHalf = 0;
		for (int i = 0; i <= sum / 2; i++) {
			if (possible[numCoins % 2][i]) {
				maxClosestToHalf = i;
			}
		}

		System.out.println(Math.abs(maxClosestToHalf * 2 - sum));

		long[][] count = new long[2][sum / 2 + 1];
		// count[i][j]=number of ways to get to value j
		// count[i][j]=count[i-1][j]+count[i-1][j-coins[i]]
		count[0][0] = 1;
		for (int i = 1; i <= numCoins; i++) {
			for (int j = 0; j <= sum / 2; j++) {
				count[i % 2][j] = 0;
				if (j - coins[i] >= 0) {
					count[i % 2][j] = count[(i - 1) % 2][j - coins[i]];
				}
				count[i % 2][j] += count[(i - 1) % 2][j];

				count[i % 2][j] %= 1000000;
			}
		}

		System.out.println(count[numCoins % 2][maxClosestToHalf] % 1000000);

		scan.close();
	}

}
