package scam;

import java.util.Scanner;

public class profits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numDays = scan.nextInt();
		int[] profits = new int[numDays];
		for (int i = 0; i < numDays; i++) {
			profits[i] = scan.nextInt();
		}

		int total = 0;
		int max = -100000000;
		for (int i = 0; i < numDays; i++) {
			total += profits[i];
			max = Math.max(total, max);
			if (total < 0) {
				total = 0;
			}
		}

		System.out.println(max);
		scan.close();
	}
}
