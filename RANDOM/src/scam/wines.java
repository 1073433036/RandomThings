package scam;

import java.util.Scanner;

public class wines {
	static int[] wines;
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		wines = new int[N];
		for (int i = 0; i < N; i++) {
			wines[i] = scan.nextInt();
		}

		dp = new int[N][N];
		System.out.println(memo(0, N - 1));
		
		scan.close();
	}

	static int[][] dp;

	public static int memo(int left, int right) {
		if (left > right) {
			return 0;
		}
		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		int year = N - (right - left);
		int temp1 = 0;
		int temp2 = 0;
		if (left < N) {
			temp1 = year * wines[left] + memo(left + 1, right);
		}
		if (right > 0) {
			temp2 = year * wines[right] + memo(left, right - 1);
		}

		return dp[left][right] = Math.max(temp1, temp2);
	}

}
