package scam;

import java.util.Arrays;
import java.util.Stack;

public class nextgreater {
	public static void main(String[] args) {
		int[] input = { 1, 2, -3, 1, 7, -2, -3, 3, 6 };
		int[] nexts = new int[input.length];
		Stack<Integer> indices = new Stack<>();
		indices.add(0);
		for (int i = 1; i < input.length; i++) {
			int cur = input[i];
			if (cur <= input[indices.peek()]) {
				indices.add(i);
			}
			else {
				while (indices.size() > 0 && cur > input[indices.peek()]) {
					nexts[indices.pop()] = cur;
				}
				indices.add(i);
			}
		}

		for (Integer ind : indices) {
			nexts[ind] = Integer.MAX_VALUE;
		}
		System.out.println(Arrays.toString(nexts));
	}
}
