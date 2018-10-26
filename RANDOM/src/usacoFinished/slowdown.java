//package usacoFinished;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class slowdown {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("slowdown.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int eventNums = Integer.parseInt(st.nextToken());
		ArrayList<Integer> distEvents = new ArrayList<>();
		ArrayList<Integer> timeEvents = new ArrayList<>();
		for (int i = 0; i < eventNums; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.nextToken().equals("T")) {
				timeEvents.add(Integer.parseInt(st.nextToken()));
			}
			else {
				distEvents.add(Integer.parseInt(st.nextToken()));
			}
		}

		Collections.sort(distEvents);
		Collections.sort(timeEvents);
		double time = 0;
		double dist = 0;
		int dENum = 0;
		int tENum = 0;
		for (int i = 0; dENum < distEvents.size() && tENum < timeEvents.size(); i++) {
			double tDEvent = time + (distEvents.get(dENum) - dist) * (dENum + tENum + 1);
			if (tDEvent < timeEvents.get(tENum)) {
				dist = distEvents.get(dENum);
				time = tDEvent;
				dENum++;
			}
			else {
				dist += (timeEvents.get(tENum) - time) / (dENum + tENum + 1);
				time = timeEvents.get(tENum);
				tENum++;
			}
		}
		if (dENum < distEvents.size()) {
			for (int i = dENum; i < distEvents.size(); i++) {
				time += (distEvents.get(dENum) - dist) * (dENum + tENum + 1);
				dist = distEvents.get(dENum);
				dENum++;
			}
		}
		if (tENum < timeEvents.size()) {
			for (int i = tENum; i < timeEvents.size(); i++) {
				dist += (timeEvents.get(tENum) - time) / (dENum + tENum + 1);
				time = timeEvents.get(tENum);
				tENum++;
			}
		}
		if (dist < 1000) {
			time += (1000 - dist) * (dENum + tENum + 1);
		}

		out.println((int) Math.round(time));
		out.close();
		f.close();
	}
}
