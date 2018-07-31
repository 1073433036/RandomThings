package MATHISNOTMETH;

import java.util.Scanner;

public class FirstDigitPowerPercentage
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		float times = 0, base = scan.nextInt();
		int fd = 1;
		for (int i = 1; i < 100; i++)
		{
			if (("" + Math.pow(base, i)).substring(0, 1).equals(fd + ""))
				times++;
			System.out.println(times / i + " " + Math.pow(base, i));
		}
		System.out.println(Math.log10(1 + 1 / fd));
		scan.close();

		// float times = 0, total = 100, average = 0, t = 1000;
		// for (int j = 0; j < t; j++)
		// {
		// for (int i = 1; i < total; i++)
		// if (("" + Math.pow(j, i)).substring(0, 1).equals("9"))
		// times++;
		// System.out.println(times / total);
		// average += times / total;
		// times = 0;
		// }
		// average /= t;
		// System.out.println(average);
	}
}