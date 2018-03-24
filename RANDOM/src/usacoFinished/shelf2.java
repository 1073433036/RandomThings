//package usacoFinished;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int cows = scan.nextInt(), height = scan.nextInt();
		int[] set = new int[cows];
		int total = 0;
		for (int i = 0; i < cows; i++)
		{
			set[i] = scan.nextInt();
			if (total < height)
				total += set[i];
		}

		System.out.println(minimum(set, height, total - height, 0, 0));

		scan.close();
	}

	public static int minimum(int[] set, int height, int currmin, int total, int count)
	{
		if (total - height > currmin)
			return 0x3f3f3f3f;
		if (total - height >= 0 && total - height <= currmin)
			return total - height;
		if (count >= set.length)
			return total - height > 0 ? total - height : 0x3f3f3f3f;

		int nouse = minimum(set, height, currmin, total, count + 1);
		int use = minimum(set, height, currmin, total + set[count], count + 1);
		return use > nouse ? nouse : use;
	}
}
