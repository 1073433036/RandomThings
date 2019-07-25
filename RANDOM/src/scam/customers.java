package scam;

import java.util.LinkedList;
import java.util.Scanner;

public class customers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numDesks = scan.nextInt();
		LinkedList<Integer> line = new LinkedList<>();
		int[][] desks = new int[numDesks][10000];
		int[] deskends = new int[numDesks];
		while (scan.hasNext()) {
			if (scan.next().equals("C")) {
				line.add(scan.nextInt());
			}
			else {
				int desk = scan.nextInt() - 1;
				desks[desk][deskends[desk]++] = line.poll();
			}
		}

		for (int i = 0; i < numDesks; i++) {
			for (int j = 0; j < deskends[i]; j++) {
				System.out.print(desks[i][j] + " ");
			}
			System.out.println();
		}
		scan.close();
	}
}
