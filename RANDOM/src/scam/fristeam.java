package scam;

import java.util.Scanner;

public class fristeam
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[] cows = new int[scan.nextInt()];
		int fav = scan.nextInt();
		int[][] sum = new int[2][fav];
		for (int i = 0; i < cows.length; i++)
			cows[i] = scan.nextInt();

		sum[0][0] = 1;
		for (int i = 1; i <= cows.length; i++)
		{
			sum[i % 2] = new int[fav];
			for (int j = 0; j < fav; j++)
				if (sum[(i - 1) % 2][j] > 0)
				{
					sum[i % 2][(j + cows[i - 1]) % fav] += sum[(i - 1) % 2][j] % 100000000;
					sum[i % 2][j] += sum[(i - 1) % 2][j] % 100000000;
				}
		}

		System.out.println((sum[cows.length % 2][0] - 1) % 100000000);
		scan.close();
	}
}
