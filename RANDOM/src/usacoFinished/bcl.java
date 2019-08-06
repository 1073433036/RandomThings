package usacoFinished;

import java.util.Scanner;

public class bcl {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		char[] cows = new char[numCows];
		for (int i = 0; i < numCows; i++) {
			cows[i] = scan.next().charAt(0);
		}

		String result = "";
		int i = 0;
		int j = numCows - 1;
		while (i < j) {
			if (cows[i] < cows[j]) {
				result += cows[i];
				i++;
			}
			else if (cows[j] < cows[i]) {
				result += cows[j];
				j--;
			}
			else {
				int tryi = i;
				int tryj = j;
				while (tryi < tryj && cows[tryi] == cows[tryj]) {
					tryi++;
					tryj--;
				}
				if (cows[tryi] < cows[tryj]) {
					result += cows[i];
					i++;
				}
				else {
					result += cows[j];
					j--;
				}
			}
		}

		result += cows[i];

		int count = 0;
		while (count < numCows) {
			System.out.print(result.charAt(count));
			count++;
			if (count % 80 == 0) {
				System.out.println();
			}
		}

		scan.close();
	}
}
