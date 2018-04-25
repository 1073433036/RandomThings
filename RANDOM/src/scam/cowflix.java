package scam;

import java.util.Scanner;

public class cowflix
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		int cows = scan.nextInt();
		int[] weights = new int[cows];
		for (int i = 0; i < cows; i++)
			weights[i] = scan.nextInt();

		System.out.println(result(weights, max, 0));
		scan.close();
	}

	public static int result(int[] weights, int max, int count)
	{
		if (count > max)
			return -1;
		if (weights.length == 0)
			return count;
		return Math.max(result(remove(weights), max, count + weights[weights.length - 1]),
				result(remove(weights), max, count));
	}

	public static int[] remove(int[] weights)
	{
		int[] res = new int[weights.length - 1];
		for (int i = 0; i < weights.length - 1; i++)
			res[i] = weights[i];
		return res;
	}
}
