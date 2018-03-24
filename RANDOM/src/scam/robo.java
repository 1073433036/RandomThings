package scam;

import java.util.ArrayList;
import java.util.Scanner;

public class robo
{
	private static ArrayList<Integer> storage = new ArrayList<>();

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int count = 1;

		int seq = scan.nextInt();
		for (int i = 0; i < seq; i++)
		{
			boolean add = scan.next().equals("ADD") ? true : false;
			if (add)
			{
				storage.add(count);
				count++;
			}
			else
				storage.remove(storage.size() - 1);
		}

		System.out.println(storage.size());
		for (int i = 0; i < storage.size(); i++)
			System.out.println(storage.get(i));

		scan.close();
	}

}
