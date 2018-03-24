package MATHISNOTMETH;

public class Formxyz1
{
	public static void main(String[] args)
	{
		for (long i = 0; i < Long.MAX_VALUE; i++)
			for (long j = 0; j < Long.MAX_VALUE; j++)
				for (long k = 0; k < Long.MAX_VALUE; k++)
					if (i + j != 0 && i + k != 0 && j + k != 0 && i / (j + k) + j / (i + k) + k / (i + j) == 3)
						System.out.println(i + "  " + j + "  " + k);
	}
}
