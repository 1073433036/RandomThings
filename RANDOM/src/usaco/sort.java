
// package usaco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class sort
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] A = new int[num];
		TreeSet<Integer> B = new TreeSet<>();
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer(f.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B.add(A[i]);
		}

		for (int i = 0; i < num; i++)
			A[i] = B.
		int max = 0;
		for (int i = 0; i < num; i++)
			max = Math.max(max, i - A[i]);

		out.println(max + 1);
		out.close();
		f.close();
	}
}