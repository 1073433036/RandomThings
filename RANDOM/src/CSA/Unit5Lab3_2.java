/**
 * This program takes in 4 test grades for 3 people and calculates the grades
 */

package CSA;

import java.util.Scanner;

public class Unit5Lab3_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int student = 1; student <= 3; student++) {
			inputAndDisplay(student, input);
		}

		input.close();
	}

	private static void inputAndDisplay(int student, Scanner input) {

		System.out.print("What is test score 1 for student " + student + ": ");
		double score = input.nextDouble();
		double min = score;
		double max = score;
		double sum = score;
		for (int i = 2; i <= 4; i++) {
			System.out.print("What is test score " + i + " for student " + student + ": ");
			score = input.nextDouble();
			min = Math.min(min, score);
			max = Math.max(max, score);
			sum += score;
		}

		double avg = round(sum / 4, 1);

		System.out.println("Max Score: " + max);
		System.out.println("Min Score: " + min);
		System.out.println("Average Score: " + avg);
		displayLetterGrade(avg);

	}

	private static void displayLetterGrade(double avg) {
		int iavg = (int) Math.round(avg);
		if (iavg >= 90) {
			System.out.println("Grade: A");
			return;
		}
		if (iavg >= 80) {
			System.out.println("Grade: B");
			return;
		}
		if (iavg >= 70) {
			System.out.println("Grade: C");
			return;
		}
		if (iavg >= 65) {
			System.out.println("Grade: D");
			return;
		}
		System.out.println("Grade: F");
	}

	private static double round(double value, int places) {
		int pow10 = (int) Math.pow(10, places);
		return Math.floor(pow10 * value + .5) / pow10;
	}
}
