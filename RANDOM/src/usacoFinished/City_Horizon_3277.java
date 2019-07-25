package usacoFinished;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	private static class building implements Comparable<building> {
		long pos;
		long height;
		boolean start;

		public building(int p, int h, boolean s) {
			pos = p;
			height = h;
			start = s;
		}

		public int compareTo(building other) {
			if (this.pos > other.pos) {
				return 1;
			}
			if (this.pos < other.pos) {
				return -1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numBuildings = scan.nextInt();
		building[] buildings = new building[numBuildings * 2];
		for (int i = 0; i < numBuildings; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			int h = scan.nextInt();
			buildings[2 * i] = new building(s, h, true);
			buildings[2 * i + 1] = new building(e, h, false);
		}

		Arrays.sort(buildings);

		TreeMap<Long, Integer> heights = new TreeMap<Long, Integer>(Collections.reverseOrder());
		heights.put(0l, 1);
		long total = 0;
		long prevpos = buildings[0].pos;
		heights.put(buildings[0].height, 1);
		for (int i = 1; i < buildings.length; i++) {
			total += (buildings[i].pos - prevpos) * heights.firstKey();
			prevpos = buildings[i].pos;

			if (buildings[i].start) {
				if (heights.containsKey(buildings[i].height)) {
					heights.put(buildings[i].height, heights.get(buildings[i].height) + 1);
				}
				else {
					heights.put(buildings[i].height, 1);
				}
			}
			else {
				heights.put(buildings[i].height, heights.get(buildings[i].height) - 1);
				if (heights.get(buildings[i].height) == 0) {
					heights.remove(buildings[i].height);
				}
			}
		}

		System.out.println(total);
		scan.close();
	}
}