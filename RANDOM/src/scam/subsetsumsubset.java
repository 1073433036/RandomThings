package scam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class subsetsumsubset {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		int target = scan.nextInt();
		int[] items = new int[numItems + 1];
		for (int i = 1; i <= numItems; i++) {
			items[i] = scan.nextInt();
		}

		boolean[][] possible = new boolean[numItems + 1][target + 1];
		possible[0][0] = true;
		for (int i = 1; i <= numItems; i++) {
			for (int j = 0; j <= target; j++) {
				if (j - items[i] < 0) {
					possible[i][j] = possible[i - 1][j];
				}
				else {
					possible[i][j] = possible[i - 1][j] || possible[i - 1][j - items[i]];
				}
			}
		}

		int i = numItems;
		int j = target;
		ArrayList<Integer> used = new ArrayList<>();
		while (j != 0) {
			while (possible[i - 1][j]) {// && !possible[i - 1][j - items[i]]
										// if you want last numbers possible
				i--;
			}
			used.add(i);
			j -= items[i];
			i--;
		}

		Collections.sort(used);
		for (int k = 0; k < used.size(); k++) {
			System.out.print(used.get(k) + " ");
		}

		scan.close();
	}
}
