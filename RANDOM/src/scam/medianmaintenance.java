package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class medianmaintenance {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("median.txt"));
		StringTokenizer st;
		PriorityQueue<Integer> low = new PriorityQueue<>(10, Collections.reverseOrder());
		PriorityQueue<Integer> high = new PriorityQueue<>();
		double total = 0;
		double m = 0;
		int times = 0;
		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			// System.out.println(a);
			if (low.size() < high.size()) {
				if (a < m) {
					low.add(a);
				}
				else {
					low.add(high.poll());
					high.add(a);
				}
				m = low.peek();
			}
			else if (low.size() == high.size()) {
				if (a < m) {
					low.add(a);
					m = low.peek();
				}
				else {
					high.add(a);
					m = high.peek();
				}
			}
			else {
				if (a < m) {
					high.add(low.poll());
					low.add(a);
				}
				else {
					high.add(a);
				}
				m = low.peek();
			}
			total += m;
			total %= 10000;
			times++;
			// System.out.println(low + " " + high + " \t\t" + m);
			// if (times == 50)
			// break;
		}

		System.out.println(total);
		f.close();
	}
}
