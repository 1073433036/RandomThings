/**
 * This program throws illegal argument exception
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz13Lab2_IllegalArgumentExceptionThrown {
	public static void main(String[] args) throws IllegalArgumentException {
		// invalid code point
		Character.toChars(-1);
	}
}
