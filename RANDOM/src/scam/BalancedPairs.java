package scam;

import java.util.ArrayList;
import java.util.Scanner;

public class BalancedPairs
{
	private static ArrayList<ArrayList<Integer>> nexts = new ArrayList<>();
	private static int result = 0;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int numnodes = scan.nextInt();
		for (int i = 0; i < numnodes; i++)
			nexts.add(new ArrayList<>());
		for (int i = 1; i < numnodes; i++)
		{
			int connection = scan.nextInt() - 1;
			nexts.get(connection).add(i);
		}
		boolean[] open = new boolean[numnodes];
		for (int i = 0; i < numnodes; i++)
			open[i] = scan.next().equals("(") ? true : false;

		dfs(0, 0, open, false);
		int splits = 0;
		for (int i = 0; i < nexts.size(); i++)
			if (nexts.get(i).size() > 1)
				splits += nexts.get(i).size() - 1;
		System.out.println(result + splits + 1);

		scan.close();
	}

	public static void dfs(int count, int curr, boolean[] open, boolean used)
	{
		if (count < 0)
			return;
		if (count + (open[curr] ? 1 : -1) == 0 && used)
			result++;
		ArrayList<Integer> nextVals = nexts.get(curr);
		if (nextVals.size() == 0)
			return;

		for (int i = 0; i < nextVals.size(); i++)
		{
			if (!used)
				dfs(count, nextVals.get(i), open, used);
			dfs(count + (open[curr] ? 1 : -1), nextVals.get(i), open, true);
		}
	}
}
