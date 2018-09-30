/**
 * This program counts the times a number between 1 and 50 is inputted
 * 
 * @author JustinKim
 */

package CSA;

import java.util.Scanner;

public class Unit6Lab1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("How many integers do you want: ");
		int numInts = input.nextInt();

		int[] counter = new int[50];
		for (int i = 0; i < numInts; i++) {
			System.out.print("Input an integer: ");
			counter[input.nextInt()]++;
		}

		for (int i = 0; i < 50; i++) {
			if (counter[i] > 0) {
				System.out.println(i + " occurs " + counter[i] + " times");
			}
		}

		input.close();
	}

}
