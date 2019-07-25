
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Party_Invitations_2013JanSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("invite.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("invite.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numCows = Integer.parseInt(st.nextToken());
		int numGroups = Integer.parseInt(st.nextToken());
		ArrayList<TreeSet<Integer>> belongsToGroup = new ArrayList<>(numCows);
		ArrayList<TreeSet<Integer>> groups = new ArrayList<>(numGroups);
		for (int i = 0; i < numCows; i++) {
			belongsToGroup.add(new TreeSet<Integer>());
		}

		for (int i = 0; i < numGroups; i++) {
			st = new StringTokenizer(f.readLine());
			int numCowInGroup = Integer.parseInt(st.nextToken());
			TreeSet<Integer> group = new TreeSet<>();
			for (int j = 0; j < numCowInGroup; j++) {
				int cow = Integer.parseInt(st.nextToken()) - 1;
				group.add(cow);
				belongsToGroup.get(cow).add(i);
			}
			groups.add(group);
		}

		LinkedList<Integer> cows = new LinkedList<>();
		cows.add(0);
		HashSet<Integer> uniqueCows = new HashSet<>();
		while (!cows.isEmpty()) {
			int cur = cows.poll();
			uniqueCows.add(cur);
			TreeSet<Integer> add = new TreeSet<>();
			for (int groupNum : belongsToGroup.get(cur)) {
				groups.get(groupNum).remove(cur);
				if (groups.get(groupNum).size() == 1) {
					add.addAll(groups.get(groupNum));
					groups.get(groupNum).clear();
				}
			}
			cows.addAll(add);
		}
		out.println(uniqueCows.size());
		out.close();
		f.close();
	}
}
