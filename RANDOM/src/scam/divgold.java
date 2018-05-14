package scam;

import java.util.Scanner;

public class divgold
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[] sack = new int[scan.nextInt()];
		int total = 0;
		for (int i = 0; i < sack.length; i++)
		{
			sack[i] = scan.nextInt();
			total += sack[i];
		}

		int[][] subset = new int[2][total / 2 + 1];
		for (int i = 1; i <= sack.length; i++)
			for (int j = 0; j <= total / 2; j++)
				subset[i % 2][j] = Math.max(subset[(i - 1) % 2][j],
						j - sack[i - 1] >= 0 ? subset[(i - 1) % 2][j - sack[i - 1]] + sack[i - 1] : 0);

		System.out.println(total - subset[sack.length % 2][total / 2] * 2);

		int[][] ways = new int[2][total / 2 + 1];
		ways[0][0] = 1;
		for (int i = 1; i <= sack.length; i++)
			for (int j = 0; j <= total / 2; j++)
				ways[i % 2][j] = ways[(i - 1) % 2][j] % 1000000
						+ (j - sack[i - 1] >= 0 ? ways[(i - 1) % 2][j - sack[i - 1]] : 0) % 1000000;

		int end = 0;
		for (int i = total / 2; i >= 0; i--)
			if (ways[sack.length % 2][i] > 0)
			{
				end = ways[sack.length % 2][i];
				break;
			}

		System.out.println(end % 1000000);
		scan.close();
	}

}
