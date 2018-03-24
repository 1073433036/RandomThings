package usaco.NO;
/*
 * ID: justkim
 * LANG: JAVA
 * TASK: teleport
 */

// package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class teleport
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int pilenum = Integer.parseInt(st.nextToken());
		int[][] piles = new int[2][pilenum];
		long min = 0;
		for (int i = 0; i < pilenum; i++)
		{
			st = new StringTokenizer(f.readLine());
			piles[0][i] = Integer.parseInt(st.nextToken());
			piles[1][i] = Integer.parseInt(st.nextToken());
			min += Math.abs(piles[1][i] - piles[0][i]);
		}

		for (int possEnd : piles[1])
		{
			long tempmin = 0;
			for (int i = 0; i < piles[0].length; i++)
			{
				if (tempmin > min)
					break;
				if (Math.abs(piles[0][i]) + Math.abs(piles[1][i] - possEnd) < Math.abs(piles[1][i] - piles[0][i]))
					tempmin += Math.abs(piles[0][i]) + Math.abs(piles[1][i] - possEnd);
				else
					tempmin += Math.abs(piles[1][i] - piles[0][i]);
			}
			if (tempmin < min)
				min = tempmin;
		}

		out.println(min);
		out.close();
		f.close();
	}
}
