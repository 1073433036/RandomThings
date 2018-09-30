/**
 * This program prints the max and min of 3 numbers 3 times
 */

package CSA;

public class Unit5Lab3_1 {
	public static void main(String[] args) {
		double min = minimum(10123.123, 20.2, 30.2);
		double max = maximum(10123.123, 20.2, 30.2);
		System.out.println("Min: " + min + "  Max: " + max);

		min = minimum(10123, 2.2, 0.2);
		max = maximum(10123, 2.2, 0.2);
		System.out.println("Min: " + min + "  Max: " + max);

		min = minimum(1.123, 20, 2);
		max = maximum(1.123, 20, 2);
		System.out.println("Min: " + min + "  Max: " + max);

	}

	private static double minimum(double a, double b, double c) {
		return Math.min(a, Math.min(b, c));
	}

	private static double maximum(double a, double b, double c) {
		return Math.max(a, Math.max(b, c));
	}
}
