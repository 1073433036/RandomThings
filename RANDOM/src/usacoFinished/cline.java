package usacoFinished;

import java.util.Scanner;

public class cline {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numQueries = scan.nextInt();
		int[] line = new int[200001];
		int l = 100000, r = 100001;
		int cowNum = 1;
		for (int i = 0; i < numQueries; i++) {
			if (scan.next().equals("A")) {
				if (scan.next().equals("L")) {
					line[l--] = cowNum++;
				}
				else {
					line[r++] = cowNum++;
				}
			}
			else {
				if (scan.next().equals("L")) {
					l += scan.nextInt();
				}
				else {
					r -= scan.nextInt();
				}
			}
		}

		for (int i = l + 1; i < r; i++) {
			System.out.println(line[i]);
		}

		scan.close();
	}
}
