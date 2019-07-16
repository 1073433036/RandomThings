package MATHISNOTMETH;

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
		System.out.println(c.cardinality());//2
		System.out.println(Integer.parseInt("1001",2));//9
	}
}
