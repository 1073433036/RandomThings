/**
 * This catches divide by 0 exceptions
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Scanner;

public class Unitz13Lab1_CatchExceptions6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			try {
				System.out.print("num1: ");
				int x = input.nextInt();
				System.out.print("num2: ");
				int y = input.nextInt();
				System.out.println(divide(x, y));
			}
			catch (DivideByZeroException e) {
				System.out.println(e);
				continue;
			}
			break;
		}
	}

	// if y isn't 0 return x/y
	public static int divide(int x, int y) throws DivideByZeroException {
		int result = 90;
		try {
			result = x / y;
		}
		catch (ArithmeticException e) {
			throw new DivideByZeroException(y);
		}
		return result;
	}
}

class DivideByZeroException extends Exception {
	private int denom;

	public DivideByZeroException() {
	}

	public DivideByZeroException(String s) {
		super(s);
	}

	public DivideByZeroException(int d) {
		super("div by zero");
		denom = d;

	}

	// returns denominator
	public int getDenomminator() {
		return denom;
	}
}