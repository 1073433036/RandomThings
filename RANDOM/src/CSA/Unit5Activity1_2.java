/**
 * This program/class inputs a degree angle and outputs trig values
 * 
 * @author JustinKim
 */

package CSA;

import java.util.Scanner;

public class Unit5Activity1_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Input the angle in degrees: ");
		double degree = input.nextDouble();
		double radian = Math.toRadians(degree);
		double sin = Math.sin(radian);
		double cos = Math.cos(radian);
		double tan = Math.tan(radian);
		System.out.printf("Degrees: %.5f \nRadians: %.5f \nSin: %.5f \nCos: %.5f \nTan: %.5f", degree, radian, sin, cos, tan);

		input.close();
	}
}
