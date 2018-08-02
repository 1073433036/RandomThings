package foobar;

import java.util.HashMap;

public class staircase
{
	static private HashMap<String, Integer> dp = new HashMap<>();

	public static int answer(int n)
	{
		// how many ways to split n into distinct parts
		// cant count staircase size 1
		return q(n, n) - 1;
	}

	// modified normal partition
	public static int q(int bricksLeft, int maxDistinct)
	{
		if (bricksLeft <= 1)
			return 1;

		if (maxDistinct > bricksLeft)
			return q(bricksLeft, bricksLeft);

		String q = bricksLeft + "," + maxDistinct;
		if (dp.containsKey(q))
			return dp.get(q);

		int sum = 0;
		// distinct= odd
		for (int k = 1; k <= maxDistinct; k += 2)
			sum += q(bricksLeft - k, k);

		dp.put(q, sum);
		return sum;
	}

	public static void main(String[] args)
	{
		int test = 100;
		System.out.println(answer(test));
		// for (int i = 1; i <= test; i++)
		// System.out.println(dp[i]);
	}
}
