package TRULYRANDOM;

import java.util.HashSet;

public class DataAnalysis {
	public static void main(String[] args) {
		int[][] notLoop = new int[1000000][2];
		int ct = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				if (!isLoop(i, j)) {
					notLoop[ct][0] = i;
					notLoop[ct][1] = j;
					ct++;
				}
			}
		}

		for (int i = 0; i < ct; i++) {
			int n = notLoop[i][0];
			int m = notLoop[i][1];

			// big data
			int sum = n + m;
			double half = sum / 2;
			int less = Math.min(n, m);
			double sumlog2 = Math.log(sum) / Math.log(2);
			double multlog2 = Math.log(half / less) / Math.log(2);
			int prod = n * m;
			int gcd = gcd(n, m);
			int lcm = lcm(n, m);

			boolean equal = n == m;
			boolean sumPow2 = Math.floor(sumlog2) == Math.ceil(sumlog2);
			boolean multPow2 = Math.floor(multlog2) == Math.ceil(multlog2);

			if (!(equal || sumPow2 || multPow2)) {
				System.out.print(n + " " + m);
				System.out.print("\t\t" + sum + "\t" + equal + "\t" + sumPow2 + "\t" + multPow2);
				System.out.print("\t" + prod + "\t" + gcd);

				System.out.println();
			}
		}
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	private static boolean isLoop(int n, int m) {
		int sum = n + m;
		double ckSumPow2 = Math.log(sum) / Math.log(2);
		if (n == m) {
			return false;
		}
		// if sum is odd or is multiple of 2 and not 4
		if (sum % 4 != 0) {
			return true;
		}
		// if sum is power of 2 then no loop
		if (Math.floor(ckSumPow2) == Math.ceil(ckSumPow2)) {
			return false;
		}

		// simulate loop
		HashSet<String> loopTracker = new HashSet<>();
		while (n != m) {
			String key = n + "," + m;
			String keyreverse = m + "," + n;
			double half = sum / 2;
			int less = Math.min(n, m);
			double ckDivPow2 = Math.log(half / less) / Math.log(2);

			// if less banana pile times a power of 2 is half then no loop
			if (Math.floor(ckDivPow2) == Math.ceil(ckDivPow2)) {
				return false;
			}
			// if you have gotten here before then loops
			if (loopTracker.contains(key) || loopTracker.contains(keyreverse)) {
				return true;
			}
			loopTracker.add(key);
			// who wins
			if (n > m) {
				n = n - m;
				m = m * 2;
			}
			else {
				m = m - n;
				n = n * 2;
			}
		}

		return false;
	}
}
