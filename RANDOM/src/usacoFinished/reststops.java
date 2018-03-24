// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class reststops
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int lengthOfTrail = Integer.parseInt(st.nextToken()), numStops = Integer.parseInt(st.nextToken()),
				speedDiff = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		int[] taste = new int[numStops];
		int[] time = new int[numStops];
		int prevStop = 0;
		for (int i = 0; i < numStops; i++)
		{
			st = new StringTokenizer(f.readLine());
			int stopDist = Integer.parseInt(st.nextToken());
			time[i] = (stopDist - prevStop) * speedDiff;
			prevStop = stopDist;
			taste[i] = Integer.parseInt(st.nextToken());
		}

		int max = taste[numStops - 1];
		long total = 0;
		long temptotal = 0;
		for (int i = numStops - 1; i >= 0; i--)
		{
			if (taste[i] > max)
			{
				total += temptotal * max;
				temptotal = 0;
				max = taste[i];
			}
			temptotal += time[i];
		}
		total += temptotal * max;
		out.println(total);
		out.close();
		f.close();
	}
}
