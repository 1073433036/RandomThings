package scam;

import java.util.Scanner;

public class setall
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int m = scan.nextInt();
		int[] set = new int[m];
		for (int i = 0; i < m; i++)
			set[i] = scan.nextInt();
		int n = scan.nextInt();

		int[] result = writeAll(n, n, set);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);

		scan.close();
	}

	public static int[] writeAll(int n, int original, int[] set)
	{
		if (n == 0)
			return new int[1];

		int[] result = writeAll(n - 1, original, set);
		int[] next = new int[result.length * set.length];
		int count = 0;
		for (int i = 0; i < set.length; i++)
			for (int j = 0; j < result.length; j++)
				next[count++] = set[i] * (int) Math.pow(10, n - 1) + result[j];

		return next;
	}
}
