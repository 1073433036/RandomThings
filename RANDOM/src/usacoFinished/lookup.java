package usacoFinished;

import java.util.Scanner;
import java.util.Stack;

public class lookup {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCows = scan.nextInt();
		int[] heights = new int[numCows];
		for (int i = 0; i < numCows; i++) {
			heights[i] = scan.nextInt();
		}

		Stack<Integer> indOfHeights = new Stack<>();
		int[] seesUntil = new int[numCows];
		indOfHeights.push(0);
		for (int i = 1; i < numCows; i++) {
			while (!indOfHeights.isEmpty() && heights[i] > heights[indOfHeights.peek()]) {
				seesUntil[indOfHeights.pop()] = i + 1;
			}
			indOfHeights.add(i);
		}

		for (int i = 0; i < numCows; i++) {
			System.out.println(seesUntil[i]);
		}
		scan.close();
	}
}
