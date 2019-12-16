package scam;

import java.util.LinkedList;

public class maxofKelements {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1, 6, 2, 7, 5, 6 };

		int n = 9;
		int k = 3;
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && a[deque.getFirst()] <= a[i]) {
				deque.removeFirst();
			}
			deque.addFirst(i);
		}

		for (int i = k; i < n; i++) {
			System.out.print(a[deque.getLast()] + " ");
			while (!deque.isEmpty() && a[deque.getFirst()] <= a[i]) {
				deque.removeFirst();
			}
			if (!deque.isEmpty() && i - deque.getFirst() > k) {
				deque.removeFirst();
			}
			deque.addFirst(i);
		}

		System.out.println(a[deque.getLast()]);
	}
}
