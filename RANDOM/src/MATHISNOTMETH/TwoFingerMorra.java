package MATHISNOTMETH;

import java.util.Random;
import java.util.Scanner;

public class TwoFingerMorra {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		// double optimal = 7 / 12.0;
		// double predicted1 = p1 > optimal ? 4 - 7 * p1 : 5 * p1 - 3;
		// double predicted2 = p2 > optimal ? 4 - 7 * p2 : 5 * p2 - 3;
		// System.out.println("Theoretical 1 turn: " + (predicted1 + predicted2)
		// / 2);

		// System.out.print("p1 prob: ");
		// double p1 = scan.nextDouble();
		//
		// System.out.print("p2 prob: ");
		// double p2 = scan.nextDouble();

		System.out.print("p1 prob: ");
		String[] p1frac = scan.next().split("/");
		System.out.print("p2 prob: ");
		String[] p2frac = scan.next().split("/");

		double p1 = Integer.parseInt(p1frac[0]) / Double.parseDouble(p1frac[1]);
		double p2 = Integer.parseInt(p2frac[0]) / Double.parseDouble(p2frac[1]);

		int score = 0;
		int times = 10000;

		for (int i = 0; i < times; i++) {
			boolean p11 = rand.nextDouble() < p1;
			boolean p21 = rand.nextDouble() < p2;

			if (p11 == p21) {
				score += p11 ? 2 : 4;
			}
			else {
				score -= 3;
			}
		}

		System.out.println("Experimental score out of " + times + " times: " + score);
		System.out.println("Experimental 1 turn: " + score / (double) times);
		
		
		scan.close();
	}
}
