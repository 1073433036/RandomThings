
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Mooyo_Mooyo_2018DecSilver3 {
	private static int[][] board;
	private static boolean changed = true;
	private static int matchCounts;
	private static int[] counts;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		board = new int[Integer.parseInt(st.nextToken())][10];
		counts = new int[1010];
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(f.readLine());
			String[] digits = st.nextToken().split("");

			for (int j = 0; j < digits.length; j++) {
				board[i][j] = Integer.parseInt(digits[j]);
			}
		}

		while (changed) {
			changed = false;
			matchCounts = 10;
			counts = new int[1010];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < 10; j++) {
					if (board[i][j] != 0 && board[i][j] < 10) {
						int temp = board[i][j];
						int count = floodfill(board[i][j], i, j);
						counts[matchCounts] = count >= k ? 0 : temp;
						if (count >= k) {
							changed = true;
						}
						matchCounts++;
					}
				}
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < 10; j++) {
					board[i][j] = counts[board[i][j]];
				}
			}

			for (int j = 0; j < 10; j++) {
				int top = board.length - 1;
				for (int i = board.length - 1; i >= 0; i--) {
					if (board[i][j] == 0) {
						while (top >= 0 && board[top][j] == 0) {
							top--;
						}
						if (top == -1) {
							break;
						}
						board[i][j] = board[top][j];
						board[top][j] = 0;
					}
					else {
						top--;
					}
				}

			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < 10; j++) {
				out.print(board[i][j]);
			}
			out.println();
		}
		out.close();
		f.close();
	}

	public static int floodfill(int num, int x, int y) {
		int[] nx = { 0, 0, -1, 1 };
		int[] ny = { 1, -1, 0, 0 };

		int total = 0;
		board[x][y] = matchCounts;
		for (int i = 0; i < 4; i++) {
			if (x + nx[i] < board.length && x + nx[i] >= 0 && y + ny[i] < 10 && y + ny[i] >= 0
					&& board[x + nx[i]][y + ny[i]] == num) {
				total += floodfill(num, x + nx[i], y + ny[i]);
			}
		}

		return total + 1;
	}
}
