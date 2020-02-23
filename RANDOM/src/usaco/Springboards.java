
// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.TreeSet;
import java.io.IOException;

public class Springboards {
	private static class point implements Comparable<point> {
		int x;
		int y;
		int id;
		boolean start;

		public point(int x, int y, int id, boolean start) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.start = start;
		}

		public int compareTo(point other) {
			if (this.x == other.x) {
				return this.y - other.y;
			}
			return this.x - other.x;
		}
	}

	private static class setitem implements Comparable<setitem> {
		int y;
		int val;

		public setitem(int y, int val) {
			this.y = y;
			this.val = val;
		}

		public int compareTo(setitem other) {
			if (this.y == other.y) {
				return this.val - other.val;
			}
			return this.y - other.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("boards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] distances = new int[2 * M + 2];
		point[] points = new point[2 * M + 1];

		int i = 0;
		while (i < 2 * M) {
			st = new StringTokenizer(f.readLine());
			points[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i++, true);
			points[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i++, false);
		}
		points[2 * M] = new point(N, N, 2 * M, true);

		// for(point p:points) {
		// System.out.println(p.x+" "+p.y+" "+p.id+" "+p.start);
		// }

		for (i = 0; i <= 2 * M; i += 2) {
			distances[i] = distances[i + 1] = points[i].x + points[i].y;
		}
		// System.out.println(Arrays.toString(distances));

		Arrays.sort(points);

		TreeSet<setitem> pair = new TreeSet<>();
		for (point p : points) {
			if (p.start) {
				setitem t = pair.lower(new setitem(p.y, 0));
				if(t==null) {
					continue;
				}
				distances[p.id] = Math.min(distances[p.id], p.x + p.y + t.val);
				distances[p.id + 1] = distances[p.id];
			}
			else {
				setitem t = new setitem(p.y, distances[p.id] - p.x - p.y);
				setitem lw = pair.lower(t);
				if(lw==null) {
					pair.add(t);
					continue;
				}
				if (lw.val < t.val) {
					continue;
				}
				TreeSet<setitem> hg = (TreeSet<setitem>) pair.tailSet(t);
				for (setitem si : hg) {
					if (si.val >= t.val) {
						pair.remove(si);
					}
				}

				pair.add(t);
			}
		}

		out.println(distances[2 * M]);
		out.close();
		f.close();
	}
}
