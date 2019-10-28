package Math;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Scanner;

public class BinaryAddition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		BigInteger a = new BigInteger(scan.next(), 2);
//		BigInteger b = new BigInteger(scan.next(), 2);
//
//		BigInteger sum = a.add(b);
//		BitSet bs = BitSet.valueOf(new long[] { sum.longValue() });

		int n = 4;
		int[] arr = new int[] { 1, 2, 3, 4 };
		for (int i = 0; i < 1 << n; i++) {
			BigInteger subset = new BigInteger("" + i);
			for(int j=0;j<n;j++) {
				if(subset.testBit(j)) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
//
//		System.out.println(sum.toString(2));
		scan.close();
	}
}
