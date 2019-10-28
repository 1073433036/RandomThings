
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.math.BigInteger;
import java.io.IOException;

public class Times_17_2012MarchBronze1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("times17.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("times17.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		BigInteger a = new BigInteger(st.nextToken(), 2);

		out.println(a.multiply(new BigInteger("17")).toString(2));
		out.close();
		f.close();
	}
}
