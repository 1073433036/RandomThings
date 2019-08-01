

/*
ID: juskim81
LANG: JAVA
TASK: dualpal
 */
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numFind = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken()) + 1;

		int count = 0;
		while (count < numFind) {
			int palindromes = 0;
			for (int i = 0; i < 9; i++) {
				if (palindrome(convert(start, i + 2))) {
					palindromes++;
				}
				if (palindromes == 2) {
					break;
				}
			}
			if (palindromes == 2) {
				out.println(start);
				count++;
			}
			start++;
		}

		out.close();
		f.close();
	}

	public static boolean palindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String convert(int num, int base) {
		String numBase = "";
		// algorithm for converting numbers into different bases
		while (true) {
			String digit = "" + num % base;
			if (num % base >= 10) {
				digit = "" + (char) (num % base + 55);
			}
			numBase = digit + numBase;
			num /= base;

			// exit loop
			if (num == 0)
				return numBase;
		}
	}
}
