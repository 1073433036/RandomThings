
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Awkward_Digits_2011NovBronze2 {
	public static int convert(int base, String[] convertSplit) {
		int k = 0;
		for (int i = 0; i < convertSplit.length; i++)
			k += Integer.parseInt(convertSplit[i]) * Math.pow(base, convertSplit.length - i - 1);
		return k;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("digits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("digits.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		String[] b2split = st.nextToken().split("");
		st = new StringTokenizer(f.readLine());
		String[] b3split = st.nextToken().split("");

		int base210 = convert(2, b2split);
		int base310 = convert(3, b3split);
		for (int i = 0; i < b2split.length; i++) {
			int difference2 = b2split[i].equals("0") ? (int) Math.pow(2, b2split.length - i - 1)
					: -(int) Math.pow(2, b2split.length - i - 1);

			for (int j = 0; j < b3split.length; j++) {
				int difference31;
				int difference32;
				if (b3split[j].equals("0")) {
					difference31 = (int) Math.pow(3, b3split.length - j - 1);
					difference32 = 2 * (int) Math.pow(3, b3split.length - j - 1);
				}
				else if (b3split[j].equals("1")) {
					difference31 = -(int) Math.pow(3, b3split.length - j - 1);
					difference32 = (int) Math.pow(3, b3split.length - j - 1);
				}
				else {
					difference31 = -2 * (int) Math.pow(3, b3split.length - j - 1);
					difference32 = -(int) Math.pow(3, b3split.length - j - 1);
				}

				if (difference2 + base210 == difference31 + base310
						|| difference2 + base210 == difference32 + base310) {
					out.println(base210 + difference2);
					i = b2split.length;
					j = b3split.length;
				}
			}
		}

		out.close();
		f.close();
	}
}