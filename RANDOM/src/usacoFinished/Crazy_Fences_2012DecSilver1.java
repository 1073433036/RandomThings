
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class Crazy_Fences_2012DecSilver1 {
	private static class point {
		long x;
		long y;

		public point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(point other) {
			return other.x == this.x && other.y == this.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crazy.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crazy.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numFences = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());
		point[][] fences = new point[numFences][2];
		for (int i = 0; i < numFences; i++) {
			st = new StringTokenizer(f.readLine());
			fences[i][0] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			fences[i][1] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		ArrayList<ArrayList<point>> polygons = new ArrayList<>();
		boolean[] visited = new boolean[numFences];
		for (int i = 0; i < numFences; i++) {
			if (visited[i]) {
				continue;
			}
			ArrayList<point> polygon = new ArrayList<>();
			point stpt = fences[i][0];
			point endpt = fences[i][1];
			polygon.add(stpt);
			polygon.add(endpt);
			visited[i] = true;
			while (!endpt.equals(stpt)) {
				for (int j = 0; j < numFences; j++) {
					if (!visited[j]) {
						if (fences[j][0].equals(endpt)) {
							polygon.add(fences[j][1]);
							visited[j] = true;
							endpt = fences[j][1];
							break;
						}
						if (fences[j][1].equals(endpt)) {
							polygon.add(fences[j][0]);
							visited[j] = true;
							endpt = fences[j][0];
							break;
						}
					}
				}
			}

			polygons.add(polygon);
		}

		BitSet[] insidePolygon = new BitSet[numCows];
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			point cow = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			insidePolygon[i] = new BitSet(polygons.size());
			for (int j = 0; j < polygons.size(); j++) {
				insidePolygon[i].set(j, inPolygon(polygons.get(j), cow));
			}
		}

		int max = 0;
		for (int i = 0; i < numCows; i++) {
			int count = 1;
			for (int j = i + 1; j < numCows; j++) {
				if (insidePolygon[i].equals(insidePolygon[j])) {
					count++;
				}
			}
			max = Math.max(max, count);
		}

		out.println(max);
		out.close();
		f.close();
	}

	public static boolean inPolygon(ArrayList<point> polygon, point cow) {
		point end = new point(1000001, cow.y + 1);
		int count = 0;
		for (int i = 0; i < polygon.size() - 1; i++) {
			point p1 = polygon.get(i);
			point p2 = polygon.get(i + 1);
			if (intersects(p1, p2, cow, end)) {
				count++;
			}
		}
		return count % 2 == 0;
	}

	public static int orientation(point p1, point p2, point p3) {
		return (p2.y - p1.y) * (p3.x - p1.x) - (p2.x - p1.x) * (p3.y - p1.y) > 0 ? 1 : -1;
	}

	public static boolean intersects(point p1, point p2, point p3, point p4) {
		return orientation(p1, p2, p3) * orientation(p1, p2, p4) < 0
				&& orientation(p3, p4, p1) * orientation(p3, p4, p2) < 0;
	}
}
