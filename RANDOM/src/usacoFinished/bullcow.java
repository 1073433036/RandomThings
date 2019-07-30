package usacoFinished;

import java.util.Scanner;

public class bullcow {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCattle = scan.nextInt();
		int space = scan.nextInt();
		long[] count = new long[numCattle + 1];
		count[0] = 1;
		for (int i = 1; i <= numCattle; i++) {
			if (i - space - 1 < 0) {
				count[i] = 1 + count[i - 1];
			}
			else {
				count[i] = count[i - space - 1] + count[i - 1];
			}
			count[i] %= 5000011;
		}

		System.out.println(count[numCattle] % 5000011);

		scan.close();
	}
}
