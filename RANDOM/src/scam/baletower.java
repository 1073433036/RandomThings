package scam;

import java.util.Arrays;
import java.util.Scanner;

public class baletower {
	private static class bale implements Comparable<bale> {
		int w;
		int d;

		public bale(int w, int d) {
			this.w = w;
			this.d = d;
		}

		public int compareTo(bale other) {
			if (other.w == w) {
				return other.d - d;
			}
			return other.w - w;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numBales = scan.nextInt();
		bale[] bales = new bale[numBales];

		for (int i = 0; i < numBales; i++) {
			int w = scan.nextInt();
			int d = scan.nextInt();
			bales[i] = new bale(w, d);
		}

		Arrays.sort(bales);

		int[] stackheight = new int[numBales];
		int max = 0;
		for (int i = 0; i < numBales; i++) {
			stackheight[i] = 1;
			for (int j = 0; j < i; j++) {
				if (bales[j].d > bales[i].d) {
					stackheight[i] = Math.max(stackheight[i], stackheight[j] + 1);
				}
			}
			max = Math.max(max, stackheight[i]);
		}

		System.out.println(max);

		scan.close();
	}
}
