package scam;

import java.util.Scanner;

public class subsetsum
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[scan.nextInt()];
		int sum = scan.nextInt();
		int[][] can = new int[nums.length + 1][sum + 1];
		for (int i = 0; i < nums.length; i++)
			nums[i] = scan.nextInt();

		can[0][0] = 2;
		for (int i = 1; i <= sum; i++)
			can[0][i] = 1;

		for (int i = 1; i <= nums.length; i++)
			for (int j = 0; j <= sum; j++)
				if (j - nums[i - 1] >= 0)
					can[i][j] = can[i - 1][j] == 2 ? 2 : can[i - 1][j - nums[i - 1]];
				else
					can[i][j] = can[i - 1][j];

		System.out.println(can[nums.length][sum] == 2 ? "True" : "False");

		scan.close();
	}
}
