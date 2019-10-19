
//package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;


public class Escaping_The_Farm_2011DecBronze3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("escape.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("escape.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCows = Integer.parseInt(st.nextToken());
		int[] cows = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		for (int i = 0; i < Math.pow(2, numCows); i++) {
			int count = 0;
			boolean works = true;
			String total = "0";
			for (int j = 0; j < numCows; j++) {
				if ((i >> j & 1) == 1) {
					String curcow = "" + cows[j];
					int cd = curcow.length() - 1;
					int td = total.length() - 1;
					while (cd >= 0 && td >= 0) {
						if (total.charAt(td) - 48 + curcow.charAt(cd) - 48 >= 10) {
							works = false;
							break;
						}
						cd--;
						td--;
					}
					count++;
					total = "" + (Integer.parseInt(total) + cows[j]);
					if (!works) {
						break;
					}
				}
			}
			if (works) {
				max = Math.max(max, count);
			}
		}

		out.println(max);
		out.close();
		f.close();
	}
}
