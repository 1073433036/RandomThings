
package usaco.NO;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.PrintWriter;
// import java.util.StringTokenizer;

import java.io.IOException;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class Binary_Sudoku_2011NovGold2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bsudoku.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bsudoku.out")));
		StringTokenizer st;

		boolean[][] board = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(f.readLine());
			String row = st.nextToken();
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt("" + row.charAt(j)) == 1;
			}
		}

		out.close();
		f.close();
	}
}
