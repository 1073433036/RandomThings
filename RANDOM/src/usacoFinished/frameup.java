
/*
ID: juskim81
LANG: JAVA
TASK: frameup
 */
import java.io.IOException;
import java.util.ArrayList;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class frameup {
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("frameup.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("frameup.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numRows = Integer.parseInt(st.nextToken());
		int numCols = Integer.parseInt(st.nextToken());
		int[][] frames = new int[numRows][numCols];
		int[][] minmaxrc = new int[26][4];
		for (int i = 0; i < minmaxrc.length; i++) {
			minmaxrc[i][0] = 100000000;
			minmaxrc[i][1] = 100000000;
		}

		inImage = new boolean[26];
		numFrames = 0;
		for (int r = 0; r < numRows; r++) {
			st = new StringTokenizer(f.readLine());
			String line = st.nextToken();
			for (int c = 0; c < line.length(); c++) {
				if (line.charAt(c) == '.') {
					frames[r][c] = -1;
				}
				else {
					frames[r][c] = line.charAt(c) - 65;
					if (!inImage[frames[r][c]]) {
						numFrames++;
					}
					inImage[frames[r][c]] = true;
					minmaxrc[frames[r][c]][0] = Math.min(minmaxrc[frames[r][c]][0], r);
					minmaxrc[frames[r][c]][1] = Math.min(minmaxrc[frames[r][c]][1], c);
					minmaxrc[frames[r][c]][2] = Math.max(minmaxrc[frames[r][c]][2], r);
					minmaxrc[frames[r][c]][3] = Math.max(minmaxrc[frames[r][c]][3], c);
				}
			}
		}

		// check on top of
		onTopOf = new boolean[26][26];
		for (int id = 0; id < 26; id++) {
			// r min c down
			for (int r = minmaxrc[id][0]; r <= minmaxrc[id][2]; r++) {
				if (frames[r][minmaxrc[id][1]] != id) {
					onTopOf[frames[r][minmaxrc[id][1]]][id] = true;
				}
			}
			// r max c down
			for (int r = minmaxrc[id][0]; r <= minmaxrc[id][2]; r++) {
				if (frames[r][minmaxrc[id][3]] != id) {
					onTopOf[frames[r][minmaxrc[id][3]]][id] = true;
				}
			}
			// min r c right
			for (int c = minmaxrc[id][1]; c <= minmaxrc[id][3]; c++) {
				if (frames[minmaxrc[id][0]][c] != id) {
					onTopOf[frames[minmaxrc[id][0]][c]][id] = true;
				}
			}
			// max r c right
			for (int c = minmaxrc[id][1]; c <= minmaxrc[id][3]; c++) {
				if (frames[minmaxrc[id][2]][c] != id) {
					onTopOf[frames[minmaxrc[id][2]][c]][id] = true;
				}
			}
		}

		// all topological sorts

		inDegrees = new int[26];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (onTopOf[i][j]) {
					inDegrees[i]++;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			if (!inImage[i]) {
				inDegrees[i] = 1000000000;
			}
		}

		result = new ArrayList<Integer>(26);
		visited = new boolean[26];
		allTopSort();

		out.close();
		f.close();
	}

	static ArrayList<Integer> result;
	static boolean[] visited;
	static boolean[] inImage;
	static boolean[][] onTopOf;
	static int[] inDegrees;
	static int numFrames;

	public static void allTopSort() {
		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			if (inDegrees[i] == 0 && !visited[i]) {
				for (int j = 0; j < 26; j++) {
					if (onTopOf[j][i]) {
						inDegrees[j]--;
					}
				}

				result.add(i);
				visited[i] = true;
				allTopSort();

				visited[i] = false;
				result.remove(result.size() - 1);
				for (int j = 0; j < 26; j++) {
					if (onTopOf[j][i]) {
						inDegrees[j]++;
					}
				}

				flag = true;
			}
		}
		if (!flag && result.size() == numFrames) {
			for (int i = 0; i < result.size(); i++) {
				out.print((char) (result.get(i) + 65));
			}
			out.println();
		}
	}
}
