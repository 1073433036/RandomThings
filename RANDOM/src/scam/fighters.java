package scam;

import java.util.PriorityQueue;
import java.util.Scanner;

public class fighters {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner scan = new Scanner(System.in);

		int size=scan.nextInt();
		for (int i = 0; i < size; i++) {
			pq.add(scan.nextInt());
		}

		int total = 0;
		while (pq.size() > 1) {
			int match = pq.poll() + pq.poll();
			pq.add(match);
			total += match;
		}
		System.out.println(total);
		scan.close();
	}
}
