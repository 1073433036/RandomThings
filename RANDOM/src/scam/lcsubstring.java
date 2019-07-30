package scam;

import java.util.Scanner;

public class lcsubstring {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String st1 = scan.next();
		String st2 = scan.next();
		int[][] lcSubstr = new int[st1.length() + 1][st2.length() + 1];
		// lcsubstr[i][j]= longest common substring ending at i and j
		// lcsubstr[i][j]= 1 + lcsubstr[i-1][j-1] if same letter 0 if not
		int max = 0;
		for (int i = 1; i <= st1.length(); i++) {
			for (int j = 1; j <= st2.length(); j++) {
				if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
					lcSubstr[i][j] = 1 + lcSubstr[i - 1][j - 1];
				}
				else {
					lcSubstr[i][j] = 0;
				}
				max = Math.max(max, lcSubstr[i][j]);
			}
		}

		System.out.println(max);
		scan.close();
	}
}
