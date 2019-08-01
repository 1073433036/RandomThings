package scam;

import java.util.Scanner;

public class partitionproblem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		if (N * (N + 1) / 2 % 2 == 1) {
			System.out.println(0);
			scan.close();
			return;
		}
		int halfSum = N * (N + 1) / 4;
		long[][] count = new long[N + 1][halfSum + 1];
		count[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= halfSum; j++) {
				if (j - i >= 0) {
					count[i][j] = count[i - 1][j - i];
				}
				count[i][j] += count[i - 1][j];
			}
		}

		System.out.println(count[N][halfSum] / 2);
		scan.close();
	}
}
