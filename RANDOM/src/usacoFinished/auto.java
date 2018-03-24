// package usacoFinished;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class word implements Comparable<word>
{
	public String word;
	public int pos;

	public word(String word, int pos)
	{
		this.word = word;
		this.pos = pos;
	}

	public int compareTo(word o)
	{
		return this.word.compareTo(o.word);
	}

	public boolean equals(Object o)
	{
		return this.word.equals(((word) o).word);
	}

}

public class auto
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("auto.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		ArrayList<word> dictionary = new ArrayList<>();
		for (int i = 0; i < w; i++)
		{
			st = new StringTokenizer(f.readLine());
			dictionary.add(new word(st.nextToken(), i));
		}

		Collections.sort(dictionary);

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			int pos = Integer.parseInt(st.nextToken()) - 1;
			String target = st.nextToken();
			int low = 0, high = w, mid = w / 2;
			boolean did = false;
			while (low + 1 < high)
			{
				if (dictionary.get(mid).word.startsWith(target))
				{
					if (dictionary.get(mid - 1).word.startsWith(target))
						while (low + 1 < high)
							if (dictionary.get(mid - 1).word.startsWith(target))
							{
								high = mid;
								mid = (high + low) / 2;
							}
							else if (dictionary.get(mid).word.startsWith(target))
								break;
							else
							{
								low = mid;
								mid = (high + low) / 2;
							}
					if (dictionary.size() > mid + pos && dictionary.get(mid + pos).word.startsWith(target))
					{
						out.println(dictionary.get(mid + pos).pos + 1);
						did = true;
						break;
					}
					out.println(-1);
					did = true;
					break;
				}
				else if (dictionary.get(mid).word.compareTo(target) > 0)
				{
					high = mid;
					mid = (high + low) / 2;
				}
				else
				{
					low = mid;
					mid = (high + low) / 2;
				}
			}
			if (!did)
				out.println(-1);
		}

		out.close();
		f.close();
	}
}
