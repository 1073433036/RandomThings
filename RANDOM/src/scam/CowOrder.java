package scam;

import java.util.Scanner;

public class CowOrder
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] cowage = new int[num];
		for (int i = 0; i < num; i++)
			cowage[i] = scan.nextInt();

		int[][] allnums = writeAll(cowage);
		int count = 0;
		for (int i = 0; i < allnums.length; i++)
		{
			int total = 0;
			for (int j = 0; j < num - 1; j++)
				if (allnums[i][j] + j <= allnums[i][j + 1] + j + 1)
					total++;
				else
					break;
			if (total == num - 1)
				count++;
		}

		System.out.println(count);

		scan.close();
	}

	public static int[][] writeAll(int[] set)
	{
		if (set.length == 1)
		{
			int[][] nums = new int[1][1];
			nums[0] = set;
			return nums;
		}

		int[][] result = new int[factorial(set.length)][set.length];
		int count = 0;
		for (int i = 0; i < set.length; i++)
		{
			int[][] next = writeAll(remove(set[i], set));
			for (int j = 0; j < next.length; j++)
			{
				result[count][0] = set[i];
				for (int k = 0; k < next[0].length; k++)
					result[count][k + 1] = next[j][k];
				count++;
			}
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

	public static int factorial(int k)
	{
		if (k == 0)
			return 1;
		return k * factorial(k - 1);
	}

}
