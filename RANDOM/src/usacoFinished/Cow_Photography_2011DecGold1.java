
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Cow_Photography_2011DecGold1 {
	private static int numCows;
	private static HashMap<Integer, ArrayList<Integer>> cows;

	private static class comparator implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			int counter = 0;
			for (int i = 0; i < 5; i++) {
				int xpos = cows.get(x).get(i);
				int ypos = cows.get(y).get(i);

				if (xpos < ypos) {
					counter++;
				}
			}
			return counter > 2 ? -1 : 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		// after each photo, cows are rearranged
		// in a group of 2 cows, each cow can either move at most 1 or 2 times,
		// depending on if same group
		// if a cow is to the left of another cow in 3 photos, then to left

		numCows = Integer.parseInt(st.nextToken());
		cows = new HashMap<>();
		Integer[] res = new Integer[numCows];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < numCows; j++) {
				st = new StringTokenizer(f.readLine());
				int cow = Integer.parseInt(st.nextToken());
				if (i == 0) {
					cows.put(cow, new ArrayList<Integer>());
					res[j] = cow;
				}
				cows.get(cow).add(j);
			}
		}

		Arrays.sort(res, new comparator());

		for (int i = 0; i < numCows; i++) {
			out.println(res[i]);
		}

		out.close();
		f.close();
	}
}