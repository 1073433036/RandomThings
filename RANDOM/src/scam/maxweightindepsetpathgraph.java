package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class maxweightindepsetpathgraph {
	static int[] path;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mwis.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int V = Integer.parseInt(st.nextToken());
		path = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(f.readLine());
			path[i] = Integer.parseInt(st.nextToken());
		}
		max = new long[V + 1];
		max[1] = path[1];
		for (int i = 2; i <= V; i++) {
			max[i] = Math.max(max[i - 1], max[i - 2] + path[i]);
		}

		boolean[] in = new boolean[V + 1];
		for (int i = V; i >= 1; i--) {
			if (max[i] != max[i - 1]) {
				in[i] = true;
				i--;
			}
		}
		System.out.println(in[1]);
		System.out.println(in[2]);
		System.out.println(in[3]);
		System.out.println(in[4]);
		System.out.println(in[17]);
		System.out.println(in[117]);
		System.out.println(in[517]);
		System.out.println(in[997]);
		f.close();
	}

	// 10100110
	static long[] max;

}
