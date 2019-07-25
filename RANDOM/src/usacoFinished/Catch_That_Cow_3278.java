
// package usacoFinished;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int farmerpos = scan.nextInt();
		int cowpos = scan.nextInt();
		int[] times = new int[200001];
		for (int i = 0; i < times.length; i++) {
			times[i] = Math.abs(farmerpos - i);
		}
		for (int i = 0; i < times.length / 2; i++) {
			times[i] = Math.min(times[i], Math.min(i != 0 ? times[i - 1] : 1000000000, times[i + 1]) + 1);
			times[i * 2] = Math.min(times[i * 2], times[i] + 1);
		}

		System.out.println(times[cowpos]);
		scan.close();
	}
}
