package usaco.NO;

import java.io.IOException;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.PrintWriter;
// import java.util.StringTokenizer;
import java.util.HashMap;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class poetry {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("poetry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("poetry.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// length rhyme num
		HashMap<Integer, HashMap<Integer, Integer>> words = new HashMap<>(n);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(f.readLine());
			int length = Integer.parseInt(st.nextToken());
			int rhyme = Integer.parseInt(st.nextToken());
			if (words.containsKey(length)) {
				if (words.get(length).containsKey(rhyme)) {
					words.get(length).put(rhyme, words.get(length).get(rhyme) + 1);
				}
				else {
					words.get(length).put(rhyme, 1);
				}
			}
			else {
				HashMap<Integer, Integer> temp = new HashMap<>();
				temp.put(rhyme, 1);
				words.put(length, temp);
			}
		}

		int[][] possible = new int[words.size() + 1][k + 1];
		int i = 1;
		for (Integer length : words.keySet()) {
			possible[i][0] = 1;
			for (int j = 1; j <= k; j++) {
				possible[i][j] += possible[i - 1][j];
				if (j >= length) {
					possible[i][j] += possible[i][j - length] * words.get(length).size();
				}
			}
			i++;
		}

		out.close();
		f.close();
	}

}
