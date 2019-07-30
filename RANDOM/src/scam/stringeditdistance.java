package scam;

import java.util.Scanner;

public class stringeditdistance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String start = scan.next();
		String end = scan.next();

		int[][] numedits = new int[start.length() + 1][end.length() + 1];
		// numedits[i][j]= # edits to make 1st i letters into 1st j letters
		// numedits[i][j]=numedits[i-1][j-1] if i==j else
		// min(numedits[i-1][j], numedits[i][j-1], numedits[i-1][j-1])+1
		for (int i = 0; i <= start.length(); i++) {
			numedits[i][0] = i;
		}
		for (int j = 0; j <= end.length(); j++) {
			numedits[0][j] = j;
		}

		for (int i = 1; i <= start.length(); i++) {
			for (int j = 1; j <= end.length(); j++) {
				if (start.charAt(i - 1) == end.charAt(j - 1)) {
					numedits[i][j] = numedits[i - 1][j - 1];
				}
				else {
					numedits[i][j] = Math.min(numedits[i - 1][j], Math.min(numedits[i][j - 1], numedits[i - 1][j - 1]))
							+ 1;
				}
			}
		}
		
		System.out.println(numedits[start.length()][end.length()]);

		scan.close();
	}
}
