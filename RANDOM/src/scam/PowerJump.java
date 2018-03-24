package scam;

import java.util.Arrays;
import java.util.Scanner;

public class PowerJump
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int stones = scan.nextInt();
		int energy = scan.nextInt();
		int[] differences = new int[stones - 1];
		int next = scan.nextInt();
		int max = 0;
		for (int i = 0; i < stones - 1; i++)
		{
			int temp = scan.nextInt();
			differences[i] = temp - next;
			next = temp;
			max += differences[i];
		}
		if (max <= energy)
		{
			System.out.println(0);
			scan.close();
			return;
		}

		Arrays.sort(differences);
		for (int i = 0; i < differences.length; i++)
		{
			int total = 0;
			for (int j = i + 1; j < differences.length; j++)
				total += differences[j] > differences[i] ? differences[j] : 0;
			if (total < energy)
			{
				System.out.println(differences[i]);
				break;
			}
		}

		scan.close();
	}
}
