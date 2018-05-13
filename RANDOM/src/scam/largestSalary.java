package scam;

import java.util.Scanner;

public class largestSalary
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int nums=scan.nextInt();
		int[] list = new int[nums];
		int[] prefixsum = new int[nums];
		int max = 0;
		int[] sums = new int[nums];
		list[0] = scan.nextInt();
		prefixsum[0] = list[0];
		sums[0] = list[0];
		for (int i = 1; i < nums; i++)
		{
			list[i] = scan.nextInt();
			prefixsum[i] = prefixsum[i - 1] + list[i];
			if (prefixsum[i - 1] < 0)
			{
				sums[i] = list[i];
				if (sums[i] > max)
					max = sums[i];
			}
			else
			{
				sums[i] = list[i] + sums[i - 1];
				if (sums[i] > max)
					max = sums[i];
			}
		}

		System.out.println(max);
		scan.close();
	}
}
