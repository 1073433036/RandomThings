/**
 * This program throws array index out of bounds exception
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz13Lab2_ArrayIndexOutOfBoundsExceptionThrown {
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		int[] arr = new int[] { 123 };
		// cant do (arr size=1)
		System.out.println(arr[2]);
	}
}
