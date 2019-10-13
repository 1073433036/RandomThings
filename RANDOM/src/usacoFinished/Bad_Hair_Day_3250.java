
// package usacoFinished;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> seen = new Stack<Integer>();
		int numCows = scan.nextInt();
		long[] cowHeights = new long[numCows + 1];
		for (int i = 0; i < numCows; i++) {
			cowHeights[i] = scan.nextLong();
		}
		cowHeights[numCows] = 0x3f3f3f3f;
		long total = 0;
		for (int i = 0; i <= numCows; i++) {
			while (!seen.isEmpty() && cowHeights[seen.peek()] <= cowHeights[i]) {
				total += i - seen.pop() - 1;
			}
			seen.push(i);
		}

		System.out.println(total);
		scan.close();
	}
}
