package scam;

import java.util.Scanner;

public class setsub
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int m = scan.nextInt();
		int[] set = new int[m];
		for (int i = 0; i < m; i++)
			set[i] = scan.nextInt();

		for (int j = 1; j <= m; j++)
		{
			int[] result = writeAll(j, set); // jth digit
			for (int i = 0; i < result.length; i++)
				System.out.println(result[i]);
		}

		scan.close();
	}

	public static int[] writeAll(int n, int[] set)
	{
		if (n == 1)
			return set;

		int[] result = new int[factorial(set.length, n) / factorial(n, n)];
		int count = 0;
		for (int i = 0; i < set.length; i++)
		{
			int[] next = writeAll(n - 1, remove(set[i], set));
			for (int j = 0; j < next.length; j++)
			{
				result[count] = (int) Math.pow(10, n - 1) * set[i] + next[j];
				count++;
			}
			set = remove(set[i], set);
			i--;
		}

		return result;
	}

	public static int[] remove(int num, int[] set)
	{
		int[] result = new int[set.length - 1];
		int count = 0;
		for (int i = 0; i < set.length; i++)
			if (set[i] != num)
			{
				result[count] = set[i];
				count++;
			}
		return result;
	}

	public static int factorial(int k, int n)
	{
		if (n == 0)
			return 1;
		return k * factorial(k - 1, n - 1);
	}
}
