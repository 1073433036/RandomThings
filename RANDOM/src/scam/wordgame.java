package scam;

import java.util.Scanner;

public class wordgame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numLetters = scan.nextInt();
		String letters = scan.next();
		String mword = scan.next();
		int[] counts = new int[3];
		for (int i = 0; i < numLetters; i++) {
			counts[letters.charAt(i) - 97]++;
		}
		int[][] lettersLeft = new int[numLetters][3];
		lettersLeft[numLetters - 1][mword.charAt(numLetters - 1) - 97] = 1;
		for (int i = numLetters - 2; i >= 0; i--) {
			lettersLeft[i][0] = lettersLeft[i + 1][0];
			lettersLeft[i][1] = lettersLeft[i + 1][1];
			lettersLeft[i][2] = lettersLeft[i + 1][2];
			lettersLeft[i][mword.charAt(i) - 97] = lettersLeft[i + 1][mword.charAt(i) - 97] + 1;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < numLetters; j++) {
				System.out.print(lettersLeft[j][i] + " ");
			}
			System.out.println();
		}

		String word = "";
		for (int i = 0; i < numLetters; i++) {
			if (mword.charAt(i) == 'a') {
				if (counts[1] > 0 && lettersLeft[i][0] - 1 <= counts[1] - 1 + counts[2]
						&& lettersLeft[i][2] <= counts[0] + counts[1] - 1) {
					word += 'b';
					counts[1]--;
				}
				else {
					word += 'c';
					counts[2]--;
				}
			}
			else if (mword.charAt(i) == 'b') {
				if (counts[0] > 0 && lettersLeft[i][1] - 1 <= counts[0] - 1 + counts[2]
						&& lettersLeft[i][2] <= counts[0] - 1 + counts[1]) {
					word += 'a';
					counts[0]--;
				}
				else {
					word += 'c';
					counts[2]--;
				}
			}
			else {
				if (counts[0] > 0 && lettersLeft[i][1] <= counts[0] - 1 + counts[2]
						&& lettersLeft[i][2] - 1 <= counts[0] - 1 + counts[1]) {
					word += 'a';
					counts[0]--;
				}
				else {
					word += 'b';
					counts[1]--;
				}
			}
		}

		System.out.println(word);

		scan.close();
	}
}
