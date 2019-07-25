package usaco;

/*
ID: juskim81
LANG: JAVA
TASK: beads
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
		for (; y <= 1900 + numYears || m <= 12 || d <= 31; d++) {

		}

		out.close();
		f.close();
	}
}
