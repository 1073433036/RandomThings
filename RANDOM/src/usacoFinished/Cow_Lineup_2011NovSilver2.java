package usacoFinished;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Scanner;

public class Cow_Lineup_2011NovSilver2 {
	private static class cow implements Comparable<cow> {
		long pos;
		long id;

		public cow(int p, int i) {
			pos = p;
			id = i;
		}

		public int compareTo(cow other) {
			if (this.pos > other.pos) {
				return 1;
			}
			if (this.pos < other.pos) {
				return -1;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		cow[] cows = new cow[numCows];
		HashSet<Long> ids = new HashSet<>();
		for (int i = 0; i < numCows; i++) {
			cows[i] = new cow(scan.nextInt(), scan.nextInt());
			ids.add(cows[i].id);
		}
		int numIds = ids.size();

		Arrays.sort(cows);

		TreeMap<Long, Integer> counts = new TreeMap<>();
		int left = 0;
		int right = 0;
		long min = Long.MAX_VALUE;
		while (right < numCows) {
			while (right < numCows && counts.size() < numIds) {
				if (counts.containsKey(cows[right].id)) {
					counts.put(cows[right].id, counts.get(cows[right].id) + 1);
				}
				else {
					counts.put(cows[right].id, 1);
				}
				right++;
			}// valid
			if (counts.size() == numIds) {
				right--;
			}
			while (left < right && counts.size() == numIds) {
				min = Math.min(min, cows[right].pos - cows[left].pos);
				counts.put(cows[left].id, counts.get(cows[left].id) - 1);
				if (counts.get(cows[left].id) == 0) {
					counts.remove(cows[left].id);
				}
				left++;
			}
			right++;
		}

		System.out.println(min);
		scan.close();
	}
}
