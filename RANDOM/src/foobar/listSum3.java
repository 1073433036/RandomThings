package foobar;

import java.util.Arrays;

public class listSum3
{
	public static int answer(int[] l)
	{
		Arrays.sort(l);
		for (int i = 0; i < l.length / 2; i++)
		{
			int temp = l[i];
			l[i] = l[l.length - i - 1];
			l[l.length - i - 1] = temp;
		}

		String[][] dp = new String[l.length + 1][3];
		for (int i = 0; i < 3; i++)
			dp[0][i] = null;
		dp[0][0] = "0";
		for (int i = 1; i <= l.length; i++)
		{
			int add = l[i - 1] % 3;
			for (int j = 0; j < 3; j++)
			{
				if (dp[i - 1][j] != null)
				{
					dp[i][j] = dp[i - 1][j];
				}
			}
			for (int j = 0; j < 3; j++)
			{
				if (dp[i - 1][j] != null)
				{
					if (dp[i][(j + add) % 3] != null)
					{
						dp[i][(j + add) % 3] = "" + Math.max(Integer.parseInt(dp[i][(j + add) % 3]),
								Integer.parseInt(dp[i - 1][j] + l[i - 1]));
					}
					else
					{
						dp[i][(j + add) % 3] = dp[i - 1][j] + l[i - 1];
					}
				}
			}

			// for (int j = 0; j <= l.length; j++)
			// {
			// for (int k = 0; k < 3; k++)
			// System.out.print(dp[j][k] + " ");
			// System.out.println();
			// }
		}

		return Integer.parseInt(dp[l.length][0]);
	}

	public static void main(String[] args)
	{
		System.out.println(answer(new int[]
			{ 3, 1, 4, 1, 5, 9, 2, 6 }));
	}
}
