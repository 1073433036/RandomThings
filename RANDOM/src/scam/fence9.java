package scam;

import java.util.Scanner;

public class fence9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int border = 0;
		border = x2 + gcd(x1, y1) + gcd(Math.abs(x1 - x2), y1);

		System.out.println((int) (x2 * y1 / 2.0 + 1 - border / 2.0));
		scan.close();
	}

	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}

		return gcd(b % a, a);
	}
}
