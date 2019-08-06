package usacoFinished;

import java.util.Arrays;
import java.util.Scanner;

public class sgraze {
	private static class cow implements Comparable<cow> {
		int start;
		int end;

		public cow(int s, int e) {
			start = s;
			end = e;
		}

		public int compareTo(cow other) {
			return end - other.end;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		cow[] cows = new cow[numCows];
		for (int i = 0; i < numCows; i++) {
			cows[i] = new cow(scan.nextInt(), scan.nextInt());
		}

		Arrays.sort(cows);

		int ending=0;
		int count=0;
		for (int i = 0; i < numCows; i++) {
			if(cows[i].start>=ending) {
				count++;
				ending=cows[i].end;
			}
		}

		System.out.println(count);

		scan.close();
	}
}
