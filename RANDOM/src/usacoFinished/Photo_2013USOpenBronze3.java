
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Photo_2013USOpenBronze3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCows = Integer.parseInt(st.nextToken());
		int numUFPs = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> UFPs = new HashMap<>();
		int[] cowsInvolved = new int[numUFPs];

		for (int i = 0; i < numUFPs; i++) {
			st = new StringTokenizer(f.readLine());
			int p1 = Integer.parseInt(st.nextToken()) - 1;
			int p2 = Integer.parseInt(st.nextToken()) - 1;
			UFPs.put(Math.max(p1, p2), Math.min(p1, p2));
			cowsInvolved[i] = Math.max(p1, p2);
		}

		Arrays.sort(cowsInvolved);
		int min = 0;
		int ans = 1;
		for (int i = 0; i < numUFPs; i++) {
			int cur = cowsInvolved[i];
			if (UFPs.get(cur) >= min && UFPs.get(cur) < cur) {
				ans++;
				min = cur;
			}
		}

		out.println(ans);
		out.close();
		f.close();
	}
}
