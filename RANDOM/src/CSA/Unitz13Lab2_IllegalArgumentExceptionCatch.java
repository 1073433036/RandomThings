/**
 * This program catches illegal argument exception
 * 
 * @author Justin Kim
 */

package CSA;

public class Unitz13Lab2_IllegalArgumentExceptionCatch {
	public static void main(String[] args) {
		try {
			// invalid code point
			Character.toChars(-1);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Make sure the arguments to functions are valid");
		}
	}
}
