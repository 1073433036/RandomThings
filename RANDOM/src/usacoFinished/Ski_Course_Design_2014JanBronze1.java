
// package usacoFinished;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Ski_Course_Design_2014JanBronze1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int[] hills = new int[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < hills.length; i++) {
			st = new StringTokenizer(f.readLine());
			hills[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(hills);
		int min = 10000000;
		for (int i = 0; i < 100; i++) {
			int less = 0;
			int more = 0;
			for (int j = 0; j < hills.length; j++) {
				if (hills[j] < i) {
					if (hills[j] < i - 17) {
						less += Math.pow(i - 17 - hills[j], 2);
					}
					more += Math.pow(i - hills[j], 2);
				}
				else {
					if (hills[j] > i + 17) {
						more += Math.pow(hills[j] - 17 - i, 2);
					}
					less += Math.pow(hills[j] - i, 2);
				}
			}
			min = Math.min(min, Math.min(less, more));
		}
		out.println(min);
		out.close();
		f.close();
	}
}
