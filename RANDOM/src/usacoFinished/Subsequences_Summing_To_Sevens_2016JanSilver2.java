
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Subsequences_Summing_To_Sevens_2016JanSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("div7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numCows = Integer.parseInt(st.nextToken());

		int[] firsts = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			firsts[i] = -1;
		}
		int total = 0;
		int max = 0;
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			total += Integer.parseInt(st.nextToken()) % 7;
			total %= 7;
			if (firsts[total] == -1) {
				firsts[total] = i;
			}
			else {
				max = Math.max(max, i - firsts[total]);
			}
		}

		out.println(max);
		out.close();
		f.close();
	}
}
