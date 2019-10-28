package Math;

import java.math.BigInteger;
import java.util.BitSet;

public class BinaryOps {
	public static void main(String[] args) {
		int a = 6;
		int b = 9;
		System.out.println(a ^ b);// 15
		System.out.println(a | b);// 15
		System.out.println(a & b);// 0
		System.out.println(a >> 1);// 3
		System.out.println(a << 1);// 12
		System.out.println((a ^ (a - 1)) == 0);// false
		BitSet c = BitSet.valueOf(new long[] { a });
		System.out.println(c);// {1,2}
		System.out.println(c.cardinality());// 2
		System.out.println(Integer.parseInt("1001", 2));// 9
		BigInteger d = new BigInteger("123419230401293401293041234");
		System.out.println(d.toString(2));
		int n = 4;
		int[] arr = new int[] { 1, 2, 3, 4 };
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if (((i >> j) & 1) == 1) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
