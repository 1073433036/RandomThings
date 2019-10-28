package Math;

import java.util.ArrayList;

public class BaseCorrelationDecBinOctHex
{
	public static void main(String[] args)
	{
		for (int num = 0; num <= 350; num++)
		{
			ArrayList<Integer> base2 = convert(num, 2), base8 = convert(num, 8), base16 = convert(num, 16);
			System.out
					.println(num + "\t" + base2 + "\t\t" + base8 + "\t" + base16 + "\t" + conBaseToBase(base16, 8, 16));
		}
	}

	public static int conBaseToBase(ArrayList<Integer> num, int base1, int base2)
	{
		int end = 0;
		for (int i = num.size() - 1; i >= 0; i--)
			end += num.get(i) * (int) Math.pow(20, num.size() - i - 1);
		return end;
	}

	public static ArrayList<Integer> convert(int num, int base)
	{
		ArrayList<Integer> numBase = new ArrayList<>();
		// algorithm for converting numbers into different bases
		while (true)
		{
			numBase.add(0, num % base);
			num /= base;

			// exit loop
			if (num == 0)
				return numBase;
		}
	}
}
