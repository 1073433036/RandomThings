/**
 * This class/program prints out a bunch of characters and their values in
 * ASCII.
 * 
 * @author Justin Kim
 */
package CSA;

public class Unit2Lab1 {
	public static void main(String[] args) {
		// upper and lower case
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.printf("The character %c has the value %d\n", (char) i, i);
		}
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.printf("The character %c has the value %d\n", (char) i, i);
		}

		// numbers
		for (int i = '0'; i <= '9'; i++) {
			System.out.printf("The character %c has the value %d\n", (char) i, i);
		}

		// characters
		System.out.printf("The character %c has the value %d\n", '+', 43);
		System.out.printf("The character %c has the value %d\n", '-', 45);
		System.out.printf("The character %c has the value %d\n", '_', 95);
		System.out.printf("The character %c has the value %d\n", '=', 61);
		System.out.printf("The character %c has the value %d\n", '&', 38);
		System.out.printf("The character %c has the value %d\n", '@', 64);
		System.out.printf("The character %c has the value %d\n", '#', 35);
		System.out.printf("The character %c has the value %d\n", '$', 36);
		System.out.printf("The character %c has the value %d\n", '?', 63);
		System.out.printf("The character %c has the value %d\n", '>', 62);
		System.out.printf("The character %c has the value %d\n", '<', 60);
		System.out.printf("The character %c has the value %d\n", '|', 124);
		System.out.printf("The character %c has the value %d\n", '!', 33);
		System.out.printf("The character %c has the value %d\n", '~', 126);
		System.out.printf("The character %c has the value %d\n", ' ', 32);

	}
}
