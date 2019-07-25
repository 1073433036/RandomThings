
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.TreeMap;

public class Painting_The_Fence_2013JanSilver1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("paint.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numInstructions = Integer.parseInt(st.nextToken());
		int minCoats = Integer.parseInt(st.nextToken());
		TreeMap<Long, Integer> events = new TreeMap<>();
		long curpos = 0;
		for (int i = 0; i < numInstructions; i++) {
			st = new StringTokenizer(f.readLine());
			int dist = Integer.parseInt(st.nextToken());
			if (st.nextToken().equals("R")) {
				if (events.containsKey(curpos)) {
					events.put(curpos, events.get(curpos) + 1);
				}
				else {
					events.put(curpos, 1);
				}
				if (events.containsKey(curpos + dist)) {
					events.put(curpos + dist, events.get(curpos + dist) - 1);
				}
				else {
					events.put(curpos + dist, -1);
				}
				curpos += dist;
			}
			else {
				if (events.containsKey(curpos)) {
					events.put(curpos, events.get(curpos) - 1);
				}
				else {
					events.put(curpos, -1);
				}
				if (events.containsKey(curpos - dist)) {
					events.put(curpos - dist, events.get(curpos - dist) + 1);
				}
				else {
					events.put(curpos - dist, 1);
				}
				curpos -= dist;
			}
		}
		long total = 0;
		long prevpos = 1000000001;
		int currCoats = 0;
		for (long pos : events.keySet()) {
			if (prevpos == 10000000001l) {
				prevpos = pos;
				currCoats = events.get(pos);
				continue;
			}
			if (currCoats >= minCoats) {
				total += pos - prevpos;
			}
			currCoats += events.get(pos);
			prevpos = pos;
		}
		out.println(total);
		out.close();
		f.close();
	}
}
