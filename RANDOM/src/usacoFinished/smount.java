package usacoFinished;

import java.util.Scanner;

public class smount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numMeasures = scan.nextInt();
		int[] heights = new int[numMeasures];
		for (int i = 0; i < numMeasures; i++) {
			heights[i] = scan.nextInt();
		}

		int[] lefts = new int[numMeasures];
		lefts[0] = 0;
		for (int i = 1; i < numMeasures; i++) {
			if (heights[i] >= heights[i - 1]) {
				lefts[i] = lefts[i - 1] + 1;
			}
			else {
				lefts[i] = 0;
			}
		}

		int[] rights = new int[numMeasures];
		rights[numMeasures - 1] = 0;
		for (int i = numMeasures - 2; i >= 0; i--) {
			if (heights[i] >= heights[i + 1]) {
				rights[i] = rights[i + 1] + 1;
			}
			else {
				rights[i] = 0;
			}
		}

		int max = 0;
		for (int i = 0; i < numMeasures; i++) {
			max = Math.max(max, lefts[i] + rights[i]);
		}

		System.out.println(max + 1);
		scan.close();
	}
}
