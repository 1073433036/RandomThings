
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Closing_The_Farm_2016USOpenGold2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("closing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Closing the farm
		// Build up the farm
		// Start with last one
		// Add all farms connected to that one in a set
		// If it is within another set, combine both sets
		// If not within any set, create new set with all connections

		int numFarms = Integer.parseInt(st.nextToken());
		int numConns = Integer.parseInt(st.nextToken());
		ArrayList<TreeSet<Integer>> connections = new ArrayList<>();
		for (int i = 0; i < numFarms; i++) {
			connections.add(new TreeSet<Integer>());
		}

		for (int i = 0; i < numConns; i++) {
			st = new StringTokenizer(f.readLine());
			int farm1 = Integer.parseInt(st.nextToken()) - 1;
			int farm2 = Integer.parseInt(st.nextToken()) - 1;
			connections.get(farm1).add(farm2);
			connections.get(farm2).add(farm1);
		}
		int[] removelist = new int[numFarms];
		for (int i = 0; i < numFarms; i++) {
			st = new StringTokenizer(f.readLine());
			removelist[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		ArrayList<TreeSet<Integer>> farm = new ArrayList<>();
		boolean[] result = new boolean[numFarms];
		farm.add(new TreeSet<Integer>());
		farm.get(0).addAll(connections.get(removelist[numFarms - 1]));
		result[numFarms - 1] = true;
		for (int i = numFarms - 2; i >= 0; i--) {
			int startFarm = removelist[i];
			int found = -1;
			for (int j = 0; j < farm.size(); j++) {
				if (farm.get(j).contains(startFarm)) {
					if (found == -1) {
						found = j;
						farm.get(j).addAll(connections.get(startFarm));
					}
					else {
						farm.get(found).addAll(farm.get(j));
						farm.remove(j);
						j--;
					}
				}
			}
			if (found == -1) {
				TreeSet<Integer> disconnected = new TreeSet<>();
				disconnected.addAll(connections.get(startFarm));
				farm.add(disconnected);
			}
			result[i] = farm.size() == 1;
		}

		for (int i = 0; i < numFarms; i++) {
			out.println(result[i] ? "YES" : "NO");
		}

		out.close();
		f.close();
	}
}
