package usacoFinished;

import java.util.Scanner;

public class StringTokenizer {
	public StringTokenizer(String str) {
	}

	public static Scanner tester = new Scanner(System.in);

	public String nextToken() {
		return tester.next();
	}

	public String readLine() {
		return "";
	}

	public static void close() {
		tester.close();
	}
}
