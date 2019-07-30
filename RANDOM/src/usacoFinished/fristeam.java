package usacoFinished;

import java.util.Scanner;

public class fristeam {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int divisBy = scan.nextInt();
		int[] cows = new int[numCows + 1];
		for (int i = 1; i <= numCows; i++) {
			cows[i] = scan.nextInt() % divisBy;
		}

		long[][] count = new long[numCows + 1][divisBy];
		// count[i][j]= count of subset of i cows with sum%f=c
		// count[i][j]=count[i-1][j]+count[i-1][(j-cowi)%f]
		count[0][0] = 1;
		for (int i = 1; i <= numCows; i++) {
			for (int j = 0; j < divisBy; j++) {
				count[i][j] = count[i - 1][j] + count[i - 1][(j + divisBy - cows[i]) % divisBy];

				count[i][j] %= 100000000;
			}
		}

		System.out.println((count[numCows][0] - 1) % 100000000);
		scan.close();
	}
}
