package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class knapsack {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("knapsack1.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Scanner scan = new Scanner(System.in);
		// int numItems = scan.nextInt();
		// int capacity = scan.nextInt();
		int capacity = Integer.parseInt(st.nextToken());
		int numItems = Integer.parseInt(st.nextToken());
		int[][] sums = new int[numItems + 1][capacity + 1];
		// sums[i][j]= max value given i items and j capacity
		// sum[i][j]=Max(sum[i-1][j], sum[i-1][j-sizei]+vali)

		for (int i = 1; i <= numItems; i++) {
			// int sizei = scan.nextInt();
			// int vali = scan.nextInt();
			st = new StringTokenizer(f.readLine());
			int vali = Integer.parseInt(st.nextToken());
			int sizei = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= capacity; j++) {
				if (j - sizei >= 0) {
					sums[i][j] = sums[i - 1][j - sizei] + vali;
				}
				sums[i][j] = Math.max(sums[i][j], sums[i - 1][j]);
			}
		}

		System.out.println(sums[numItems][capacity]);

		// scan.close();
		f.close();
	}
}
// 2493893,4243395
