package MATHISNOTMETH;

import java.util.ArrayList;

public class BaseCorrelation
{
	public static void main(String[] args)
	{
		// lines
		ArrayList<String> baseLines = new ArrayList<>();
		ArrayList<String> convertingLines = new ArrayList<>();

		// getting lines
		for (int base1 = 2; base1 <= 16; base1++)
		{
			String baseLine = "";
			String convertingLine = "";
			String differenceLine = "";
			for (int num = 0; num < 50; num++)
			{
				baseLine += convertDecimalToBases(num, base1) + " ";
				for (int base2 = 2; base2 <= 16; base2++)
					if (base2 != base1)
					{
						int converted = toDecimalConversionButWithBaseInConvertingBase(num, base1, base2);
						convertingLine += converted;
						differenceLine += differenceConversion(converted, num, base1, base2);
					}
			}
			baseLines.add(baseLine);
			convertingLines.add(convertingLine);
			convertingLines.add(differenceLine);
		}

		// output lines
		for (int i = 0; i < baseLines.size(); i++)
			System.out.println("Base " + (i + 2) + ": " + baseLines.get(i));
		System.out.println("\n\n\n");
		for (int i = 0; i < convertingLines.size(); i++)
		{
			System.out.println("Base " + (i + 2) + ": " + convertingLines.get(i));
			System.out.println("Base " + (i + 2) + ": " + convertingLines.get(i++));
		}
	}

	public static int differenceConversion(int converted, int num, int base1, int base2)
	{
		return toDecimalConversionButWithBaseInConvertingBase(num, base1, 10) - converted;
	}

	public static int toDecimalConversionButWithBaseInConvertingBase(int num, int base1, int base2)
	{
		// split into digits
		String[] splitnum = ("" + num).split("");
		int[] total =new int[];
		for (int i = splitnum.length - 1; i >= 0; i--)
		{
			// convert base1 number into base2
			String[] base1InBase2 = convertDecimalToBases((int) Math.pow(base1, i), base2).split("");
			int[] base1InBase2Remove = new int[base1InBase2.length];
			for (int j = 0; j < base1InBase2.length; j++)
				switch (base1InBase2[j])
				{
					case "A":
						base1InBase2Remove[j] = 10;
						break;
					case "B":
						base1InBase2Remove[j] = 11;
						break;
					case "C":
						base1InBase2Remove[j] = 12;
						break;
					case "D":
						base1InBase2Remove[j] = 13;
						break;
					case "E":
						base1InBase2Remove[j] = 14;
						break;
					case "F":
						base1InBase2Remove[j] = 15;
						break;
				}
			// add powers of base1 num in base2
			total = multiplyAndAdd(base1InBase2Remove, Integer.parseInt(splitnum[i]), total);
		}

		return total;
	}

	public static int multiplyAndAdd(int[] base1InBase2Remove,int digit,int total)
	{
		String[] multiplied=new String[base1InBase2Remove.length];
		for(int i=0;i<multiplied.length;i++)
			multiplied[i]=base1InBase2Remove[i]*digit+"";
	}

	public static String convertDecimalToBases(int num, int base)
	{
		String numBase = "";
		// algorithm for converting numbers into different bases
		while (true)
		{
			int remainder = num % base;
			num /= base;

			// modify remainder so follows after 9 digits, A, B, ...
			switch (remainder)
			{
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					numBase = remainder + numBase;
					break;
				case 10:
					numBase = "A" + numBase;
					break;
				case 11:
					numBase = "B" + numBase;
					break;
				case 12:
					numBase = "C" + numBase;
					break;
				case 13:
					numBase = "D" + numBase;
					break;
				case 14:
					numBase = "E" + numBase;
					break;
				case 15:
					numBase = "F" + numBase;
					break;
			}

			// exit loop
			if (num == 0)
				return numBase;
		}
	}
}
