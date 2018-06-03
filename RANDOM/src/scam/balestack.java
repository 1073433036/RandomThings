package scam;

import java.util.Arrays;
import java.util.Scanner;

class bale implements Comparable<bale>
{
	int w, l;

	public bale(int w, int l)
	{
		this.w = w;
		this.l = l;
	}

	public int compareTo(bale b)
	{
		return b.w * b.l - w * l;
	}

}

public class balestack
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		bale[] bales = new bale[scan.nextInt()];

		for (int i = 0; i < bales.length; i++)
			bales[i] = new bale(scan.nextInt(), scan.nextInt());

		Arrays.sort(bales);

		int[] stackheight = new int[bales.length];
		stackheight[0] = 1;
		int total = 1;
		for (int i = 1; i < bales.length; i++)
		{
			int max = 0;
			for (int j = 0; j < i; j++)
				if (bales[i].w < bales[j].w && bales[i].l < bales[j].l)
					max = Math.max(max, stackheight[j]);
			stackheight[i] = max + 1;
			total = Math.max(total, stackheight[i]);
		}

		System.out.println(total);

		scan.close();
	}
}
