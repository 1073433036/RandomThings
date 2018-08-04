/*
 * ID: justkim
 * LANG: JAVA
 * TASK: lifeguards
 */

package usaco.NO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class lifeguard1 implements Comparable<lifeguard1>
{
	int start;
	int end;

	lifeguard1(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

	public int compareTo(lifeguard1 o)
	{
		if (this.start > o.start)
			return 1;
		if (this.start < o.start)
			return -1;
		return 0;
	}

}

public class lifeguards
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int lifecount = Integer.parseInt(st.nextToken());

		ArrayList<lifeguard1> lifeguards1 = new ArrayList<>();
		int total = 0;
		for (int i = 0; i < lifecount; i++)
		{
			st = new StringTokenizer(f.readLine());
			lifeguards1.add(new lifeguard1(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			total += lifeguards1.get(i).end - lifeguards1.get(i).start + 1;
		}

		Collections.sort(lifeguards1);

		ArrayList<Integer> overlap = new ArrayList<>();
		for (int i = 0; i < lifeguards1.size() - 1; i++)
		{
			int current = i + 1;
			int currend = lifeguards1.get(i).end;
			int checkstart = lifeguards1.get(current).start;
			int checkend = lifeguards1.get(current).end;
			while (checkstart < currend)
			{
				if (currend > checkend)
				{
					overlap.add(checkend - checkstart);
					total -= checkend - checkstart;
					lifeguards1.get(i).end = 0;
					lifeguards1.get(i).start = 0;
				}
				else
				{
					overlap.add(currend - checkstart);
					total -= currend - checkstart;
					lifeguards1.get(i).start = currend + 1;
				}
			}
		}

		Collections.sort(overlap);

		out.println(total - overlap.get(0));
		out.close();
		f.close();
	}
}
