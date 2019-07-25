
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Sleepy_Cow_Sorting_2019JanBronze2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int[] cows = new int[Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < cows.length; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}

		int i = cows.length - 1;
		while (i > 0 && cows[i] > cows[i - 1]) {
			i--;
		}

		out.println(i);
		out.close();
		f.close();
	}
}
