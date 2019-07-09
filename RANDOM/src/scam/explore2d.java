package scam;

import java.util.HashSet;
import java.util.Scanner;

public class explore2d {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for (int t = 0; t < testCase; t++) {
			int sx = scan.nextInt();
			int sy = scan.nextInt();
			int q = scan.nextInt();
			HashSet<Long> visited = new HashSet<>();
			for (int i = 0; i < q; i++) {
				int dir = scan.nextInt();
				int dist = scan.nextInt();
				boolean crosses = false;
				for (int j = 0; j < dist; j++) {
					if (dir == 0) {
						sx++;
					}
					if (dir == 1) {
						sy++;
					}
					if (dir == 2) {
						sx--;
					}
					if (dir == 3) {
						sy--;
					}
					if (visited.contains(sx * 10000000l + sy)) {
						crosses = true;
						break;
					}
					visited.add(sx * 10000000l + sy);
				}
				System.out.println(crosses ? "yes" : "no");
			}
		}

		scan.close();
	}
}
