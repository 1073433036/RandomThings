package usaco.NO;
/*
 * ID: justkim
 * LANG: JAVA
 * TASK:
 */

// package usaco;

import java.io.*;          // put tester in file into usaco not bin/src the
					          // folder with bin/src in it
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

class weight implements Comparable<weight>
{
	private int w;
	private int pos;

	public weight(int weig, int ps)
	{
		w = weig;
		pos = ps;
	}

	public int getWeight()
	{
		return w;
	}

	public void setWeight(int weig)
	{
		w = weig;
	}

	public int getPos()
	{
		return pos;
	}

	public void setPos(int weig)
	{
		pos = weig;
	}

	public int compareTo(weight o)
	{
		if (w % 10 > o.getWeight() % 10)
			return -1;
		if (w % 10 < o.getWeight() % 10)
			return 1;
		return 0;
	}

}

public class escape
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("escape.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("escape.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		ArrayList<weight> weights = new ArrayList<weight>();
		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			weights.add(new weight(Integer.parseInt(st.nextToken()), i));
		}

		Collections.sort(weights);

		out.println(check(weights, n));
		out.close();
		f.close();
	}

	public static int check(ArrayList<weight> weights, int answer)
	{
		weight[] a = new weight[weights.size()];
		int b = 0;
		for (int i = 0; i < weights.size(); i++)
		{
			weights.set(i, new weight((int) (weights.get(i).getWeight() / 10), i));
			if (weights.get(i).getWeight() == 0)
			{
				weights.remove(i);
				b++;
				continue;
			}
			a[i].setWeight(weights.get(i - b).getWeight() % 10);
			a[i].setPos(i - b);
		}
		if (weights.size() == 0)
			return answer;
		Arrays.sort(a);
		int sum = 0;
		for (int i = 0; i < answer; i++)
		{
			sum += a[i].getWeight();
			if (sum > 9)
			{
				answer--;
				weights.set(i, new weight(0, i));
			}
		}
		return check(weights, answer);
	}
}