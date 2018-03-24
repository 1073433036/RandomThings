// package usacoFinished;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class ctiming
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("ctiming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctiming.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int d = Integer.parseInt(st.nextToken()) - 11;
		int h = Integer.parseInt(st.nextToken()) - 11;
		int m = Integer.parseInt(st.nextToken()) - 11;

		if (d < 0 || h < 0 || m < 0)
			out.println(-1);
		else
			out.println(d * 24 * 60 + h * 60 + m);

		out.close();
		f.close();
	}
}
