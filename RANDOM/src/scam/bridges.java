package scam;

import java.util.Arrays;
import java.util.Scanner;

class city implements Comparable<city> {
	int x1;
	int x2;

	public city(int x1, int x2) {
		this.x1 = x1;
		this.x2 = x2;
	}

	public int compareTo(city b) {
		return x1 - b.x1;
	}

}

public class bridges {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCities = scan.nextInt();

		city[] cities = new city[numCities];
		for (int i = 0; i < numCities; i++) {
			cities[i] = new city(scan.nextInt(), scan.nextInt());
		}
		Arrays.sort(cities);
		int[] lis = new int[numCities];
		int max = 0;
		for (int i = 0; i < numCities; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (cities[j].x2 < cities[i].x2) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			max = Math.max(max, lis[i]);
		}

		System.out.println(max);
		scan.close();
	}
}
