//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class planting {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken()) - 1;

		int[] degrees = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			degrees[Integer.parseInt(st.nextToken()) - 1]++;
			degrees[Integer.parseInt(st.nextToken()) - 1]++;
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, degrees[i]);
		}

		out.println(max + 1);
		out.close();
		f.close();
	}

}
