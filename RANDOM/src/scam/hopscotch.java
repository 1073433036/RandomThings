package scam;

import java.util.Scanner;

public class hopscotch
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		scan.nextInt();
		long[][] solution = new long[r][c];
		int[][] values = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				values[i][j] = scan.nextInt();

		solution[0][0] = 1;
		for (int i = 1; i < r; i++)
			for (int j = 1; j < c; j++)
				for (int k = 0; k < i; k++)
					for (int l = 0; l < j; l++)
						if (values[k][l] != values[i][j])
						{
							solution[i][j] += solution[k][l];
							solution[i][j] %= 1000000007;
						}

		System.out.println(solution[r - 1][c - 1] % 1000000007);
		scan.close();
	}
}
