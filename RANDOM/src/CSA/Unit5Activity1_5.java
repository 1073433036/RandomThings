/**
 * This program rounds a division operation.
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unit5Activity1_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Input first number: ");
		double x = input.nextDouble();
		System.out.print("Input second number: ");
		double y = input.nextDouble();
		int i = (int) Math.floor((x / y) + .5);
		double p1 = Math.floor((x / y) * 10 + .5) / 10;
		double p2 = Math.floor((x / y) * 100 + .5) / 100;
		double p3 = Math.floor((x / y) * 1000 + .5) / 1000;
		System.out.println("Integer: " + i);
		System.out.println("One place: " + p1);
		System.out.println("Two places: " + p2);
		System.out.println("Three places: " + p3);

		input.close();
	}
}
