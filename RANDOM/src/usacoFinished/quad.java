package usacoFinished;

import java.util.Scanner;

public class quad {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();

		int[][] count = new int[length][4];
		// count[i][j]=total ways to split i+1 length into j+1 pieces
		int limit = (length - 1) / 2;
		for (int i = 0; i < limit; i++) {
			count[i][0] = 1;
		}

		for (int k = 1; k < 4; k++) {
			for (int i = k; i < length; i++) {
				for (int j = 1; j <= limit; j++) {
					if (i - j >= 0) {
						count[i][k] += count[i - j][k - 1];
					}
				}
			}
		}
		System.out.println(count[length - 1][3]);
		scan.close();
	}
}
