package scam;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class cowxor {
	private static class cow implements Comparable<cow> {
		public int ind;
		public int prefix;

		public cow(int ind, int px) {
			this.ind = ind;
			this.prefix = px;
		}

		public int compareTo(cow other) {
			if (prefix == 0 || other.prefix == 0) {
				return other.prefix - prefix;
			}
			int thislen = (int) Math.ceil(Math.log(prefix) / Math.log(2));
			int otherlen = (int) Math.ceil(Math.log(other.prefix) / Math.log(2));
			return otherlen - thislen;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long time = System.currentTimeMillis();
		int numCows = scan.nextInt();
		// prefix xor
		// check every pair
		// optimize
		int[] cows = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			cows[i] = scan.nextInt();
		}

		cow[] xorprefix = new cow[numCows + 1];
		xorprefix[0] = new cow(0, 0);
		for (int i = 1; i <= numCows; i++) {
			xorprefix[i] = new cow(i, xorprefix[i - 1].prefix ^ cows[i - 1]);
		}

		for (int i = 0; i < numCows + 1; i++) {
			System.out.println(xorprefix[i].prefix + " " + xorprefix[i].ind);
		}
		System.out.println();
		Arrays.sort(xorprefix);
		for (int i = 0; i < numCows + 1; i++) {
			System.out.println(xorprefix[i].prefix + " " + xorprefix[i].ind);
		}
		System.out.println();

		int maxLength = (int) Math.ceil(Math.log(xorprefix[0].prefix) / Math.log(2));
		int max = 0;
		int first = 0;
		int last = 0;
		for (int i = 0; i <= numCows; i++) {
			for (int j = i + 1; j <= numCows; j++) {
				int curr = xorprefix[j].prefix ^ xorprefix[i].prefix;
				if (curr > max) {
					max = curr;
					first = i + 1;
					last = j;
				}
				else if (curr == max) {
					if (last > j) {
						first = i + 1;
						last = j;
					}
					else if (last == j) {
						if (last - first > j - i) {
							first = i + 1;
							last = j;
						}
					}
				}
			}
		}

		System.out.println(max + " " + first + " " + last);

		System.out.println(System.currentTimeMillis() - time);
		scan.close();
	}
}
