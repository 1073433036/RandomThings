package scam;

import java.util.Scanner;

public class ugly
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int i2 = 1;
		int i3 = 1;
		int i5 = 1;
		int[] seq = new int[scan.nextInt() + 2];
		seq[1] = 1;
		for (int i = 2; i < seq.length - 1; i++)
		{
			int nm2 = seq[i2] * 2;
			int nm3 = seq[i3] * 3;
			int nm5 = seq[i5] * 5;
			seq[i] = Math.min(nm2, Math.min(nm3, nm5));
			if (seq[i] == nm2)
				i2++;
			if (seq[i] == nm3)
				i3++;
			if (seq[i] == nm5)
				i5++;
		}

		System.out.println(seq[seq.length - 2]);
		scan.close();
	}
}
