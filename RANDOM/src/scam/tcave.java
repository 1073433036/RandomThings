package scam;

import java.util.Scanner;

public class tcave
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int pass = scan.nextInt();
		int[] passages = new int[pass + 1];
		int split = scan.nextInt();
		int treasure = scan.nextInt();
		for (int i = 0; i < split; i++)
		{
			int s = scan.nextInt();
			passages[scan.nextInt()] = s;
			passages[scan.nextInt()] = s;
		}
		int curr = treasure;
		String path = "";
		int steps = 0;
		while (true)
		{
			path = curr + "\n" + path;
			steps++;
			if (curr == 1)
				break;
			curr = passages[curr];
		}
		System.out.println(steps + "\n" + path);
		scan.close();
	}
}
