package scam;

import java.util.Scanner;

public class tribonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long a = 0;
		long b = 0;
		long c = 1;
		for (int i = 1; i < n; i++) {
			long temp = c;
			c += a + b;
			a = b;
			b = temp;
		}

		System.out.println(a);
		scan.close();
	}
}
