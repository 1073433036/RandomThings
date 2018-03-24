package scam;

import java.util.Scanner;

public class ruler
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		String stars = "";
		for (int i = 0; i < n; i++)
			stars += "*";
		System.out.println(stars + "\n" + makeruler(n - 1) + "\n" + stars);

		scan.close();
	}

	public static String makeruler(int n)
	{
		if (n == 1)
			return "*";
		String stars = "";
		for (int i = 0; i < n; i++)
			stars += "*";
		String smaller = makeruler(n - 1);
		return smaller + "\n" + stars + "\n" + smaller;
	}
}
