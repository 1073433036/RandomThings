/**
 * This class/program is a multiplication game
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unit4Activity1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many problems do you want?");
		int problemNum = input.nextInt();

		long startTime = System.currentTimeMillis();

		int correct = 0;
		for (int i = 0; i < problemNum; i++) {
			// Generate 2 random numbers that will be multiplied
			int num1 = (int) (Math.random() * 10);
			int num2 = (int) (Math.random() * 10);

			// Prompt user to input answer
			System.out.print("What is " + num1 + " * " + num2 + "? ");
			int guess = input.nextInt();

			// Grade the answer
			if ((num1 * num2) == guess) {
				System.out.println("Congratulations...you are correct!");
				correct++;
			}
			else {
				System.out.println("The correct answer was: " + num1 * num2);
			}

			System.out.printf("Your score: %03.1f%% \n", correct / (i + 1.0) * 100);
		}

		System.out.printf("You took %d seconds to finish the quiz.", (System.currentTimeMillis() - startTime) / 1000);
		
		input.close();
	}

}
