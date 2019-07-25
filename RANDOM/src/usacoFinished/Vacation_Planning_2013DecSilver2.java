
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Vacation_Planning_2013DecSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("vacation.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("vacation.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFarms = Integer.parseInt(st.nextToken());
		int numConnections = Integer.parseInt(st.nextToken());
		int numHubs = Integer.parseInt(st.nextToken());
		int numQueries = Integer.parseInt(st.nextToken());
		int[][] connections = new int[numFarms][numFarms];
		for (int i = 0; i < numFarms; i++) {
			for (int j = 0; j < numFarms; j++) {
				connections[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < numConnections; i++) {
			st = new StringTokenizer(f.readLine());
			connections[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer
					.parseInt(st.nextToken());
		}

		long[][] distances = new long[numHubs][numFarms];
		for (int i = 0; i < numHubs; i++) {
			for (int j = 0; j < numFarms; j++) {
				distances[i][j] = Long.MAX_VALUE;
			}
		}

		for (int hubi = 0; hubi < numHubs; hubi++) {
			distances[hubi][hubi] = 0;
			boolean[] visited = new boolean[numFarms];
			for (int farm = 0; farm < numFarms; farm++) {
				int min = -1;
				for (int i = 0; i < numFarms; i++) {
					if (!visited[i] && (min == -1 || distances[hubi][i] < distances[hubi][min])) {
						min = i;
					}
				}

				visited[min] = true;
				for (int i = 0; i < numFarms; i++) {
					if (distances[hubi][i] > distances[hubi][min] + connections[min][i]
							&& connections[min][i] != Integer.MAX_VALUE
							&& distances[hubi][min] + connections[min][i] >= 0) {
						distances[hubi][i] = distances[hubi][min] + connections[min][i];
					}
				}
			}
		}
		long[][] rdistances = new long[numHubs][numFarms];
		for (int i = 0; i < numHubs; i++) {
			for (int j = 0; j < numFarms; j++) {
				rdistances[i][j] = Long.MAX_VALUE;
			}
		}

		for (int hubi = 0; hubi < numHubs; hubi++) {
			rdistances[hubi][hubi] = 0;
			boolean[] visited = new boolean[numFarms];
			for (int farm = 0; farm < numFarms; farm++) {
				int min = -1;
				for (int i = 0; i < numFarms; i++) {
					if (!visited[i] && (min == -1 || rdistances[hubi][i] < rdistances[hubi][min])) {
						min = i;
					}
				}

				visited[min] = true;
				for (int i = 0; i < numFarms; i++) {
					if (rdistances[hubi][i] > rdistances[hubi][min] + connections[i][min]
							&& connections[i][min] != Integer.MAX_VALUE
							&& rdistances[hubi][min] + connections[i][min] >= 0) {
						rdistances[hubi][i] = rdistances[hubi][min] + connections[i][min];
					}
				}
			}
		}

		int numPossible = 0;
		long total = 0;
		for (int i = 0; i < numQueries; i++) {
			st = new StringTokenizer(f.readLine());
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			long min = Long.MAX_VALUE;
			for (int j = 0; j < numHubs; j++) {
				if (rdistances[j][src] + distances[j][dest] < min && rdistances[j][src] + distances[j][dest] >= 0) {
					min = rdistances[j][src] + distances[j][dest];
				}
			}
			if (min != Long.MAX_VALUE) {
				total += min;
				numPossible++;
			}
		}

		out.println(numPossible);
		out.println(total);
		out.close();
		f.close();
	}
}
