package scam;

import java.util.Arrays;
import java.util.Scanner;

public class stamps
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int maxstamps = scan.nextInt();
		int[] stamptypes = new int[scan.nextInt()];
		int maxtype = 0;
		for (int i = 0; i < stamptypes.length; i++)
		{
			stamptypes[i] = scan.nextInt();
			if (stamptypes[i] > maxtype)
				maxtype = stamptypes[i];
		}
		Arrays.sort(stamptypes);
		if (stamptypes[0] != 1)
		{
			System.out.println(0);
			scan.close();
			return;
		}
		boolean[] sum = new boolean[maxstamps * maxtype];
		int max = -1;
		int absmax = maxtype;

		for (int i = 1; i <= maxstamps; i++)
		{
			for (int j = 0; j < stamptypes.length; j++)
			{
				for (int k = max; k <= absmax; k++)
				{
					if (!sum[k + stamptypes[j]])
					{
						sum[k + stamptypes[j]] = true;
						if (sum[max + 1])
							max++;
						if (k + stamptypes[j] > absmax)
							absmax = k + stamptypes[j];
					}
				}
			}
		}

		System.out.println(max + 1);
		scan.close();
	}
}
