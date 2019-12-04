package scam;

import java.util.Stack;

public class largestrectareainhistogram {
	public static void main(String[] args) {
		int[] heights = { 0, 7, 3, 5, 10, 4, 2 };

		int maxArea = 0;
		Stack<Integer> s = new Stack<>();
		s.add(0);
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] >= heights[s.peek()]) {
				s.add(i);
			}
			else {
				while (heights[i] < heights[s.peek()]) {
					int j = s.pop();
					int area = (i - s.peek() - 1) * heights[j];
					maxArea = Math.max(maxArea, area);
				}
				s.add(i);
			}
		}

		int top = s.peek();
		while (s.size() > 1) {
			int area = (top - s.peek() + 1) * heights[s.peek()];
			maxArea = Math.max(maxArea, area);
			s.pop();
		}

		System.out.println(maxArea);
	}
}
// 7 3 5 10 4 2