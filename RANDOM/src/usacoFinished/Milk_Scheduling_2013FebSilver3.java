
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

public class Milk_Scheduling_2013FebSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("msched.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msched.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCows = Integer.parseInt(st.nextToken());
		int numConstraints = Integer.parseInt(st.nextToken());
		int[] times = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			times[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<ArrayList<Integer>> cowMilkedBefore = new ArrayList<>(numCows);

		for (int i = 0; i < numCows; i++) {
			cowMilkedBefore.add(new ArrayList<>());
		}

		for (int i = 0; i < numConstraints; i++) {
			st = new StringTokenizer(f.readLine());
			cowMilkedBefore.get(Integer.parseInt(st.nextToken()) - 1).add(Integer.parseInt(st.nextToken()) - 1);
		}

		int[] indegrees = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			for (int j = 0; j < cowMilkedBefore.get(i).size(); j++) {
				indegrees[cowMilkedBefore.get(i).get(j)]++;
			}
		}

		int[] chtimes = new int[numCows];
		LinkedList<Integer> cowsReady = new LinkedList<>();
		for (int i = 0; i < numCows; i++) {
			if (indegrees[i] == 0) {
				cowsReady.add(i);
				chtimes[i] = times[i];
			}
		}

		int maxTime = 0;
		while (!cowsReady.isEmpty()) {
			int cow = cowsReady.poll();
			maxTime = Math.max(maxTime, chtimes[cow]);
			for (int i = 0; i < cowMilkedBefore.get(cow).size(); i++) {
				int ncow = cowMilkedBefore.get(cow).get(i);
				if (--indegrees[ncow] == 0) {
					cowsReady.add(ncow);
				}
				chtimes[ncow] = Math.max(chtimes[ncow], chtimes[cow] + times[ncow]);
			}
		}

		out.println(maxTime);
		out.close();
		f.close();
	}
}
