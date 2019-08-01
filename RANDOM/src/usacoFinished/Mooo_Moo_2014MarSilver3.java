// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Mooo_Moo_2014MarSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mooomoo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooomoo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFields = Integer.parseInt(st.nextToken());
		int numTypes = Integer.parseInt(st.nextToken());
		int[] types = new int[numTypes];
		int[] fields = new int[numFields];
		for (int i = 0; i < numTypes; i++) {
			st = new StringTokenizer(f.readLine());
			types[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < numFields; i++) {
			st = new StringTokenizer(f.readLine());
			fields[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = numFields - 1; i >= 1; i--) {
			fields[i] -= Math.max(0, fields[i - 1] - 1);
		}

		int total = 0;
		for (int i = 0; i < numFields; i++) {
			int[][] possible = new int[numTypes + 1][fields[i] + 1];
			// possible[j][k] min cows with j types to make volume k
			// possible[j][k]=min(possible[j-1][k], possible[j][k-typej]

			for (int j = 1; j <= fields[i]; j++) {
				possible[0][j] = Integer.MAX_VALUE - 1;
			}
			for (int j = 1; j <= numTypes; j++) {
				if (types[j - 1] <= fields[i]) {
					possible[j][types[j - 1]] = 1;
				}
				for (int k = 0; k <= fields[i]; k++) {
					if (k - types[j - 1] < 0) {
						possible[j][k] = possible[j - 1][k];
					}
					else {
						possible[j][k] = Math.min(possible[j - 1][k], possible[j][k - types[j - 1]] + 1);
					}
				}
			}

			total += possible[numTypes][fields[i]];
		}

		out.println(total);
		out.close();
		f.close();
	}
}
