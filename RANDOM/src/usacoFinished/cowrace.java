// package usacoFinished;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class cowrace
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowrace.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowrace.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int bess = Integer.parseInt(st.nextToken());
		int el = Integer.parseInt(st.nextToken());

		ArrayList<Integer> bdistance = new ArrayList<>();
		ArrayList<Integer> btime = new ArrayList<>();
		for (int i = 0; i < bess; i++)
		{
			st = new StringTokenizer(f.readLine());
			bdistance.add(Integer.parseInt(st.nextToken()));
			btime.add(Integer.parseInt(st.nextToken()));
		}

		ArrayList<Integer> edistance = new ArrayList<>();
		ArrayList<Integer> etime = new ArrayList<>();
		for (int i = 0; i < el; i++)
		{
			st = new StringTokenizer(f.readLine());
			edistance.add(Integer.parseInt(st.nextToken()));
			etime.add(Integer.parseInt(st.nextToken()));
		}

		int distahead = 0;
		int count = 0;
		boolean first = true;
		while (!bdistance.isEmpty() && !edistance.isEmpty())
		{
			int et = etime.get(0);
			int ed = edistance.get(0);
			int bt = btime.get(0);
			int bd = bdistance.get(0);

			btime.remove(0);
			bdistance.remove(0);
			etime.remove(0);
			edistance.remove(0);

			if (et > bt)
			{
				etime.add(0, et - bt);
				edistance.add(0, ed);
				int before = distahead;
				distahead += bt * ed - bt * bd;
				if (!first && (distahead < 0 && before >= 0 || distahead > 0 && before <= 0))
					count++;
			}

			else if (et < bt)
			{
				btime.add(0, bt - et);
				bdistance.add(0, bd);
				int before = distahead;
				distahead += et * ed - et * bd;
				if (!first && (distahead < 0 && before >= 0 || distahead > 0 && before <= 0))
					count++;
			}

			else
			{
				int before = distahead;
				distahead += et * ed - bt * bd;
				if (!first && (distahead < 0 && before >= 0 || distahead > 0 && before <= 0))
					count++;
			}
			first = false;
		}

		out.println(count);
		out.close();
		f.close();
	}
}
