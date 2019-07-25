package scam;

import java.util.Scanner;

public class ugly {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int[] uglyNums = new int[n];
		uglyNums[0] = 1;
		for (int i = 1; i < n; i++) {
			int next2 = uglyNums[i2] * 2;
			int next3 = uglyNums[i3] * 3;
			int next5 = uglyNums[i5] * 5;
			uglyNums[i] = Math.min(next2, Math.min(next3, next5));
			if (uglyNums[i] == next2)
				i2++;
			if (uglyNums[i] == next3)
				i3++;
			if (uglyNums[i] == next5)
				i5++;
		}

		System.out.println(uglyNums[n - 1]);
		scan.close();
	}
}
