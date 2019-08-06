package scam;

import java.util.Scanner;

public class wafflechoppers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numrows = scan.nextInt();
		int numcols = scan.nextInt();
		int numhor = scan.nextInt();
		int numver = scan.nextInt();
		boolean[][] waffle = new boolean[numrows][numcols];
		int count = 0;
		for (int i = 0; i < numrows; i++) {
			String line = scan.next();
			for (int j = 0; j < numcols; j++) {
				waffle[i][j] = line.charAt(j) == '@';
				if (waffle[i][j]) {
					count++;
				}
			}
		}
		int customers = (numhor + 1) * (numver + 1);
		int chips = count / customers;
		if (count == 0) {
			System.out.println("POSSIBLE");
			scan.close();
			return;
		}

		if (count % customers != 0) {
			System.out.println("IMPOSSIBLE");
			scan.close();
			return;
		}

		int[] psumv = new int[numcols];
		int[] psumh = new int[numrows];
		int[] vcut = new int[numver];
		int[] hcut = new int[numhor];

		for (int i = 0; i < numcols; i++) {
			for (int j = 0; j < numrows; j++) {
				psumv[i] += waffle[j][i] ? 1 : 0;
			}
			if (i != 0) {
				psumv[i] += psumv[i - 1];
			}
		}

		for (int i = 0; i < numrows; i++) {
			for (int j = 0; j < numcols; j++) {
				psumh[i] += waffle[i][j] ? 1 : 0;
			}
			if (i != 0) {
				psumh[i] += psumh[i - 1];
			}
		}

		int pervcut = chips * (numhor + 1);
		int vcuts = 0;
		for (int i = 0; i < numcols; i++) {
			if (psumv[i] % pervcut == 0 && psumv[i] != 0) {
				vcut[vcuts++] = i;
			}
			if (vcuts == numver) {
				break;
			}
		}

		int perhcut = chips * (numver + 1);
		int hcuts = 0;
		for (int i = 0; i < numrows; i++) {
			if (psumh[i] % perhcut == 0 && psumh[i] != 0) {
				hcut[hcuts++] = i;
			}
			if (hcuts == numhor) {
				break;
			}
		}

		int[][] customercounts = new int[vcuts + 1][hcuts + 1];
		int vc = 0;
		int hc = 0;
		for (int i = 0; i < numrows; i++) {
			vc = 0;
			for (int j = 0; j < numcols; j++) {
				customercounts[vc][hc] += waffle[i][j] ? 1 : 0;
				if (vc < numver && vcut[vc] == j) {
					vc++;
				}
			}
			if (hc < numhor && hcut[hc] == i) {
				hc++;
			}
		}

		for (int i = 0; i < vcuts + 1; i++) {
			for (int j = 0; j < hcuts + 1; j++) {
				if (customercounts[i][j] != chips) {
					System.out.println("IMPOSSIBLE");
					scan.close();
					return;
				}
			}
		}

		System.out.println("POSSIBLE");
		scan.close();
	}
}
