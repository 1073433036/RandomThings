
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class planting {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int size = Integer.parseInt(st.nextToken());
		int[] connections = new int[size];
		int max = 0;
		for (int i = 0; i < size - 1; i++) {
			st = new StringTokenizer(f.readLine());
			int f1 = Integer.parseInt(st.nextToken()) - 1;
			int f2 = Integer.parseInt(st.nextToken()) - 1;
			connections[f1]++;
			connections[f2]++;
			max = Math.max(max, Math.max(connections[f1], connections[f2]));
		}

		out.println(max + 1);
		out.close();
		f.close();
	}
}
