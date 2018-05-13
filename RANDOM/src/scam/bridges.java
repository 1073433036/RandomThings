package scam;

import java.util.Arrays;
import java.util.Scanner;

class city implements Comparable<city>
{
	int x, y;

	public city(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int compareTo(city b)
	{
		return x - b.x;
	}

}

public class bridges
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		city[] cities = new city[num];

		for (int i = 0; i < num; i++)
			cities[i] = new city(scan.nextInt(), scan.nextInt());
		Arrays.sort(cities);
		int[] lis = new int[num];
		lis[0] = 1;
		int total = 0;
		for (int i = 1; i < num; i++)
		{
			int max = 0;
			for (int j = 0; j < i; j++)
				if (max < lis[j] && cities[j].y < cities[i].y)
					max = lis[j];
			lis[i] = max + 1;
			if (total < lis[i])
				total = lis[i];
		}

		System.out.println(total);
		scan.close();
	}
}
