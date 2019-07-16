/*
ID: juskim81
LANG: JAVA
TASK: ride
 */
import java.io.IOException;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ride {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		String comet = st.nextToken();
		st = new StringTokenizer(f.readLine());
		String group = st.nextToken();
		long cometEncode = 1;
		long groupEncode = 1;
		for (int i = 0; i < comet.length(); i++) {
			int encoding = comet.charAt(i) - 64;
			cometEncode *= encoding;
		}
		for (int i = 0; i < group.length(); i++) {
			int encoding = group.charAt(i) - 64;
			groupEncode *= encoding;
		}
		boolean go = cometEncode % 47 == groupEncode % 47;
		if (go) {
			out.println("GO");
		}
		else {
			out.println("STAY");
		}
		out.close();
		f.close();
	}
}
