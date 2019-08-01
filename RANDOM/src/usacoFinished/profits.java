package usacoFinished;

import java.util.Scanner;

public class profits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numDays = scan.nextInt();
		int profits = 0;
		int max = -10001;
		for (int i = 0; i < numDays; i++) {
			int day = scan.nextInt();
			if (day >= 0) {
				if (profits < 0) {
					profits = 0;
				}
			}
			profits += day;
			max = Math.max(max, Math.max(profits, day));
		}

		System.out.println(max);
		scan.close();
	}
}
