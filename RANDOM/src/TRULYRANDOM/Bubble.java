package TRULYRANDOM;

public class Bubble
{
	public static void main(String[] args)
	{
		int[] list =
			{ 213, 23, 12, 312, 41, 2513, 62, 31231, 34, 64, 5675, 23, 12, 345676 };

		for (int i = 0; i < list.length; i++)
			for (int j = list.length-1; j > 0; j--)
				if (list[j] < list[j - 1])
				{
					int temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
				}

		for (int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
}
