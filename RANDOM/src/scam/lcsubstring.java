package scam;

import java.util.Scanner;

public class lcsubstring
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		int[][] substring = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 1; i <= s1.length(); i++)
			for (int j = 1; j <= s2.length(); j++)
			{
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					substring[i][j] = substring[i - 1][j - 1] + 1;
				else
					substring[i][j] = 0;
				max = Math.max(max, substring[i][j]);
			}

		System.out.println(max);

		scan.close();
	}
}
