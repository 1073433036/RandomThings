package scam;

import java.util.Scanner;

public class triangle
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int[][] solution = new int[r][r];
		int[][] triangle = new int[r][r];
		for (int i = 0; i < r; i++)
			for (int j = 0; j <= i; j++)
				triangle[i][j] = scan.nextInt();

		for (int i = 0; i < r; i++)
			solution[r - 1][i] = triangle[r - 1][i];
		for (int i = r - 2; i >= 0; i--)
			for (int j = 0; j <= i; j++)
				solution[i][j] = triangle[i][j] + Math.max(solution[i + 1][j], solution[i + 1][j + 1]);

		System.out.println(solution[0][0]);

		scan.close();
	}
}
