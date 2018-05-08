package scam;

import java.util.Scanner;

public class longestIncreasingSequence
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[] list = new int[scan.nextInt()];
		int[] max = new int[list.length];
		int totalmax = 0;
		for (int i = 0; i < list.length; i++)
		{
			list[i] = scan.nextInt();
			int highest = 0;
			for (int j = 0; j < i; j++)
				if (max[j] > highest && list[j] < list[i])
					highest = max[j];
			max[i] = highest + 1;
			if (totalmax < max[i])
				totalmax = max[i];
		}

		System.out.println(totalmax);
		scan.close();
	}
}
