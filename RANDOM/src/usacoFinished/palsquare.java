
/*
ID: juskim81
LANG: JAVA
TASK: palsquare
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class palsquare {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int base = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 300; i++) {
			String square = convert(i * i, base);
			if (palindrome(square)) {
				out.println(convert(i, base) + " " + square);
			}
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
