
/*
ID: juskim81
LANG: JAVA
TASK: namenum
 */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.TreeMap;

public class namenum {
	public static void main(String[] args) throws IOException {
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		TreeMap<String, Long> names = new TreeMap<>();
		while (dict.ready()) {
			String cur = dict.readLine();
			String val = "";
			for (int j = 0; j < cur.length(); j++) {
				int letter = cur.charAt(j) - 64;
				if (letter <= 16) {
					val += (1 + (int) Math.ceil(letter / 3.0));
				}
				else if (letter <= 19) {
					val += 7;
				}
				else if (letter <= 22) {
					val += 8;
				}
				else {
					val += 9;
				}
			}
			names.put(cur, Long.parseLong(val));
		}

		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		long cow = Long.parseLong(st.nextToken());
		boolean found = false;
		for (String name : names.keySet()) {
			if (names.get(name) == cow) {
				out.println(name);
				found = true;
			}
		}
		if (!found) {
			out.println("NONE");
		}

		out.close();
		f.close();
		dict.close();
	}
}
