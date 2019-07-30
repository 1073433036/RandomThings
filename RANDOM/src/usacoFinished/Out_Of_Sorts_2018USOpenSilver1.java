
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class Out_Of_Sorts_2018USOpenSilver1 {
	private static class Pair implements Comparable<Pair> {
		int index;
		int val;

		public Pair(int i, int v) {
			index = i;
			val = v;
		}

		public int compareTo(Pair o) {
			if (val == o.val) {
				return index - o.index;
			}
			return val - o.val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int num = Integer.parseInt(st.nextToken());
		Pair[] nums = new Pair[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(f.readLine());
			nums[i] = new Pair(i, Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(nums);

		int max = 0;
		for (int i = 0; i < num; i++) {
			max = Math.max(max, nums[i].index - i);
		}
		out.println(max + 1);
		out.close();
		f.close();
	}
}
