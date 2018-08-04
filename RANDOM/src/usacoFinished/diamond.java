// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class countDiamond implements Comparable<countDiamond>
{
	public int size;
	public int count;

	public countDiamond(int size, int count)
	{
		this.size = size;
		this.count = count;
	}

	public int compareTo(countDiamond o)
	{
		if (this.size > o.size)
			return 1;
		if (this.size < o.size)
			return -1;
		return 0;
	}

	public boolean equals(Object diamond)
	{
		return this.size == ((countDiamond) diamond).size;
	}

}

public class diamond
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<countDiamond> diamonds = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			int current = Integer.parseInt(st.nextToken());
			int pos = diamonds.indexOf(new countDiamond(current, 1));
			if (pos >= 0)
				diamonds.set(pos, new countDiamond(current, diamonds.get(pos).count + 1));
			else
				diamonds.add(new countDiamond(current, 1));
		}

		Collections.sort(diamonds);

		int max = 0;
		for (int i = 0; i < diamonds.size(); i++)
		{
			int count = 0;
			int j = i;
			int current = diamonds.get(j).size;
			do
			{
				count += diamonds.get(j).count;
				j++;
				if (j < diamonds.size())
					current = diamonds.get(j).size;
				else
					current = 0x3f3f3f3f;
			}
			while (current <= diamonds.get(i).size + k);

			if (max < count)
				max = count;
		}

		out.println(max);
		out.close();
		f.close();
	}
}
