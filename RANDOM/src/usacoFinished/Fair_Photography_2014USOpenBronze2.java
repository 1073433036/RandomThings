
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class Fair_Photography_2014USOpenBronze2 {
	private static class Cow implements Comparable<Cow> {
		boolean breed;
		int loc;

		public Cow(int loc, boolean breed) {
			this.breed = breed;
			this.loc = loc;
		}

		@Override
		public int compareTo(Cow o) {
			return loc - o.loc;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("fairphoto.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		Cow[] cows = new Cow[Integer.parseInt(st.nextToken())];
		int numH = 0;
		for (int i = 0; i < cows.length; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), st.nextToken().equals("G"));
			if (!cows[i].breed) {
				numH++;
			}
		}

		Arrays.sort(cows);

		int[] preSum = new int[cows.length + 1];
		preSum[0] = 0;
		for (int i = 0; i < cows.length; i++) {
			preSum[i + 1] = preSum[i] + (cows[i].breed ? 1 : -1);
		}

		int[] firstPos = new int[cows.length + numH + 1];
		for (int i = 0; i < firstPos.length; i++) {
			firstPos[i] = -1;
		}

		int size = 0;
		firstPos[numH] = 0;
		for (int i = 1; i <= cows.length; i++) {
			if (firstPos[preSum[i] + numH] == -1) {
				firstPos[preSum[i] + numH] = i;
			}
			else {
				size = Math.max(size, cows[i - 1].loc - cows[firstPos[preSum[i] + numH]].loc);
			}
		}

		for (int i = 0; i < cows.length; i++) {
			int numSame = 0;
			while (i + numSame < cows.length && cows[i].breed == cows[i + numSame].breed) {
				numSame++;
			}
			size = Math.max(size, cows[i + numSame - 1].loc - cows[i].loc);
			i += numSame - 1;
		}

		out.println(size);

		out.close();
		f.close();
	}
}
