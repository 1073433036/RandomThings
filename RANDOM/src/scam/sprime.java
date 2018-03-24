package scam;

import java.util.Scanner;

public class sprime
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int digits = scan.nextInt();

		solve(digits, 1, 2);
		solve(digits, 1, 3);
		solve(digits, 1, 5);
		solve(digits, 1, 7);

		scan.close();
	}

	public static void solve(int digits, int pos, int val)
	{
		if (!isPrime(val))
			return;
		if (pos == digits)
			System.out.println(val);

		solve(digits, pos + 1, val * 10 + 1);
		solve(digits, pos + 1, val * 10 + 3);
		solve(digits, pos + 1, val * 10 + 7);
		solve(digits, pos + 1, val * 10 + 9);
	}

	public static boolean isPrime(int num)
	{
		for (int i = 3; i * i < num; i += 2)
			if (num % i == 0)
				return false;

		return true;
	}
}
