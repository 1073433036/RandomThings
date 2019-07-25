package scam;

import java.util.Scanner;
import java.util.Stack;

public class matchingparen {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> parens = new Stack<>();
		String expr = scan.next();
		boolean wrong = false;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				parens.push(c);
			}
			else if (c == '}') {
				if (parens.pop() != '{') {
					wrong = true;
					break;
				}
			}
			else if (c == ']') {
				if (parens.pop() != '[') {
					wrong = true;
					break;
				}
			}
			else if (c == ')') {
				if (parens.pop() != '(') {
					wrong = true;
					break;
				}
			}
		}

		if (wrong) {
			System.out.print("not ");
		}
		System.out.println("valid");

		scan.close();
	}
}
