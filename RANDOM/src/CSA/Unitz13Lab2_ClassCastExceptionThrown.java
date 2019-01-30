/**
 * This program throws class cast exception
 * 
 * @author Justin Kim
 */
package CSA;

public class Unitz13Lab2_ClassCastExceptionThrown {
	public static void main(String[] args) throws ClassCastException {
		TestA[] arr = new TestA[] { new TestB(), new TestC() };
		// casting testb to castc
		TestA test = (TestC) (arr[0]);
	}
}

class TestA {

}

class TestB extends TestA {

}

class TestC extends TestA {

}