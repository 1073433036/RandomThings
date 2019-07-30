package scam;

import java.util.Scanner;

public class knapsack {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numItems = scan.nextInt();
		int capacity = scan.nextInt();
		int[][] sums = new int[numItems + 1][capacity + 1];
		// sums[i][j]= max value given i items and j capacity
		// sum[i][j]=Max(sum[i-1][j], sum[i-1][j-sizei]+vali)

		for (int i = 1; i <= numItems; i++) {
			int sizei = scan.nextInt();
			int vali = scan.nextInt();
			for (int j = 1; j <= capacity; j++) {
				if (j - sizei >= 0) {
					sums[i][j] = sums[i - 1][j - sizei] + vali;
				}
				sums[i][j] = Math.max(sums[i][j], sums[i - 1][j]);
			}
		}

		System.out.println(sums[numItems][capacity]);

		scan.close();
	}
}
