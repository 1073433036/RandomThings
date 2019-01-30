/**
 * This program catches array index out of bounds exception
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz13Lab2_ArrayIndexOutOfBoundsExceptionCatch {
	public static void main(String[] args) {
		try {
			int[] arr = new int[] { 123 };
			// cant do (arr size=1)
			System.out.println(arr[2]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("have to access array at index below size");
		}
	}

}
