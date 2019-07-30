/*
ID: juskim81
LANG: JAVA
TASK: transform
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class transform {
	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		size = Integer.parseInt(st.nextToken());
		boolean[][] pattern = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(f.readLine());
			String line = st.nextToken();
			for (int j = 0; j < size; j++) {
				pattern[i][j] = line.charAt(j) == '@';
			}
		}

		boolean[][] changed = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(f.readLine());
			String line = st.nextToken();
			for (int j = 0; j < size; j++) {
				changed[i][j] = line.charAt(j) == '@';
			}
		}

		int ans = 7;
		if (equals(rotate1(pattern), changed)) {
			ans = 1;
		}
		else if (equals(rotate2(pattern), changed)) {
			ans = 2;
		}
		else if (equals(rotate3(pattern), changed)) {
			ans = 3;
		}
		else if (equals(mirror(pattern), changed)) {
			ans = 4;
		}
		else if (equals(combo1(pattern), changed) || equals(combo2(pattern), changed)
				|| equals(combo3(pattern), changed)) {
			ans = 5;
		}
		else if (equals(pattern, changed)) {
			ans = 6;
		}

		out.println(ans);

		out.close();
		f.close();
	}

	public static boolean equals(boolean[][] pattern, boolean[][] change) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (pattern[i][j] != change[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean[][] rotate1(boolean[][] pattern) {
		boolean[][] changePattern = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				changePattern[i][j] = pattern[size - j - 1][i];
			}
		}

		return changePattern;
	}

	public static boolean[][] rotate2(boolean[][] pattern) {
		boolean[][] changePattern = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				changePattern[i][j] = pattern[size - i - 1][size - j - 1];
			}
		}

		return changePattern;
	}

	public static boolean[][] rotate3(boolean[][] pattern) {
		boolean[][] changePattern = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				changePattern[i][j] = pattern[j][size - i - 1];
			}
		}

		return changePattern;
	}

	public static boolean[][] mirror(boolean[][] pattern) {
		boolean[][] changePattern = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				changePattern[i][j] = pattern[i][size - j - 1];
			}
		}

		return changePattern;
	}

	public static boolean[][] combo1(boolean[][] pattern) {
		return rotate1(mirror(pattern));
	}

	public static boolean[][] combo2(boolean[][] pattern) {
		return rotate2(mirror(pattern));
	}

	public static boolean[][] combo3(boolean[][] pattern) {
		return rotate3(mirror(pattern));
	}
}
