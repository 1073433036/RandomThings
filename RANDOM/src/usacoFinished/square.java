// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class square
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("square.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int rx11 = Integer.parseInt(st.nextToken());
		int ry11 = Integer.parseInt(st.nextToken());
		int rx12 = Integer.parseInt(st.nextToken());
		int ry12 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.readLine());
		int rx21 = Integer.parseInt(st.nextToken());
		int ry21 = Integer.parseInt(st.nextToken());
		int rx22 = Integer.parseInt(st.nextToken());
		int ry22 = Integer.parseInt(st.nextToken());

		int[] rxs =
			{ rx11, rx12, rx21, rx22 };

		int maxx = 0;
		for (int i = 0; i < 4; i++)
			if (rxs[i] > maxx)
				maxx = rxs[i];

		int minx = 100;
		for (int i = 0; i < 4; i++)
			if (rxs[i] < minx)
				minx = rxs[i];

		int[] rys =
			{ ry11, ry12, ry21, ry22 };

		int maxy = 0;
		for (int i = 0; i < 4; i++)
			if (rys[i] > maxy)
				maxy = rys[i];

		int miny = 100;
		for (int i = 0; i < 4; i++)
			if (rys[i] < miny)
				miny = rys[i];

		if (maxx - minx >= maxy - miny)
			out.println((maxx - minx) * (maxx - minx));
		else
			out.println((maxy - miny) * (maxy - miny));

		out.close();
		f.close();
	}
}