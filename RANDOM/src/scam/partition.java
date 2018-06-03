package scam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class partition
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = (n + 1) * (n / 2);
		if (n % 2 == 1)
			sum += n / 2 + 1;
		if (sum % 2 == 1)
		{
			System.out.println(0);
			scan.close();
			return;
		}

		int[][] sums = new int[n + 1][sum / 2 + 1];
		for (int i = 1; i <= n; i++)
		{
			sums[i][i] = 1;
			for (int j = 0; j < sums[0].length; j++)
			{
				sums[i][j] += sums[i - 1][j];
				sums[i][j] += j - i >= 0 ? sums[i - 1][j - i] : 0;
			}
		}

		System.out.println(sums[n][sum / 2] / 2);
		scan.close();
	}
}
