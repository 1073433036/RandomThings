package scam;

import java.math.BigInteger;
import java.util.Scanner;

public class Lightbulbs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// s1+s2=b1
		// s1+s2+s3=b2
		BigInteger start = new BigInteger(scan.next());
		BigInteger end = new BigInteger(scan.next());
		int maxLen = Math.max(start.bitLength(), end.bitLength());

		int min = -1;
		boolean s1, s2, s3;
		s1 = false;
		s2 = start.testBit(maxLen - 1) ^ end.testBit(maxLen - 1) ^ s1;
		s3 = s2;
		int count = (s1 ? 1 : 0) + (s2 ? 1 : 0);
		String switches0 = (s1 ? 1 : 0) + "" + (s2 ? 1 : 0);
		for (int i = maxLen - 2; i > 0; i--) {
			s3 = start.testBit(i) ^ end.testBit(i) ^ s2 ^ s1;
			switches0 += s3 ? 1 : 0;
			s1 = s2;
			s2 = s3;
			count += s3 ? 1 : 0;
		}

		if (!(start.testBit(0) ^ end.testBit(0) ^ s2 ^ s1)) {
			min = count;
		}

		s1 = true;
		s2 = start.testBit(maxLen - 1) ^ end.testBit(maxLen - 1) ^ s1;
		s3 = s2;
		count = (s1 ? 1 : 0) + (s2 ? 1 : 0);
		String switches1 = (s1 ? 1 : 0) + "" + (s2 ? 1 : 0);
		for (int i = maxLen - 2; i > 0; i--) {
			s3 = start.testBit(i) ^ end.testBit(i) ^ s2 ^ s1;
			switches1 += s3 ? 1 : 0;
			s1 = s2;
			s2 = s3;
			count += s3 ? 1 : 0;
		}

		BigInteger ans0 = new BigInteger(switches0, 2);
		BigInteger ans1 = new BigInteger(switches1, 2);
		if (!(start.testBit(0) ^ end.testBit(0) ^ s2 ^ s1)) {
			if (min == -1 || min > count) {
				System.out.println(ans1);
			}
			else {
				if (min == count) {
					System.out.println(ans0.compareTo(ans1) == -1 ? ans0 : ans1);
				}
				else {
					System.out.println(ans0);
				}
			}
			scan.close();
			return;
		}
		else {
			if (min != -1) {
				System.out.println(ans0);
				scan.close();
				return;
			}
		}
		System.out.println("impossible");

		scan.close();
	}
}
