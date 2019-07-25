package scam;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maxpaircombo {
	private static class pair implements Comparable<pair> {
		int a;
		int b;
		int total;

		public pair(int a, int b, int t) {
			this.a = a;
			this.b = b;
			total = t;
		}

		public int compareTo(pair o) {
			return o.total - this.total;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Integer[] A = new Integer[size];
		Integer[] B = new Integer[size];
		int min = 0;
		for (int i = 0; i < size; i++) {
			A[i] = scan.nextInt();
			min = Math.min(min, A[i]);
		}
		for (int i = 0; i < size; i++) {
			B[i] = scan.nextInt();
			min = Math.min(min, B[i]);
		}

		for (int i = 0; i < size; i++) {
			A[i] -= min;
			B[i] -= min;
		}

		Arrays.sort(A, Collections.reverseOrder());
		Arrays.sort(B, Collections.reverseOrder());

		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.add(new pair(0, 0, A[0] + B[0]));
		HashSet<Long> visited = new HashSet<>();
		int sizedec = size;
		while (sizedec > 0) {
			int a = pq.peek().a;
			int b = pq.peek().b;
			int total = pq.poll().total;
			if (visited.contains(a * 1000000l + b)) {
				continue;
			}
			visited.add(a * 1000000l + b);

			System.out.print(total + min * 2 + " ");
			sizedec--;
			if (a + 1 < size && !visited.contains((a + 1) * 1000000l + b)) {
				pq.add(new pair(a + 1, b, A[a + 1] + B[b]));
			}
			if (b + 1 < size && !visited.contains(a * 1000000l + b + 1)) {
				pq.add(new pair(a, b + 1, A[a] + B[b + 1]));
			}
		}

		scan.close();
	}
}
