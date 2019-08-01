package scam;

import java.util.Scanner;

public class maxsubarrayproduct {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numNums = scan.nextInt();
		long total = scan.nextInt();
		long negtotal = 1;
		long max = -1000000000;
		for (int i = 1; i < numNums; i++) {
			int cur = scan.nextInt();
			long ntotal = Math.max(cur, Math.max(cur * total, cur * negtotal));
			long nnegtotal = Math.min(cur, Math.min(cur * total, cur * negtotal));
			total = ntotal;
			negtotal = nnegtotal;
			System.out.println(total + " " + negtotal);
			max = Math.max(max, Math.max(total, negtotal));
		}

		System.out.println(max);
		scan.close();
	}
}
