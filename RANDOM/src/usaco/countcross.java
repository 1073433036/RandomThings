package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class countcross
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		int cows = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		boolean[][][] canMove = new boolean[size][size][4];
		for (int i = 0; i < roads; i++)
		{
			st = new StringTokenizer(f.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1, c1 = Integer.parseInt(st.nextToken())-1,
					r2 = Integer.parseInt(st.nextToken())-1, c2 = Integer.parseInt(st.nextToken())-1;
			if(c2>c1)
			{
				canMove[r1][c1]
			}
				
		}
		out.println();
		out.close();
		f.close();
	}
}
