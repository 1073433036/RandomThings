// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class A_Pie_for_a_Pie_2017DecGold1 {
	private static class pair implements Comparable<pair> {
		int value;
		int index;

		public pair(int val, int i) {
			value = val;
			index = i;
		}

		public int compareTo(pair other) {
			if (value == other.value) {
				return index - other.index;
			}
			return value - other.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("piepie.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("piepie.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		// reverse bfs from 0 pies
		// find next node:
		// use two treesets
		// use other treeset to binary search and iterate
		// until equal to the prev node value

		int numPies = Integer.parseInt(st.nextToken());
		int maxDiff = Integer.parseInt(st.nextToken());
		int[] brate = new int[numPies * 2];
		int[] erate = new int[numPies * 2];
		TreeSet<pair> piesB = new TreeSet<>();
		TreeSet<pair> piesE = new TreeSet<>();
		int[] distances = new int[numPies * 2];

		for (int i = 0; i < numPies * 2; i++) {
			st = new StringTokenizer(f.readLine());
			brate[i] = Integer.parseInt(st.nextToken());
			erate[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer> bfs = new LinkedList<>();
		for (int i = 0; i < numPies * 2; i++) {
			if (i >= numPies) {
				if (brate[i] == 0) {
					bfs.add(i);
					distances[i] = 1;
				}
				else {
					piesE.add(new pair(brate[i], i));
					distances[i] = -1;
				}
			}
			else {
				if (erate[i] == 0) {
					bfs.add(i);
					distances[i] = 1;
				}
				else {
					piesB.add(new pair(erate[i], i));
					distances[i] = -1;
				}
			}
		}
		// System.out.println(Arrays.toString(brate));
		// System.out.println(Arrays.toString(erate));
		// for (pair p : piesB) {
		// System.out.println(p.value + " " + p.index);
		// }
		// for (pair p : piesE) {
		// System.out.println(p.value + " " + p.index);
		// }

		while (!bfs.isEmpty()) {
			int curr = bfs.poll();
			if (curr >= numPies) {
				Iterator<pair> it = piesB.subSet(new pair(erate[curr] - maxDiff, -1), new pair(erate[curr] + 1, -1))
						.iterator();
				while (it.hasNext()) {
					pair next = it.next();
					distances[next.index] = distances[curr] + 1;
					bfs.add(next.index);
					// System.out.println("\t" + next.value + " " + next.index);
					it.remove();
				}
			}
			else {
				Iterator<pair> it = piesE.subSet(new pair(brate[curr] - maxDiff, -1), new pair(brate[curr] + 1, -1))
						.iterator();
				while (it.hasNext()) {
					pair next = it.next();
					distances[next.index] = distances[curr] + 1;
					bfs.add(next.index);
					// System.out.println("\t" + next.value + " " + next.index);
					it.remove();
				}
			}
			// System.out.println(Arrays.toString(distances));
			// for (pair p : piesB) {
			// System.out.println(p.value + " " + p.index);
			// }
			// System.out.println();
			// for (pair p : piesE) {
			// System.out.println(p.value + " " + p.index);
			// }
		}

		// int[] output = new int[numPies];
		// for (int i = 0; i < numPies; i++) {
		// st = new StringTokenizer(f.readLine());
		// output[i] = Integer.parseInt(st.nextToken());
		// }
		for (int i = 0; i < numPies; i++) {
			out.println(distances[i]);
		}

		// boolean broken = false;
		// for (int i = 0; i < numPies; i++) {
		// if (output[i] != (distances[i] == Integer.MAX_VALUE ? -1 :
		// distances[i])) {
		// System.out.println(output[i] + " " + distances[i]);
		// broken = true;
		// }
		// }
		//
		// System.out.println(broken);
		// System.out.println(Arrays.toString(distances));

		out.close();
		f.close();
	}
}
