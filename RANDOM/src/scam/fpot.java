package scam;

import java.util.Arrays;
import java.util.Scanner;

public class fpot {
	private static class pos implements Comparable<pos> {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pos o) {
			if (x > o.x) {
				return 1;
			}
			else if (x < o.x) {
				return -1;
			}
			else {
				return y - o.y;
			}

		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int numDrops = input.nextInt();
		int time = input.nextInt();
		pos[] drops = new pos[numDrops];

		for (int i = 0; i < numDrops; i++) {
			drops[i] = new pos(input.nextInt(), input.nextInt());
		}

		Arrays.sort(drops);
		int[] prefSums = new int[numDrops];
		prefSums[0] = 0;
		for (int i = 1; i < numDrops; i++) {
			prefSums[i] = drops[i].y - drops[i - 1].y;
		}
		
		int[] widths=new int

	}
}
