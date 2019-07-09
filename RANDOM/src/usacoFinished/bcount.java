
// package usacoFinished;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[][] cows = new int[n + 1][3];
		cows[0][0] = 0;
		cows[0][1] = 0;
		cows[0][2] = 0;
		for (int i = 1; i < cows.length; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i][0] = cows[i - 1][0];
			cows[i][1] = cows[i - 1][1];
			cows[i][2] = cows[i - 1][2];
			cows[i][Integer.parseInt(st.nextToken()) - 1]++;
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(f.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			out.print(cows[end][0] - cows[begin - 1][0] + " ");
			out.print(cows[end][1] - cows[begin - 1][1] + " ");
			out.println(cows[end][2] - cows[begin - 1][2]);

		}

		out.close();
		f.close();
	}
}
