package scam;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numInts = scan.nextInt();
		int[] list = new int[numInts];

		int[] lis = new int[numInts];
		int max = 0;
		for (int i = 0; i < numInts; i++) {
			lis[i] = 1;
			list[i] = scan.nextInt();
			for (int j = 0; j < i; j++) {
				if (list[j] < list[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			max = Math.max(max, lis[i]);
		}

		System.out.println(max);
		scan.close();
	}
}
