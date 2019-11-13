
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class Moo_2012FebBronze3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("moo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int index = Integer.parseInt(st.nextToken());
		// Moo
		// Moomooomoo
		// Moomooomoomoooomoomooomoo

		while (index > 3) {
			int position = 3;
			int iteration = 4;
			while (position * 2 + iteration < index) {
				position += position + iteration;
				iteration++;
			}

			if (index > position + iteration) {
				index -= position + iteration;
			}
			else if (index > position) {
				if (index - position == 1) {
					index = 1;
				}
				else {
					index = 2;
				}
			}
		}
		if (index == 1) {
			out.println('m');
		}
		else {
			out.println('o');
		}
		out.close();
		f.close();
	}
}
