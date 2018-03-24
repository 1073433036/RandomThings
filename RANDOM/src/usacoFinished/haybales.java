
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class haybales
{
	public static int[] haybales;

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numhaybales = Integer.parseInt(st.nextToken()), numqueries = Integer.parseInt(st.nextToken());
		haybales = new int[numhaybales];
		st = new StringTokenizer(f.readLine());
		int max = 0, min = 100000000;
		for (int i = 0; i < numhaybales; i++)
		{
			haybales[i] = Integer.parseInt(st.nextToken());
			if (haybales[i] > max)
				max = haybales[i];
			if (haybales[i] < min)
				min = haybales[i];
		}

		Arrays.sort(haybales);

		for (int i = 0; i < numqueries; i++)
		{
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start > max || end < min)
				out.println(0);
			else
				out.println(solve(start, end));
		}

		out.close();
		f.close();
	}

	public static int solve(int start, int end)
	{
		int s1 = 0, e1 = haybales.length - 1, curr1 = haybales.length / 2;
		while (!((curr1 == 0 || haybales[curr1 - 1] < start) && haybales[curr1] >= start))
		{
			if (start > haybales[curr1])
				s1 = curr1;
			else
				e1 = curr1;
			curr1 = (e1 - s1) / 2 + s1;
		}

		int s2 = 0, e2 = haybales.length - 1, curr2 = haybales.length / 2;
		while (!(haybales[curr2] <= end && (curr2 == haybales.length - 1 || haybales[curr2 + 1] > end)))
		{
			if (end < haybales[curr2])
				e2 = curr2;
			else
				s2 = curr2;
			curr2 = (e2 - s2 + 1) / 2 + s2;
		}

		return curr2 - curr1 + 1;
	}
}
