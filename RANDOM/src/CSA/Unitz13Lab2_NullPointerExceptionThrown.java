/**
 * This program will throw a null pointer exception
 * 
 * @author Justin Kim
 *
 */
package CSA;

public class Unitz13Lab2_NullPointerExceptionThrown {
	public static void main(String[] args) throws NullPointerException {
		// cant do this without cast
		int a = (Integer) null;
		System.out.println(a);
	}
}
