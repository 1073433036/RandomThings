
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Clumsy_Cows_2012NovSilver1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("clumsy.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clumsy.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		String parens = st.nextToken();
		int count = 0;
		int result = 0;
		for (int i = 0; i < parens.length(); i++) {
			if (count == 0) {
				parens = parens.substring(i);
				i = 0;
			}
			char paren = parens.charAt(i);
			if (paren == '(') {
				count++;
			}
			else {
				if (count == 0) {
					count++;
					result++;
				}
				else {
					count--;
				}
			}
		}

		out.println(result + count / 2);
		out.close();
		f.close();
	}
}
