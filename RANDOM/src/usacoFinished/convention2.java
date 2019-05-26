//package usacoFinished;
 import java.util.StringTokenizer;
 import java.io.BufferedReader;
 import java.io.PrintWriter;
 import java.io.BufferedWriter;
 import java.io.FileReader;
 import java.io.FileWriter;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class convention2 {
	private static class Cow implements Comparable<Cow> {
		int arrival;
		int time;
		int seniority;

		public Cow(int a, int t, int s) {
			arrival = a;
			time = t;
			seniority = s;
		}

		public int compareTo(Cow o) {
			if (arrival == o.arrival) {
				return seniority - o.seniority;
			}
			return arrival - o.arrival;
		}
	}

	private static class Waiter implements Comparator<Cow> {

		public int compare(Cow o1, Cow o2) {
			return o1.seniority - o2.seniority;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		PriorityQueue<Cow> arriving = new PriorityQueue<>();
		PriorityQueue<Cow> waiting = new PriorityQueue<>(new Waiter());

		int cows = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cows; i++) {
			st = new StringTokenizer(f.readLine());
			arriving.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}
		
		int finisht=-1;
		int maxTime=0;
		while(!(arriving.isEmpty()&&waiting.isEmpty())) {
			while(!arriving.isEmpty()&&finisht>arriving.peek().arrival) {
				waiting.add(arriving.poll());
			}
			if(waiting.isEmpty()&&!arriving.isEmpty()) {
				finisht=arriving.peek().arrival+arriving.poll().time;
			}
			if(!waiting.isEmpty()) {
				Cow c=waiting.poll();
				maxTime=Math.max(maxTime, finisht-c.arrival);
				finisht+=c.time;
			}
		}

		out.println(maxTime);
		out.close();
		f.close();
	}
}
