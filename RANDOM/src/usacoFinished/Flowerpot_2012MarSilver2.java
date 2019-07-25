
package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

public class Flowerpot_2012MarSilver2 {
	private static class point implements Comparable<point> {
		int x;
		int y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(point o) {
			if (o.x == this.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("fpot.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fpot.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numPoints = Integer.parseInt(st.nextToken());
		int minTime = Integer.parseInt(st.nextToken());
		point[] points = new point[numPoints];
		int minY = 100000000;
		int maxY = 0;
		for (int i = 0; i < numPoints; i++) {
			st = new StringTokenizer(f.readLine());
			points[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			minY = Math.min(minY, points[i].y);
			maxY = Math.max(maxY, points[i].y);
		}
		if (minTime > maxY - minY) {
			out.println(-1);
			out.close();
			f.close();
			return;
		}
		Arrays.sort(points);

		int left = 0;
		int right = 0;
		TreeMap<Integer, Integer> rainOver = new TreeMap<>();
		int minWidth = 10000000;
		while (right < numPoints) {
			int maxDist = 0;
			while (right < numPoints && maxDist < minTime) {
				if (rainOver.containsKey(points[right].y)) {
					rainOver.put(points[right].y, rainOver.get(points[right].y) + 1);
				}
				else {
					rainOver.put(points[right].y, 1);
				}
				maxDist = rainOver.lastKey() - rainOver.firstKey();

				right++;
			}
			if (maxDist >= minTime) {
				right--;
			}
			while (left < right && maxDist >= minTime) {
				minWidth = Math.min(minWidth, points[right].x - points[left].x);
				rainOver.put(points[left].y, rainOver.get(points[left].y) - 1);
				if (rainOver.get(points[left].y) == 0) {
					rainOver.remove(points[left].y);
				}
				maxDist = rainOver.lastKey() - rainOver.firstKey();

				left++;
			}
			right++;
		}

		out.println(minWidth);
		out.close();
		f.close();
	}
}
