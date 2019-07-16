
package usaco.NO;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;

public class mountains {
	private static class mountain implements Comparable<mountain> {
		int height;
		int x;

		public mountain(int x, int h) {
			this.x = x;
			height = h;
		}

		public int compareTo(mountain o) {
			return x - height - (o.x - o.height);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int size = Integer.parseInt(st.nextToken());
		mountain[] mts = new mountain[size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(f.readLine());
			mts[i] = new mountain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(mts);

		int count = 0;
		for (int i = 1; i < size; i++) {
			if (mts[i].height <= mts[i - 1].height) {
				count++;
			}
		}

		out.println(size - count);
		out.close();
		f.close();
	}
}
