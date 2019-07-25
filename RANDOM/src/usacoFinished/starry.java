package usacoFinished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class starry {
	private static class point implements Comparable<point> {

		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int hashCode() {
			return c + r;
		}

		public boolean equals(Object other) {
			return ((point) other).c == this.c && ((point) other).r == this.r;
		}

		public int compareTo(point other) {
			if (other.c == this.c) {
				return this.r - other.r;
			}
			return this.c - other.c;
		}

		public String toString() {
			return "{" + r + ", " + c + "}";
		}
	}

	private static class cluster {
		ArrayList<point> points = new ArrayList<>(161);
		int minr = 1000;
		int minc = 1000;
		int maxr = 0;

		public void rotate() {
			int temaxr = 0;
			for (int i = 0; i < points.size(); i++) {
				int nr = points.get(i).c;
				temaxr = Math.max(temaxr, nr);
				int nc = maxr - points.get(i).r;
				points.set(i, new point(nr, nc));
			}
			maxr = temaxr;
		}

		public void reflect() {
			for (int i = 0; i < points.size(); i++) {
				points.set(i, new point(maxr - points.get(i).r, points.get(i).c));
			}
		}

		public void normalize() {
			Collections.sort(points);
			int temaxr = 0;
			for (int i = 0; i < points.size(); i++) {
				points.set(i, new point(points.get(i).r - minr, points.get(i).c - minc));
				temaxr = Math.max(temaxr, points.get(i).r);
			}
			minr = 0;
			minc = 0;
			maxr = temaxr;
		}
	}

	static ArrayList<cluster> clusters = new ArrayList<>(27);
	static cluster currcluster;

	static String[] sky;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		sky = new String[rows];
		for (int i = 0; i < rows; i++) {
			sky[i] = scan.next();
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (sky[r].charAt(c) == '*') {
					currcluster = new cluster();
					floodfill(r, c);
					boolean matches = false;
					currcluster.normalize();
					for (cluster cluster : clusters) {
						if (same(currcluster, cluster)) {
							matches = true;
							break;
						}
					}

					if (!matches) {
						clusters.add(currcluster);
					}
				}
			}
		}

		System.out.println(clusters.size());
		scan.close();
	}

	public static boolean same(cluster c1, cluster c2) {
		if (c1.points.size() != c2.points.size()) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (c1.points.equals(c2.points)) {
				return true;
			}
			c1.rotate();
			c1.normalize();
		}
		c1.reflect();
		c1.normalize();
		for (int i = 0; i < 4; i++) {
			if (c1.points.equals(c2.points)) {
				return true;
			}
			c1.reflect();
			c1.normalize();
		}

		return false;
	}

	public static void floodfill(int r, int c) {
		sky[r] = sky[r].substring(0, c) + '.' + sky[r].substring(c + 1);
		currcluster.points.add(new point(r, c));
		currcluster.minr = Math.min(currcluster.minr, r);
		currcluster.minc = Math.min(currcluster.minc, c);
		currcluster.maxr = Math.max(currcluster.maxr, r);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nr = r + i;
				int nc = c + j;
				if (nr >= 0 && nr < sky.length && nc >= 0 && nc < sky[0].length() && sky[nr].charAt(nc) == '*') {
					floodfill(nr, nc);
				}
			}
		}
	}
}
