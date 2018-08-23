/**
 * This class/program displays a monetary amount split into dollars and coins.
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unit2Lab2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter some money amount: ");
		double money = input.nextDouble();
		int d = (int) money;

		int cents = (int) (money * 100) % 100;
		int q = cents / 25;
		cents %= 25;
		int di = cents / 10;
		cents %= 10;
		int n = cents / 5;
		cents %= 5;
		int p = cents;
		System.out.printf("$%.2f consists of %d dollars, %d quarters, %d dimes, %d nickels, %d pennies", money, d, q, di,
				n, p);
	}
}
