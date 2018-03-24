package scam;

import java.util.Scanner;

public class fact
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println(factorial(scan.nextInt()));

		scan.close();
	}

	public static int factorial(int n)
	{
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}
}
