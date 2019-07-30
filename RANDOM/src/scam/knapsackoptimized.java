package scam;

import java.util.Scanner;

public class knapsackoptimized {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numItems = scan.nextInt();
		int capacity = scan.nextInt();

		// only if no repeats
		int[] sums = new int[capacity + 1];
		// sums[j]=max value for j capacity given i items
		// sums[j]=max(sums[j],sums[j-si]+vi)
		for (int i = 1; i <= numItems; i++) {
			int si = scan.nextInt();
			int vi = scan.nextInt();
			for (int j = capacity; j >= si; j--) {
				sums[j] = Math.max(sums[j], sums[j - si] + vi);
			}
		}

		System.out.println(sums[capacity]);
		scan.close();
	}
}
