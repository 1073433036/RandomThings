package scam;

import java.util.Scanner;

public class bincoef {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[][] vals = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					vals[i][j] = 1;
				}
				else {
					vals[i][j] = vals[i - 1][j - 1] + vals[i - 1][j];
				}
			}
		}

		System.out.println(vals[n][k]);
		scan.close();
	}
}
