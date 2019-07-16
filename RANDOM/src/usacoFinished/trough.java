package usacoFinished;

import java.util.BitSet;
import java.util.Scanner;

public class trough {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numTroughs = scan.nextInt();
		int numAllCombos = (int) Math.pow(2, numTroughs);
		int numQuestions = scan.nextInt();
		int[] questions = new int[numQuestions];
		int[] answers = new int[numQuestions];
		for (int i = 0; i < numQuestions; i++) {
			questions[i] = Integer.parseInt(scan.next(), 2);
			answers[i] = scan.nextInt();
		}

		int numpossible = 0;
		int output = 0;
		for (int i = 0; i < numAllCombos; i++) {
			boolean works = true;
			for (int j = 0; j < numQuestions; j++) {
				BitSet b = BitSet.valueOf(new long[] { i & questions[j] });
				if (b.cardinality() != answers[j]) {
					works = false;
				}
			}
			if (works) {
				numpossible++;
				output = i;
			}
		}

		if (numpossible == 0) {
			System.out.println("IMPOSSIBLE");
		}
		else if (numpossible == 1) {
			System.out.println(Integer.toBinaryString(output));
		}
		else {
			System.out.println("NOT UNIQUE");
		}

		scan.close();
	}
}
