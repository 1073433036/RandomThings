package scam;

import java.util.Scanner;

public class lcsubsequence
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		int[][] subset = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++)
			for (int j = 1; j <= s2.length(); j++)
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					subset[i][j] = subset[i - 1][j - 1] + 1;
				else
					subset[i][j] = Math.max(subset[i - 1][j], subset[i][j - 1]);

		System.out.println(subset[s1.length()][s2.length()]);
		scan.close();
	}
}
