/**
 * This program does things with arrays using the array tools class
 * 
 * @author Justin Kim
 */

package CSA;

import java.util.Arrays;

public class Unit6Lab3_ArrayToolsTest2 {

	public static void main(String[] args) {
		int[] intarray1 = { 1, 23, 12, 31, 24012, 1, 24012, 31 };
		int[] intarray2 = { 1, 23, 12, 31, 24012, 1, 24012, 31 };
		double[] doublearray1 = { 12.2341, 23, 42.34, 341.23, 42341, 234.23, 12.34213, 4.234, 1234.132, 4 };
		double[] doublearray2 = { 12.2341, 23, 42.34, 341.23, 42341, 234.23, 12.34213, 4.234, 1234.132, 4 };
		char[] chararray1 = { 'm', 's', 'a', 'd', 'f', 't', '6', '1', '$' };
		char[] chararray2 = { 'm', 's', 'a', 'd', 'f', 't', '6', '1', '$' };

		System.out.println(Unit6Lab3_ArrayTools.equals(chararray1, chararray2));
		System.out.println(Unit6Lab3_ArrayTools.equals(intarray1, intarray2));
		System.out.println(Unit6Lab3_ArrayTools.equals(doublearray1, doublearray2));
		System.out.println(Unit6Lab3_ArrayTools.find(chararray1, '$'));
		System.out.println(Unit6Lab3_ArrayTools.find(intarray1, 1));
		System.out.println(Unit6Lab3_ArrayTools.find(doublearray1, -1));
		Unit6Lab3_ArrayTools.sort(chararray1);
		Unit6Lab3_ArrayTools.sort(intarray1);
		Unit6Lab3_ArrayTools.sort(doublearray1);
		System.out.println(Arrays.toString(chararray1));
		System.out.println(Arrays.toString(intarray1));
		System.out.println(Arrays.toString(doublearray1));

	}

}
