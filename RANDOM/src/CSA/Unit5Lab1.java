/**
 * This program is a financial calculator
 * 
 * @author Justin Kim
 */
package CSA;

import java.util.Scanner;

public class Unit5Lab1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("1: Future Value of a Single Sum");
		System.out.println("2: Present Value of a Single Sum");
		System.out.println("3: Future Value of an Annuity");

		System.out.print("Which one do you want to use(1-3): ");
		int choice = input.nextInt();
		switch (choice) {
			case 1:
				System.out.println("What is the present amount: ");
				double presentDollars = input.nextDouble();
				System.out.println("What is the periodic interest rate: ");
				double periodicInterestRate = input.nextDouble();
				System.out.println("What is the number of periods: ");
				double numYears = input.nextDouble();
				System.out.printf("You will have %.2f dollars.",
						round(FVSS(presentDollars, periodicInterestRate, numYears), 2));
				break;
			case 2:
				System.out.println("What is the future amount: ");
				double futureDollars = input.nextDouble();
				System.out.println("What is the periodic interest rate: ");
				periodicInterestRate = input.nextDouble();
				System.out.println("What is the number of periods: ");
				numYears = input.nextDouble();
				System.out.printf("You have %.2f dollars.",
						round(PVSS(futureDollars, periodicInterestRate, numYears), 2));
				break;
			case 3:
				System.out.println("What is the annuity amount: ");
				double annuity = input.nextDouble();
				System.out.println("What is the periodic interest rate: ");
				periodicInterestRate = input.nextDouble();
				System.out.println("What is the number of periods: ");
				numYears = input.nextDouble();
				System.out.printf("You will have %.2f dollars", round(FVA(annuity, periodicInterestRate, numYears), 2));
				break;
		}

		input.close();
	}

	private static double FVSS(double presentDollars, double periodicInterestRate, double numYears) {
		return presentDollars * Math.pow(1 + periodicInterestRate, numYears);
	}

	private static double PVSS(double futureDollars, double periodicInterestRate, double numYears) {
		return futureDollars / Math.pow(1 + periodicInterestRate, numYears);
	}

	private static double FVA(double annuity, double periodicInterestRate, double numYears) {
		return annuity * (Math.pow(1 + periodicInterestRate, numYears) - 1) / periodicInterestRate;
	}

	private static double round(double value, double places) {
		return Math.floor(value * Math.pow(10, places) + .5) / Math.pow(10, places);
	}
}
