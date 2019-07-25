/*
ID: juskim81
LANG: JAVA
TASK: agrinet
 */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class agrinet {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFarms = Integer.parseInt(st.nextToken());
		int[][] weights = new int[numFarms][numFarms];

		for (int i = 0; i < numFarms; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < numFarms; j++) {
				weights[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[numFarms];
		int[] weightedFarms = new int[numFarms];

		for (int i = 0; i < numFarms; i++) {
			weightedFarms[i] = 1000000;
		}
		weightedFarms[0] = 0;

		int total = 0;
		for (int i = 0; i < numFarms; i++) {
			int min = -1;
			for (int j = 0; j < numFarms; j++) {
				if (!visited[j] && (min == -1 || weightedFarms[j] < weightedFarms[min])) {
					min = j;
				}
			}
			visited[min] = true;
			total += weightedFarms[min];
			for (int j = 0; j < numFarms; j++) {
				if (min != j && weights[min][j] < weightedFarms[j]) {
					weightedFarms[j] = weights[min][j];
				}
			}
		}

		out.println(total);
		out.close();
		f.close();
	}
}
