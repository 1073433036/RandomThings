package scam;

import java.util.Scanner;

public class knapsack
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cap = scan.nextInt();
		int[][] sums = new int[n + 1][cap + 1];
		int max = 0;
		for (int i = 1; i <= n; i++)
		{
			int size = scan.nextInt();
			int val = scan.nextInt();
			for (int j = 0; j <= cap; j++)
			{
				if (j < size)
					sums[i][j] = sums[i - 1][j];
				else
					sums[i][j] = Math.max(sums[i - 1][j], sums[i - 1][j - size] + val);
				if (max < sums[i][j])
					max = sums[i][j];
			}
		}

		System.out.println(max);

		scan.close();
	}
}
