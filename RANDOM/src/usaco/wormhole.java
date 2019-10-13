package usaco;

// import java.util.StringTokenizer;
// import java.io.BufferedReader;
// import java.io.PrintWriter;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class wormhole {
	private static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numHoles = Integer.parseInt(st.nextToken());
		pos[] holes = new pos[numHoles];
		for (int i = 0; i < numHoles; i++) {
			st = new StringTokenizer(f.readLine());
			holes[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] xrightconnect = new int[numHoles];
		for (int i = 0; i < numHoles; i++) {
			xrightconnect[i] = -1;
		}
		for (int i = 0; i < numHoles; i++) {
			for (int j = 0; j < numHoles; j++) {
				if (i != j && holes[i].y == holes[j].y) {
					if (holes[j].x > holes[i].x && (xrightconnect[i] == -1 || holes[xrightconnect[i]].x > holes[j].x)) {
						xrightconnect[i] = j;
					}
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numHoles; i++) {
			list.add(i);
		}

		System.out.println(Arrays.toString(xrightconnect));
		int size = (int) (factorial(numHoles, numHoles / 2) / Math.pow(2, numHoles / 2));
		allPairs = new int[size][numHoles / 2];
		makePairs(list, new int[numHoles / 2], (byte) 0);
		// connect each hole to every other hole
		// try every possibility
		// 12->11 10->9 8->7 6->5 4->3 2->1
		// find loops directed edge graph
		// wormholes are bidirectional
		// check if already visited
		// because directional edge cases dont apply
		// going right is forced directional
		// bfs from every wormhole
		// go to closest in x direction wormhole
		// visit, add wormhole pair to bfs

		int count = 0;
		for (int combo = 0; combo < size; combo++) {
			int[] wormholes = new int[numHoles];
			for (int i = 0; i < numHoles / 2; i++) {
				int c1 = allPairs[combo][i] / 100;
				int c2 = allPairs[combo][i] % 100;
				wormholes[c1] = c2;
				wormholes[c2] = c1;
			}

			LinkedList<Integer> left = new LinkedList<>();
			boolean[] visited = new boolean[numHoles];
		}

		out.println(count);
		out.close();
		f.close();
	}

	static int factorial(int x, int stop) {
		if (x == 1 || x == stop) {
			return 1;
		}
		return x * factorial(x - 1, stop);
	}

	static int[][] allPairs;
	static int count = 0;

	public static void makePairs(ArrayList<Integer> list, int[] pairs, byte numPair) {
		if (list.size() == 2) {
			pairs[numPair] = list.get(0) * 100 + list.get(1);
			allPairs[count++] = Arrays.copyOf(pairs, numPair + 1);
		}
		else {
			int choose1 = list.get(0);	// always pick first one
			list.remove(0);
			for (int i = 0; i < list.size(); i++) {
				int choose2 = list.get(i);
				list.remove(i);	// pick each of remaining
				pairs[numPair] = choose1 * 100 + choose2;
				makePairs(list, pairs, (byte) (numPair + 1));
				list.add(i, choose2);	// put back

			}
			list.add(0, choose1);	// put back
		}
	}
}
