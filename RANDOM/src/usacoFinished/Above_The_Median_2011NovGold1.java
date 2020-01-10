
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Above_The_Median_2011NovGold1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("median.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("median.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCows = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		long total = (long) numCows * (numCows + 1) / 2;
		int[] ps = new int[numCows * 2];
		int sum = numCows;
		ps[sum] = 1;
		int count = 0;

		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			if (Integer.parseInt(st.nextToken()) >= target) {
				count -= ps[++sum];
			}
			else {
				count += ps[sum--];
			}
			ps[sum]++;
			total -= count;
		}

		out.println(total);
		out.close();
		f.close();
	}
}
