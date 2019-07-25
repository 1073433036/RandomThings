/*
ID: juskim81
LANG: JAVA
TASK: beads
 */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numBeads = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		String necklace = st.nextToken();
		necklace = necklace + necklace + necklace;
		System.out.println(necklace);
		int max = 0;
		for (int i = numBeads; i < numBeads * 2; i++) {
			int count = 0;
			int j = i;
			char color = 'w';
			while (j >= 0 && (necklace.charAt(j) == color || color == 'w' || necklace.charAt(j) == 'w')) {
				if (necklace.charAt(j) != 'w') {
					color = necklace.charAt(j);
				}
				count++;
				j--;
			}
			System.out.print(count + " ");
			j = i + 1;
			color = 'w';
			while (j < necklace.length()
					&& (necklace.charAt(j) == color || color == 'w' || necklace.charAt(j) == 'w')) {
				if (necklace.charAt(j) != 'w') {
					color = necklace.charAt(j);
				}
				count++;
				j++;
			}
			System.out.println(count);
			if (count > numBeads) {
				max = numBeads;
				break;
			}
			max = Math.max(max, count);
		}
		out.println(max);
		out.close();
		f.close();
	}
}
