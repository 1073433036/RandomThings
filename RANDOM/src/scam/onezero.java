package scam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class onezero
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int digits = scan.nextInt();

		String[] result = writeAll(digits);
		ArrayList<String> answer=new ArrayList<>();
		for (int i = 0; i < result.length; i++)
			if (zeros(result[i]))
				answer.add(result[i]);

		Collections.sort(answer);
		for(int i=0;i<answer.size();i++)
			System.out.println(answer.get(i));
		System.out.println(answer.size());
		
		scan.close();
	}

	public static boolean zeros(String num)
	{
		String[] split = num.split("");
		int count = 0;
		for (int i = 0; i < split.length; i++)
			if (split[i].equals("0"))
				count++;
		return count < split.length / 2;
	}

	public static String[] writeAll(int n)
	{
		if (n == 1)
		{
			String[] temp =
				{ "1", "0" };
			return temp;
		}

		String[] next = writeAll(n - 1);
		String[] result = new String[next.length * 2];
		int count = 0;
		for (int j = 0; j < result.length; j += 2)
		{
			result[j] = 0 + next[count];
			result[j + 1] = 1 + next[count];
			count++;
		}

		return result;
	}
}
