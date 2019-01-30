/**
 * This program catches class cast exception
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz13Lab2_ClassCastExceptionCatch {
	public static void main(String[] args) {
		try {
		TestA[] arr = new TestA[] { new TestB(), new TestC() };
		// casting testb to castc
		TestA test = (TestC) (arr[0]);
		}
		catch(ClassCastException e) {
			System.out.println("dont cast to classes that are not related");
		}
	}
}
