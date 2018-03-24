package usaco.NO;
/*
 ID: emilyk1
 LANG: JAVA
 TASK: beads
 */

import java.io.*;          // put tester in file into usaco not bin/src the
					          // folder with bin/src in it
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class beads
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		f.readLine();
		StringTokenizer st = new StringTokenizer(f.readLine());
		String necklace = st.nextToken();
		necklace = necklace + necklace + necklace;
		String[] splitNecklace = necklace.split("");
		int max = 0;
		for (int i = 0; i < splitNecklace.length - necklace.length() / 3; i++)
		{
			String startColor = splitNecklace[i];
			if (startColor.equals("w"))
				continue;
			int j, switched = 0;
			for (j = 1; i + j < splitNecklace.length && switched < 2; j++)
				if (!(splitNecklace[i + j].equals(startColor) || splitNecklace[i + j].equals("w")))
				{
					switched++;
					startColor = splitNecklace[i + j];
				}
			max = max > j ? max : j;
			if (max > necklace.length() / 3)
			{
				max = necklace.length() / 3;
				break;
			}
		}
		if (max == 0)
			max = necklace.length() / 3;
		out.println(max);
		out.close();
		f.close();
	}
}