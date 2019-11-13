package scam;

import java.util.Arrays;

public class NQueens {
	static int N = 4;
	static int[] board = new int[N];
	static boolean[] visited=new boolean[N];

	public static void main(String[] args) {
		back(0);
	}

	public static void back(int i) {
		if (i == N) {
			System.out.println(Arrays.toString(board));
			return;
		}
		for (int j = 0; j < N; j++) {
			if (valid(i, j)) {
				board[i] = j;
				visited[j]=true;
				back(i + 1);
				visited[j]=false;
			}
		}
	}

	public static boolean valid(int i, int j) {
		if(visited[j]) {
			return false;
		}
		for (int a = 0; a < i; a++) {
			if (Math.abs(a - i) == Math.abs(board[a] - j)) {
				return false;
			}
		}

		return true;
	}
}
