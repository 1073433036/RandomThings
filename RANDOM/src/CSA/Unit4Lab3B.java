/**
 * This program/class finds the max and min of 10 inputted numbers.
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unit4Lab3B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Input a number: ");
		int smallest = input.nextInt();
		int largest = smallest;
		for (int counter = 1; counter < 10; counter++) {
			System.out.print("Input a number: ");
			int number = input.nextInt();
			smallest = Math.min(smallest, number);
			largest = Math.max(largest, number);
		}

		System.out.println("The largest number was: " + largest);
		System.out.println("The smallest number was: " + smallest);

		input.close();
	}
}
