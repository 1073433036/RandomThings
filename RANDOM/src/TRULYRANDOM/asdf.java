package TRULYRANDOM;

import java.util.LinkedHashSet;

public class asdf
{
	public static void main(String[] args)
	{
		int[] a =
			{ 1, 23, 3, 5, 6, 3, 13, 5 };

		LinkedHashSet<Integer> noCopies = new LinkedHashSet<>();
		for (int i = 0; i < a.length; i++)
			noCopies.add(a[i]);

		int[] b = new int[noCopies.size()];
		int i = 0;
		for (Integer noDup : noCopies)
		{
			b[i++] = noDup;
		}

		for (int j = 0; j < b.length; j++)
			System.out.println(b[j]);
	}
}
