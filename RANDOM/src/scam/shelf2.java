package scam;

import java.util.Scanner;

public class shelf2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int height = scan.nextInt();
		int[] cows = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			cows[i] = scan.nextInt();
		}

		int[] heights = allCombos(cows, 0);
		int res = 0x3f3f3f3f;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] >= height) {
				res = Math.min(res, heights[i] - height);
			}
		}

		System.out.println(res);
		scan.close();
	}

	public static int[] allCombos(int[] cows, int pos) {
		if (pos == cows.length - 1) {
			return new int[] { cows[pos], 0 };
		}
		int[] heights = new int[(int) Math.pow(2, cows.length - pos)];
		int[] next = allCombos(cows, pos + 1);
		for (int i = 0; i < heights.length / 2; i++) {
			heights[i] = next[i] + cows[pos];
			heights[i + heights.length / 2] = next[i];
		}

		return heights;
	}
}
