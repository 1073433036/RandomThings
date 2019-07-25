package usacoFinished;

import java.util.Scanner;

public class dance2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numLines = scan.nextInt();
		for (int l = 0; l < numLines; l++) {
			scan.nextInt();
			String line = scan.next();
			int countLeft = 0;
			boolean bad = false;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '>') {
					countLeft++;
				}
				else {
					countLeft--;
				}
				if (countLeft < 0) {
					bad = true;
					break;
				}
			}
			if (countLeft != 0) {
				bad = true;
			}

			if (bad) {
				System.out.println("illegal");
			}
			else {
				System.out.println("legal");
			}
		}

		scan.close();
	}
}
