package usacoFinished;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.PrintWriter;
// import java.util.StringTokenizer;

import java.io.IOException;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class Hay_Bales_2011DecBronze1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numBales = Integer.parseInt(st.nextToken());
		int[] bales = new int[numBales];
		int average = 0;
		for (int i = 0; i < numBales; i++) {
			st = new StringTokenizer(f.readLine());
			bales[i] = Integer.parseInt(st.nextToken());
			average += bales[i];
		}

		average /= numBales;

		int total = 0;
		for (int i = 0; i < numBales; i++) {
			if (bales[i] > average) {
				total += bales[i] - average;
			}
		}
		
		out.println(total);
		out.close();
		f.close();
	}
}
