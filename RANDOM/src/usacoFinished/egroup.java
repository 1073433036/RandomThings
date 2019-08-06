package usacoFinished;

import java.util.Scanner;

public class egroup {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int[] cows = new int[numCows];
		int[] cows1 = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			cows[i] = cows1[numCows - i - 1] = scan.nextInt();
		}

		int[] lis = new int[numCows];
		int[] lis1 = new int[numCows];
		// lis[i] is min value where lis ending at lis[i] is length i+1
		for (int i = 0; i < numCows; i++) {
			lis[i] = lis1[i] = Integer.MAX_VALUE;
		}

		int max = 0;
		for (int i = 0; i < numCows; i++) {
			int cur = cows[i];
			int ind = binarysearch(lis, cur);
			lis[ind] = Math.min(lis[ind], cur);
			max = Math.max(max, ind);
		}

		for (int i = 0; i < numCows; i++) {
			int cur = cows1[i];
			int ind = binarysearch(lis1, cur);
			lis1[ind] = Math.min(lis1[ind], cur);
			max = Math.max(max, ind);
		}

		System.out.println(numCows - (max + 1));

		scan.close();
	}

	public static int binarysearch(int[] list, int target) {
		int left = 0;
		int right = list.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (list[mid] > target) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return left;
	}
}
