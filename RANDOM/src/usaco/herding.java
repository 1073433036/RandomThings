package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class herding {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("herding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int size = Integer.parseInt(st.nextToken());
		int[] locs = new int[size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(f.readLine());
			locs[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(locs);

		int min = size;
		if ((locs[size - 2] - locs[0] == size - 2 && locs[size - 1] - locs[size - 2] > 2)
				|| (locs[size - 1] - locs[1] == size - 2 && locs[1] - locs[0] > 2)) {
			min = 2;
		}
		else {
			int count = 0;
			for (int i = 0; i < size; i++) {
				while (i + count < size && locs[i] + size > locs[i + count]) {
					count++;
				}
				min = Math.min(size - count, min);
				count--;
			}
		}

		out.println(min);
		out.println(Math.max(locs[size - 1] - locs[1], locs[size - 2] - locs[0]) - (size - 2));
		out.close();
		f.close();
	}
}
