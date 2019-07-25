
// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Watering_The_Fields_2014MarSilver1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("irrigation.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("irrigation.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFields = Integer.parseInt(st.nextToken());
		int minCost = Integer.parseInt(st.nextToken());
		int[][] points = new int[numFields][2];

		for (int i = 0; i < numFields; i++) {
			st = new StringTokenizer(f.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}

		long total = 0;
		boolean[] visited = new boolean[numFields];
		int[] pointsMinCost = new int[numFields];
		for (int i = 0; i < numFields; i++) {
			pointsMinCost[i] = 10000000;
		}

		pointsMinCost[0] = 0;
		int numVisited = 0;
		for (int i = 0; i < numFields; i++) {
			int min = -1;
			for (int j = 0; j < numFields; j++) {
				if (!visited[j] && (min == -1 || pointsMinCost[j] < pointsMinCost[min])) {
					min = j;
				}
			}

			if (pointsMinCost[min] != 10000000) {
				numVisited++;
			}
			visited[min] = true;
			total += pointsMinCost[min];
			for (int j = 0; j < numFields; j++) {
				int cost = (int) (Math.pow(points[j][0] - points[min][0], 2)
						+ Math.pow(points[j][1] - points[min][1], 2));
				if (min != j && cost >= minCost && cost < pointsMinCost[j]) {
					pointsMinCost[j] = cost;
				}
			}
		}

		if (numVisited < numFields) {
			out.println(-1);
		}
		else {
			out.println(total);
		}
		out.close();
		f.close();
	}
}
