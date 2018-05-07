package scam;

import java.util.Scanner;

public class bincoef
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt() + 1;
		int k = scan.nextInt() + 1;
		int[][] val = new int[n][k];
		for (int i = 0; i < n; i++)
		{
			val[i][0] = 1;
			if (i < k)
				val[i][i] = 1;
			for (int j = 1; j < Math.min(i, k); j++)
				val[i][j] = val[i - 1][j] + val[i - 1][j - 1];
		}

		System.out.println(val[n - 1][k - 1]);
		scan.close();
	}
}
