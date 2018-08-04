//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cowdance
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numcows = Integer.parseInt(st.nextToken());
		int maxTime = Integer.parseInt(st.nextToken());
		int[] cows = new int[numcows];
		for (int i = 0; i < numcows; i++)
		{
			st = new StringTokenizer(f.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}

		int max = numcows - 1, min = 1;
		while (min != max)
		{
			int mid = (max + min) / 2;
			if (possible(cows, mid, maxTime))
				max = mid;
			else
				min = mid + 1;
		}

		out.println(min);
		out.close();
		f.close();
	}

	public static boolean possible(int[] cows, int size, int maxTime)
	{
		int last = 0;
		PriorityQueue<Integer> stage = new PriorityQueue<>();
		for (int i = 0; i < cows.length; i++)
		{
			if (stage.size() == size)
				last = stage.poll();
			if (last + cows[i] > maxTime)
				return false;
			stage.add(last + cows[i]);
		}
		return true;
	}
}
