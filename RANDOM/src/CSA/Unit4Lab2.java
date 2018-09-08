/**
 * This program/class makes a triangle of astericks
 * 
 * @author Justin Kim
 */
package CSA;

import java.util.Scanner;

public class Unit4Lab2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many astericks in the first line: ");
		int astNum = input.nextInt();
		for (; astNum >= 0; astNum--) {
			for (int i = 0; i < astNum; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

		input.close();
	}
}
