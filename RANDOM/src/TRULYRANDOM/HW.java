package TRULYRANDOM;

public class HW
{
	public static void main(String[] args)
	{
		int count = 0;
		for (int i = 1; i <= 1000/38; i++)
			if ((i *38+1) % 35 == 0)
				System.out.println(i);
		System.out.println(count);
	}
}
