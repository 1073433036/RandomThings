package usaco.NO;

import java.util.Arrays;
import java.util.Scanner;

public class squares {
	private static class pos implements Comparable<pos> {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(pos o) {
			if (x == o.x) {
				return y - o.y;
			}
			return x - o.x;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numSquares = scan.nextInt();
		int size = scan.nextInt();

		pos[] blsquares = new pos[numSquares];
		pos[] rblsquares = new pos[numSquares];
		for (int i = 0; i < numSquares; i++) {
			int x = scan.nextInt() - size / 2;
			int y = scan.nextInt() - size / 2;
			blsquares[i] = new pos(x, y);
			rblsquares[i] = new pos(y, x);
		}

		Arrays.sort(blsquares);
		Arrays.sort(rblsquares);

		int found = 0;
		int ps1x = 0;
		int ps1y = 0;
		int ps2x = 0;
		int ps2y = 0;
		int area = 0;
		int left = 0;
		for (int right = 1; right < numSquares; right++) {
			while (left < right && right < numSquares) {
				int s1x = blsquares[left].x;
				int s1y = blsquares[left].y;
				int s2x = blsquares[right].x;
				int s2y = blsquares[right].y;
				if (s2x - s1x < size && Math.abs(s2y - s1y) < size) {
					found++;
					ps1x = s1x;
					ps1y = s1y;
					ps2x = s2x;
					ps2y = s2y;
					int blx = s2x;
					int bly = Math.max(s1y, s2y);
					int urx = s1x + size;
					int ury = Math.min(s1y + size, s2y + size);
					area = (urx - blx) * (ury - bly);
					right++;
				}
				else {
					left++;
				}
			}
			if (left == right) {
				left--;
			}
		}

		left = 0;
		for (int right = 1; right < numSquares; right++) {
			while (left < right && right < numSquares) {
				int s1x = rblsquares[left].x;
				int s1y = rblsquares[left].y;
				int s2x = rblsquares[right].x;
				int s2y = rblsquares[right].y;
				if (s2x - s1x < size && Math.abs(s2y - s1y) < size) {
					found++;
					if ((ps1x == s1y && ps1y == s1x && ps2x == s2y && ps2y == s2x)
							|| (ps1x == s2y && ps1y == s2x && ps2x == s1y && ps2y == s1x)) {
						found--;
					}
					int blx = s2x;
					int bly = Math.max(s1y, s2y);
					int urx = s1x + size;
					int ury = Math.min(s1y + size, s2y + size);
					area = (urx - blx) * (ury - bly);
					right++;
				}
				else {
					left++;
				}
			}
			if (left == right) {
				left--;
			}
		}

		if (found == 0) {
			System.out.println(0);
		}
		else if (found > 1) {
			System.out.println(-1);
		}
		else {
			System.out.println(area);
		}
		scan.close();
	}
}
