package usacoFinished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class pathfind {
	private static class state {
		int loc;
		int time;

		public state(int l, int t) {
			loc = l;
			time = t;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numIslands = scan.nextInt();
		int startLoc = scan.nextInt() - 1;
		boolean[][] canTravel = new boolean[numIslands][numIslands];
		for (int i = 0; i < numIslands; i++) {
			for (int j = 0; j < numIslands; j++) {
				canTravel[i][j] = scan.nextInt() == 1;
			}
		}

		LinkedList<state> islandsLeft = new LinkedList<>();
		System.out.println(startLoc + 1);
		int time = 0;
		HashMap<Integer, Boolean> visited = new HashMap<>();
		islandsLeft.add(new state(startLoc, time));
		ArrayList<TreeSet<Integer>> output = new ArrayList<>();
		output.add(new TreeSet<Integer>());
		visited.put(startLoc, false);
		while (!islandsLeft.isEmpty()) {
			int loc = islandsLeft.peek().loc;
			int newtime = islandsLeft.poll().time;
			if (visited.get(loc)) {
				continue;
			}
			visited.put(loc, true);
			if (time != newtime) {
				time = newtime;
				output.add(new TreeSet<Integer>());
			}
			for (int i = 0; i < numIslands; i++) {
				if (canTravel[loc][i] && !visited.containsKey(i)) {
					islandsLeft.add(new state(i, time + 1));
					output.get(time).add(i);
					visited.put(i, false);
				}
			}
		}

		for (int i = 0; i < output.size(); i++) {
			for (int island : output.get(i)) {
				System.out.print((island + 1) + " ");
			}
			System.out.println();
		}

		scan.close();
	}
}
