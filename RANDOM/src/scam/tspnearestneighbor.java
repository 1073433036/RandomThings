package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class tspnearestneighbor {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("tsp1.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCities = Integer.parseInt(st.nextToken());
		double[] x = new double[numCities];
		double[] y = new double[numCities];
		for (int i = 0; i < numCities; i++) {
			st = new StringTokenizer(f.readLine());
			st.nextToken();
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}

		int pos = 0;
		double total = 0;
		boolean[] visited = new boolean[numCities];
		visited[pos] = true;
		for (int i = 0; i < numCities - 1; i++) {
			double min = Double.MAX_VALUE;
			int mi = 0;
			for (int j = 0; j < numCities; j++) {
				if (!visited[j]) {
					double dist = Math.sqrt(Math.pow(x[j] - x[pos], 2) + Math.pow(y[j] - y[pos], 2));
					if (dist < min) {
						min = dist;
						mi = j;
					}
				}
			}

			total += min;
			pos = mi;
			visited[mi] = true;
		}

		total += Math.sqrt(Math.pow(x[0] - x[pos], 2) + Math.pow(y[0] - y[pos], 2));
		System.out.println((int) total);
		f.close();
	}
}
