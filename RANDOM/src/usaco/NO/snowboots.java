package usaco.NO;
/*
 * ID: justkim
 * LANG: JAVA
 * TASK: snowboots
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// package usaco;
import java.util.StringTokenizer;

public class snowboots
{
	static int[] tiles;
	static int tileMax = 0;
	static int[][] boots;
	static int bootMax = 0;

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numTiles = Integer.parseInt(st.nextToken()), numBoots = Integer.parseInt(st.nextToken());
		tiles = new int[numTiles];
		// int[] tiles = new int[numTiles];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numTiles; i++)
			tiles[i] = Integer.parseInt(st.nextToken());

		boots = new int[2][numBoots];
		// int[][] boots = new int[2][numBoots];
		for (int i = 0; i < numBoots; i++)
		{
			st = new StringTokenizer(f.readLine());
			boots[0][i] = Integer.parseInt(st.nextToken());
			boots[1][i] = Integer.parseInt(st.nextToken());
		}

		out.println(solve(0, 0));
		// out.println(solve(tiles, boots, 0, 0));
		out.close();
		f.close();
	}

	public static int solve(int discard, int current)
	// public static int solve(int[] tiles, int[][] boots, int discard, int
	// current)
	{
		if (current == tiles.length - 1)
			return discard;

		int min = boots[1].length;
		for (int i = discard; i < min; i++)
			if (boots[0][i] >= tiles[current])
				if (current + boots[1][i] >= tiles.length - 1)
					min = i;
				else
					for (int j = boots[1][i]; j > 0; j--)
						if (boots[0][i] >= tiles[current + j])
						{
							int temp = solve(i, current + j);
							// int temp=solve(tiles,boots,discard,current+j);
							if (temp < min)
								min = temp;
						}
		return min;
	}
}
