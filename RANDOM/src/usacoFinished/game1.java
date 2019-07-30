package usacoFinished;

import java.util.Scanner;

public class game1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] board = new int[size];
		int total = 0;
		for (int i = 0; i < size; i++) {
			board[i] = scan.nextInt();
			total += board[i];
		}

		int[][] max = new int[size][size];
		for (int i = 0; i < size; i++) {
			max[i][i] = board[i];
		}

		for (int i = 0; i + 1 < size; i++) {
			max[i][i + 1] = Math.max(max[i][i], max[i + 1][i + 1]);
		}

		for (int i = 2; i < size; i++) {
			for (int j = 0; j + i < size; j++) {
				max[j][j + i] = Math.max(Math.min(max[j + 2][j + i], max[j + 1][j + i - 1]) + board[j],
						Math.min(max[j][j + i - 2], max[j + 1][j + i - 1]) + board[j + i]);
			}
		}

		System.out.println(max[0][size - 1] + " " + (total - max[0][size - 1]));
		scan.close();
	}
}
