package scam;

import java.util.Scanner;

public class tribonacci
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long a = 0;
		long b = 0;
		long c = 1;
		long curr;
		for (int i = 3; i < n; i++)
		{
			curr = a + b + c;
			a = b;
			b = c;
			c = curr;
		}

		if (n <= 1)
			System.out.println(0);
		else
			System.out.println(c);
		scan.close();
	}
}
