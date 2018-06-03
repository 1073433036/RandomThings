package scam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class mooomoo
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[] field = new int[scan.nextInt()];
		Integer[] breed = new Integer[scan.nextInt()];

		for (int i = 0; i < breed.length; i++)
			breed[i] = scan.nextInt();

		int max = 0;
		for (int i = 0; i < field.length; i++)
		{
			field[i] = scan.nextInt();
			max = Math.max(max, field[i]);
		}

		Arrays.sort(breed, Collections.reverseOrder());

		int[][] sums = new int[breed.length + 1][max + 1];
		for (int i = 1; i < sums.length; i++)
		{
			sums[i][breed[i - 1]] = 1;
			for (int j = breed[i - 1] + 1; j < sums[0].length; j++)
			{
				if (sums[i][j - breed[i - 1]] != 0 && sums[i - 1][j] != 0)
					sums[i][j] = Math.min(sums[i][j - breed[i - 1]], sums[i - 1][j] + 1);
				else if (sums[i][j - breed[i - 1]] != 0)
					sums[i][j] = sums[i][j - breed[i - 1]] + 1;
				else if (sums[i - 1][j] != 0)
					sums[i][j] = sums[i - 1][j];
			}
		}

		int total = 0;
		int[] newfield = new int[field.length];
		newfield[0] = field[0];
		for (int i = 0; i < field.length; i++)
		{
			if (sums[breed.length][newfield[i]] == 0 && newfield[i] != 0)
			{
				total = -1;
				break;
			}
			total += sums[breed.length][newfield[i]];
			if (i + 1 < field.length)
				if (field[i] != 0)
					newfield[i + 1] = field[i + 1] - field[i] + 1;
				else
					newfield[i + 1] = field[i + 1];
		}
		System.out.println(total);
		scan.close();
	}
}
