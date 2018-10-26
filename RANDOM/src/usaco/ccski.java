package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class ccski {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ccski.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int i1 = Integer.parseInt(st.nextToken());
		int i2 = Integer.parseInt(st.nextToken());

		out.println(i1 + i2);
		out.close();
		f.close();
	}
}
