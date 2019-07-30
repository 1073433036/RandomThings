
/*
ID: juskim81
LANG: JAVA
TASK: friday
 */
import java.io.IOException;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class friday {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numYears = Integer.parseInt(st.nextToken());
		int[] counts = new int[7];// saturday to friday
		int d = 1;
		int m = 1;
		int y = 1900;
		int dow = 2;
		// 0 1 2 3 4 5 6
		// sat sun mon tues wed thur fri
		for (;; d++) {
			if (d == 13) {
				counts[dow]++;
			}

			if (d == 31 && m == 12 && y == 1900 + numYears - 1) {
				break;
			}
			if (m == 9 || m == 4 || m == 6 || m == 11) {
				if (d == 30) {
					d = 0;
					m++;
				}
			}
			else if (m == 2) {
				if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
					if (d == 29) {
						d = 0;
						m++;
					}
				}
				else if (d == 28) {
					d = 0;
					m++;
				}
			}
			else {
				if (d == 31) {
					d = 0;
					m++;
				}
			}
			if (m == 13) {
				m = 1;
				y++;
			}

			dow = (dow + 1) % 7;
		}

		for (int i = 0; i < 6; i++) {
			out.print(counts[i] + " ");
		}
		out.println(counts[6]);

		out.close();
		f.close();
	}
}
