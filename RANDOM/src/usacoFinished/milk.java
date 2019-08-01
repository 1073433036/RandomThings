
/*
ID: juskim81
LANG: JAVA
TASK: milk
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class milk {
	private static class farmer implements Comparable<farmer> {
		int amt;
		int price;

		public farmer(int p, int a) {
			amt = a;
			price = p;
		}

		public int compareTo(farmer other) {
			return price - other.price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int milkNeeded = Integer.parseInt(st.nextToken());
		int numFarmers = Integer.parseInt(st.nextToken());
		farmer[] farmers = new farmer[numFarmers];
		for (int i = 0; i < numFarmers; i++) {
			st = new StringTokenizer(f.readLine());
			farmers[i] = new farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(farmers);
		long total = 0;
		int i = 0;
		while (milkNeeded > 0) {
			total += Math.min(milkNeeded, farmers[i].amt) * farmers[i].price * 1l;
			milkNeeded -= Math.min(milkNeeded, farmers[i].amt);
			i++;
		}

		out.println(total);
		out.close();
		f.close();
	}

}
