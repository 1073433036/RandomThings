package scam;

import java.util.Scanner;

public class longestincreasingsubsequenceoptimized {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numNums = scan.nextInt();
		int[] lis = new int[numNums];
		// lis[i] is min value where lis ending at lis[i] is length i+1
		for (int i = 0; i < numNums; i++) {
			lis[i] = Integer.MAX_VALUE;
		}

		int max = 0;
		for (int i = 0; i < numNums; i++) {
			int cur = scan.nextInt();
			int ind = upperbound(lis, cur);
			lis[ind] = Math.min(lis[ind], cur);
			max = Math.max(max, ind);
		}

		System.out.println(max + 1);
		scan.close();
	}

	public static int upperbound(int[] list, int target) {
		int left = 0;
		int right = list.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (list[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return left;
	}
}
