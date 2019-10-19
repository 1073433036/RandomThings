
//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Cow_Photography_2011DecBronze2 {
	private static int[][] cowLocs;

	private static class comparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			int counter = 0;
			for (int i = 0; i < 5; i++) {
				if (cowLocs[i][a] < cowLocs[i][b]) {
					counter++;
				}
			}
			return counter >= 3 ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCows = Integer.parseInt(st.nextToken());
		cowLocs = new int[5][numCows + 1];
		Integer[] cows = new Integer[numCows];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < numCows; j++) {
				st = new StringTokenizer(f.readLine());
				cowLocs[i][Integer.parseInt(st.nextToken())] = j;
				cows[j] = j + 1;
			}
		}

		Arrays.sort(cows, new comparator());

		// in at least 4/5 cases, number is at most 1 away from correct place
		// in at least 3/5 cases, number is at most 1 away from correct neighbor
		// in at most 1 case, number is more than 1 away from correct place
		// in at least 3/5 cases, left neighbor is to left of correct neighbor

		for (int i = 0; i < numCows; i++) {
			out.println(cows[i]);
		}
		out.close();
		f.close();
	}
}
