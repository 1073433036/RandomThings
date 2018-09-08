/**
 * This program/class is a number guessing game.
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unit4Lab1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("What is the maximum number to guess: ");
			int maxGuess = input.nextInt();
			System.out.print("What is the maximum number of guesses you will have: ");
			int maxGuessTries = input.nextInt();
			int correct = (int) (maxGuess * Math.random()) + 1;

			int tries;
			for (tries = 1; tries <= maxGuessTries; tries++) {
				System.out.print("What is your guess: ");
				int guess = input.nextInt();

				if (guess < correct) {
					System.out.println("too low");
				}
				else if (guess > correct) {
					System.out.println("too high");
				}
				else {
					System.out.println("correct");
					System.out.printf("You took %d tries to get the right answer\n", tries);
					break;
				}
			}
			if (tries - 1 == maxGuessTries) {
				System.out.println("The correct answer was " + correct);
			}

			System.out.print("Do you want to play again? (true/false): ");
		}
		while (input.nextBoolean());

		input.close();
	}
}
