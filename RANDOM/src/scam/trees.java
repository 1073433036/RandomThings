package scam;

import java.util.Scanner;

public class trees {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numTrees = scan.nextInt();
		int[] trees = new int[numTrees];
		for (int i = 0; i < numTrees; i++) {
			trees[i] = scan.nextInt();
		}

		int[] flis = new int[numTrees];
		for (int i = 0; i < numTrees; i++) {
			flis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (trees[j] < trees[i]) {
					flis[i] = Math.max(flis[i], flis[j] + 1);
				}
			}
		}

		int[] blis = new int[numTrees];
		for (int i = numTrees - 1; i >= 0; i--) {
			blis[i] = 1;
			for (int j = numTrees - 1; j > i; j--) {
				if (trees[j] < trees[i]) {
					blis[i] = Math.max(blis[i], blis[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < numTrees; i++) {
			max = Math.max(max, flis[i] + blis[i] - 1);
		}

		System.out.println(max);
		scan.close();
	}
}
