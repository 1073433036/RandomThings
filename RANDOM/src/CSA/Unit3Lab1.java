/**
 * 
 * This program/class takes in 3 numbers and outputs the type of triangle the 3
 * numbers form.
 * 
 * @author Justin Kim
 * 
 */

package CSA;

import java.util.Scanner;

public class Unit3Lab1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3 integer values for the sides of a triangle: ");
		int s1 = input.nextInt();
		int s2 = input.nextInt();
		int s3 = input.nextInt();
		int max = Math.max(s1, Math.max(s2, s3));
		int sum = s1 + s2 + s3;

		System.out.println("Side 1: " + s1 + "\nSide 2: " + s2 + "\nSide 3: " + s3);

		if (s1 > 0 && s2 > 0 && s3 > 0 && sum - max > max) {
			if (s1 == s2 && s2 == s3) {
				System.out.println("This is a equilateral triangle");
			}
			else if (s1 == s2 || s2 == s3 || s1 == s3) {
				System.out.println("This is a isosceles triangle");
			}
			else {
				System.out.println("This is a scalene triangle");
			}
		}
		else {
			System.out.println("The values entered do not make a valid triangle");
		}

		input.close();

	}
}
