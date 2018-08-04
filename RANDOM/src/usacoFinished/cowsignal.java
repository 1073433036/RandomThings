
// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowsignal
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String[] startsignal = new String[m];
		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(f.readLine());
			startsignal[i] = st.nextToken();
		}

		String[] endsignal = new String[m * k];
		int linenum = 0;
		for (int i = 0; i < m; i++)
		{
			String line = "";
			for (int j = 0; j < n; j++)
				for (int asdf = 0; asdf < k; asdf++)
					line += startsignal[i].substring(j, j + 1);
			for (int j = 0; j < k; j++)
			{
				endsignal[linenum] = line;
				linenum++;
			}
		}

		for (int i = 0; i < m * k; i++)
			out.println(endsignal[i]);
		out.close();
	}
}