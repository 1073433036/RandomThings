//package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class moosick
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("moosick.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moosick.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int notecount = Integer.parseInt(st.nextToken());
		int[] notes = new int[notecount];
		for (int i = 0; i < notecount; i++)
		{
			st = new StringTokenizer(f.readLine());
			notes[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(f.readLine());
		int seventh = Integer.parseInt(st.nextToken());
		int[] chord = new int[seventh];
		for (int i = 0; i < seventh; i++)
		{
			st = new StringTokenizer(f.readLine());
			chord[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(chord);

		ArrayList<Integer> count = new ArrayList<>();
		for (int i = 0; i < notecount - seventh + 1; i++)
		{
			int[] current = new int[seventh];
			for (int j = 0; j < seventh; j++)
				current[j] = notes[i + j];

			Arrays.sort(current);

			int same = current[0] - chord[0];
			boolean flag = true;
			for (int j = 1; j < seventh; j++)
				if (same != current[j] - chord[j])
				{
					flag = false;
					break;
				}
			if (flag)
				count.add(i + 1);
		}

		out.println(count.size());
		for (int i = 0; i < count.size(); i++)
			out.println(count.get(i));

		out.close();
		f.close();
	}
}
