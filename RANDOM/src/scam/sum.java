package scam;

import java.util.Scanner;
import java.util.TreeSet;

public class sum {

	private static int[] nums;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		nums = new int[scan.nextInt()];
		
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt();
			max = Math.max(max, nums[i]);
		}
		dp = new long[N + 1];
		dp[0] = 1;

		System.out.println(memo(N));

		int[] dp1 = new int[N + 1];
		dp1[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] < 0) {
					break;
				}
				dp1[i] += dp1[i - nums[j]];
			}
		}
		System.out.println(dp1[N]);

		boolean[] used = new boolean[N + max + 1];
		TreeSet<Integer> track = new TreeSet<>();
		int[] dp2 = new int[N + max + 1];
		dp2[0] = 1;
		track.add(0);
		while (!track.isEmpty()) {
			int cur = track.pollFirst();
			used[cur] = true;
			if (cur >= N) {
				break;
			}
			for (int j = 0; j < nums.length; j++) {
				dp2[cur + nums[j]] += dp2[cur];
				if (!used[cur + nums[j]]) {
					track.add(cur + nums[j]);
				}
			}
		}
		System.out.println(dp2[N]);
		scan.close();
	}

	public static long[] dp;

	public static long memo(int n) {
		if (dp[n] != 0) {
			return dp[n];
		}

		long result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (n - nums[i] < 0) {
				break;
			}
			result += memo(n - nums[i]);
		}

		return dp[n] = result;
	}
}
