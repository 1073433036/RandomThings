package usaco.NO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * ID: justkim
 * LANG: JAVA
 * TASK: cbarn
 */
// package usaco;

import java.util.StringTokenizer;

public class cbarn
{
	public static int counting(int[] cow)
	{
		int count = 0;
		int furthest0 = 0;
		boolean moveback = false;
		for (int i = 0; i < cow.length; i++)
		{
			if (cow[i] == 0 && !moveback)
			{
				furthest0 = i;
				moveback = true;
			}
			else if (moveback && cow[i] != 0)
			{
				count += i - furthest0;
				cow[i]--;
				i = furthest0;
				cow[furthest0] = 13;
				moveback = false;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numcows = Integer.parseInt(st.nextToken());
		int[] cows = new int[numcows];
		for (int i = 0; i < numcows; i++)
		{
			st = new StringTokenizer(f.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}

		int min = 0x3f3f3f3f;
		for (int i = 0; i < numcows; i++)
		{
			int count = counting(cows);
			if (min > count)
				min = count;
			int temp = cows[numcows - 1];
			cows[numcows - 1] = cows[0];
			cows[0] = temp;
		}

		out.println(min * min);
		out.close();
		f.close();
	}
}
