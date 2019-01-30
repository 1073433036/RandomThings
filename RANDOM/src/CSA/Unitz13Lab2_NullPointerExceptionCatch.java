/**
 * This program catches a null pointer exception
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz13Lab2_NullPointerExceptionCatch {
	public static void main(String[] args) {
		try {
			// cant do this without cast
			int a = (Integer) null;
			System.out.println(a);
		}
		catch (NullPointerException e) {
			System.out.println("You can't use something with a null value");
		}
	}
}
