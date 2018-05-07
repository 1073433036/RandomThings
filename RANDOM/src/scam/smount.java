package scam;

import java.util.Scanner;

public class smount
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ls = new int[n];
		int[] rs = new int[n];
		int[] m = new int[n];
		for (int i = 0; i < n; i++)
			m[i] = scan.nextInt();
		
		for (int i = 1; i < n; i++)
			if (m[i] >= m[i - 1])
				ls[i] = ls[i - 1] + 1;
		
		for (int i = n - 2; i >= 0; i--)
			if (m[i] >= m[i + 1])
				rs[i] = rs[i + 1] + 1;
		
		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(ls[i] + rs[i], max);

		System.out.println(max + 1);
		scan.close();
	}
}
