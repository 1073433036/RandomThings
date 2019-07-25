package scam;

import java.util.HashSet;
import java.util.Scanner;

public class queries {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashSet<Integer> dataset = new HashSet<>();
		int queries = scan.nextInt();
		for (int i = 0; i < queries; i++) {
			int query = scan.nextInt();
			switch (query) {
				case 1:
					dataset.add(scan.nextInt());
					break;
				case 2:
					dataset.remove(scan.nextInt());
					break;
				case 3:
					if (dataset.contains(scan.nextInt())) {
						System.out.println("Yes");
					}
					else {
						System.out.println("No");
					}
					break;
			}
		}

		scan.close();
	}
}
