package scam;

import java.util.Scanner;

public class fib
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println(fibonacci(scan.nextInt()));

		scan.close();
	}

	public static int fibonacci(int n)
	{
		if(n<=2)
			return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
