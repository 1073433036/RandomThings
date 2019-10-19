
//package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;


public class Gifts_2012JanBronze1 {
	public static class cow implements Comparable<cow> {
		int price;
		int shipping;

		public cow(int p, int s) {
			price = p;
			shipping = s;
		}

		public int compareTo(cow other) {
			return price + shipping - other.price - other.shipping;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gifts.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gifts.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numCows = Integer.parseInt(st.nextToken());
		int budget = Integer.parseInt(st.nextToken());
		cow[] cows = new cow[numCows];
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);

		int count = 0;
		int i = 0;
		for (; i < numCows && budget >= 0; i++) {
			int totalprice = cows[i].price + cows[i].shipping;
			if (budget >= totalprice) {
				budget -= totalprice;
				count++;
			}
			else {
				break;
			}
		}

		for (; i < numCows && budget >= 0; i++) {
			if (budget >= cows[i].price / 2 + cows[i].shipping) {
				count++;
				break;
			}
		}

		out.println(count);
		out.close();
		f.close();
	}
}
