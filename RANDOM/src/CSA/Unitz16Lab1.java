/**
 * This program checks for palindromes recursively
 * 
 * @author Justin Kim
 */

package CSA;

public class Unitz16Lab1 {
	public static void main(String[] args) {
		System.out.println(testPalindrome("a man, a plan, a canal, panama", 0, 29));
	}

	public static boolean testPalindrome(String test, int startpos, int endpos) {
		if (startpos >= endpos) {
			return true;
		}

		// equal
		if (test.charAt(startpos) == test.charAt(endpos)) {
			return testPalindrome(test, startpos + 1, endpos - 1);
		}

		// non letter
		int letter = test.charAt(startpos);
		if (!(letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122)) {
			return testPalindrome(test, startpos + 1, endpos);
		}
		letter = test.charAt(endpos);
		if (!(letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122)) {
			return testPalindrome(test, startpos, endpos - 1);
		}

		return false;
	}
}
