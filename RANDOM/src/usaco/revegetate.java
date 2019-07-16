package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import org.ejml.equation.IntegerSequence;

import java.io.IOException;

public class revegetate {
	private static class Cow {
		boolean same;
		int f1;
		int f2;

		public Cow(boolean same, int f1, int f2) {
			this.same = same;
			this.f1 = f1;
			this.f2 = f2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] fields = new int[Integer.parseInt(st.nextToken())];
		Cow[] cows = new Cow[Integer.parseInt(st.nextToken())];
		boolean[] visited = new boolean[cows.length];
		for (int i = 0; i < cows.length; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = new Cow(st.nextToken().equals("S"), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		

		out.println();
		out.close();
		f.close();
	}
}
