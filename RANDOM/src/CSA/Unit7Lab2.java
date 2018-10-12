/**
 * This program messes with number systems.
 * 
 * @author Justin Kim
 */
package CSA;

public class Unit7Lab2 {
	public static void main(String[] args) {
		int dec = 123;
		String bin = "01111011";
		String hex = "7B";

		System.out.println("B->D   " + binaryToDecimal(bin));
		System.out.println("B->H   " + binaryToHex(bin));
		System.out.println("D->B   " + decimalToBinary(dec));
		System.out.println("D->H   " + decimalToHex(dec));
	}

	public static int binaryToDecimal(String binaryString) {
		int decimal = 0;
		int multiple = 1;
		for (int i = binaryString.length() - 1; i >= 0; i--) {
			if (binaryString.charAt(i) == '1') {
				decimal += multiple;
			}
			multiple *= 2;
		}

		return decimal;
	}

	public static String binaryToHex(String binaryString) {
		String hex = "";
		for (int i = binaryString.length(); i >= 0; i -= 4) {
			int decimal = binaryToDecimal(binaryString.substring(Math.max(i - 4, 0), i));
			if (decimal > 9) {
				hex = (char) (decimal + 55) + "" + hex;
			}
			else {
				hex = decimal + "" + hex;
			}
		}

		return hex;
	}

	public static String decimalToBinary(int decimalNumber) {
		String binary = "";

		while (decimalNumber > 0) {
			if (decimalNumber % 2 == 0) {
				binary = "0" + binary;
			}
			else {
				binary = "1" + binary;
			}
			decimalNumber /= 2;
		}

		return binary;
	}

	public static String decimalToHex(int decimalNumber) {
		return binaryToHex(decimalToBinary(decimalNumber));
	}
}
