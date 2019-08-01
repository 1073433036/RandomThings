package scam;

import java.util.Scanner;

public class banner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int width = scan.nextInt();
		int height = scan.nextInt();
		int minlength = scan.nextInt();
		int maxlength = scan.nextInt();
		long total = 0;
		for (int i = 1; i <= width; i++) {
			for (int j = 1; j <= height; j++) {
				double length = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
				if (length >= minlength && length <= maxlength && gcd(i, j) == 1) {
					total += (width + 1 - i) * (height + 1 - j) * 2;
				}
			}
		}
		if (minlength == 1) {
			total += (height + 1) * width + (width + 1) * height;
		}

		System.out.println(total);
		scan.close();
	}

	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}

		return gcd(b % a, a);
	}
}
