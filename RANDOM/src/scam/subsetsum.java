package scam;

import java.util.Scanner;

public class subsetsum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numNums = scan.nextInt();
		int target = scan.nextInt();
		int[] nums = new int[numNums + 1];
		for (int i = 1; i <= numNums; i++) {
			nums[i] = scan.nextInt();
		}
		boolean[][] subsetsums = new boolean[numNums + 1][target + 1];
		subsetsums[0][0] = true;
		for (int i = 1; i <= numNums; i++) {
			for (int j = 0; j <= target; j++) {
				if (j - nums[i] < 0) {
					subsetsums[i][j] = subsetsums[i - 1][j];
				}
				else {
					subsetsums[i][j] = subsetsums[i - 1][j] || subsetsums[i - 1][j - nums[i]];
				}
			}
		}

		System.out.println(subsetsums[numNums][target]);
		scan.close();
	}
}
