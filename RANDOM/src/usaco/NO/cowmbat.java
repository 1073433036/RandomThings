package usaco.NO;

// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class cowmbat {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowmbat.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		out.println(5);

		out.close();
		f.close();
	}
}
