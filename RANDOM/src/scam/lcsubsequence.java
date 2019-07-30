package scam;

import java.util.Scanner;

public class lcsubsequence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();

		int[][] lcSubseq = new int[s1.length() + 1][s2.length() + 1];
		// lcsubseq[i][j]= max common subsequence from 1st i and 1st j letters
		// lcsubseq[i][j]=1+lcsubseq[i-1][j-1] if i==j else
		// max(lcsubseq[i-1][j], lcsubseq[i][j-1])
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcSubseq[i][j] = lcSubseq[i - 1][j - 1] + 1;
				}
				else {
					lcSubseq[i][j] = Math.max(lcSubseq[i - 1][j], lcSubseq[i][j - 1]);
				}
			}
		}

		System.out.println(lcSubseq[s1.length()][s2.length()]);

		scan.close();
	}
}
