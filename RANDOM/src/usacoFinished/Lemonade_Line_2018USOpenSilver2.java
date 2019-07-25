
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class Lemonade_Line_2018USOpenSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int cows = Integer.parseInt(st.nextToken());
		long[] cowswait = new long[cows];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < cows; i++)
			cowswait[i] = Long.parseLong(st.nextToken());

		Arrays.sort(cowswait);
		int count = 0;
		for (int i = cows - 1; i >= 0; i--) {
			if (cowswait[i] >= count)
				count++;
			else
				break;
		}
		out.println(count);
		out.close();
		f.close();
	}
}
