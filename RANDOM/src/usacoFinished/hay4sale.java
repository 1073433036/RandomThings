package usacoFinished;

import java.util.Scanner;

public class hay4sale {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int capacity = scan.nextInt();
		int numBales = scan.nextInt();
		int[] bales = new int[numBales + 1];
		for (int i = 1; i <= numBales; i++) {
			bales[i] = scan.nextInt();
		}

		int[][] sums = new int[2][capacity + 1];
		// sums[i][j]= maximum volume given i bales and j capacity
		// sums[i][j]=max(sums[i-1][j],sums[i][j-volumei]+volumei)
		for (int i = 1; i <= numBales; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (j - bales[i] >= 0) {
					sums[i % 2][j] = sums[i % 2][j - bales[i]] + bales[i];
				}
				sums[i % 2][j] = Math.max(sums[i % 2][j], sums[(i - 1) % 2][j]);
			}
		}

		System.out.println(sums[numBales % 2][capacity]);

		scan.close();
	}
}
