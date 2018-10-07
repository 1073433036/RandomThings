/**
 * This program does things with arrays using the array tools class
 * 
 * @author Justin Kim
 */

package CSA;

public class Unit6Lab2_ArrayToolsTest {

	public static void main(String[] args) {
		int[] intarray = { 1, 23, 12, 31, 24012, 1, 24012, 31 };
		double[] doublearray = { 12.2341, 23, 42.34, 341.23, 42341, 234.23, 12.34213, 4.234, 1234.132, 4 };
		char[] chararray = { 'm', 's', 'a', 'd', 'f', 't', '6', '1', '$' };

		System.out.println("Char min: " + Unit6Lab2_ArrayTools.minimum(chararray));
		System.out.println("Int min: " + Unit6Lab2_ArrayTools.minimum(intarray));
		System.out.println("Double min: " + Unit6Lab2_ArrayTools.minimum(doublearray));
		System.out.println("Char max: " + Unit6Lab2_ArrayTools.maximum(chararray));
		System.out.println("Int max: " + Unit6Lab2_ArrayTools.maximum(intarray));
		System.out.println("Double max: " + Unit6Lab2_ArrayTools.maximum(doublearray));
		System.out.println("Char min loc: " + Unit6Lab2_ArrayTools.minimumAt(chararray));
		System.out.println("Int min loc: " + Unit6Lab2_ArrayTools.minimumAt(intarray));
		System.out.println("Double min loc: " + Unit6Lab2_ArrayTools.minimumAt(doublearray));
		System.out.println("Char max loc: " + Unit6Lab2_ArrayTools.maximumAt(chararray));
		System.out.println("Int max loc: " + Unit6Lab2_ArrayTools.maximumAt(intarray));
		System.out.println("Double max loc: " + Unit6Lab2_ArrayTools.maximumAt(doublearray));
		System.out.println("Int avg: " + Unit6Lab2_ArrayTools.average(intarray));
		System.out.println("Double avg: " + Unit6Lab2_ArrayTools.average(doublearray));

	}

}
