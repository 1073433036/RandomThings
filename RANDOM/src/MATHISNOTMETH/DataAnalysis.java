package MATHISNOTMETH;

import java.util.HashSet;

public class DataAnalysis {
	public static void main(String[] args) {
		boolean[][] data = new boolean[50][50];
		for (int i = 1; i < data.length; i++) {
			for (int j = 1; j < data[0].length; j++) {
				data[i][j] = isLoop(i, j);
			}
		}

		for (int i = 1; i < data.length; i++) {
			for (int j = 1; j < data[0].length; j++) {
				boolean loops = data[i][j];
				// if (loops) {
				// continue;
				// }

				// big data
				int sum = i + j;
				double half = sum / 2;
				int less = Math.min(i, j);
				double sumlog2 = Math.log(sum) / Math.log(2);
				double multlog2 = Math.log(half / less) / Math.log(2);
				int prod = i * j;
				int gcd = gcd(i, j);
				int lcm = lcm(i, j);
				double divlcmlog2 = Math.log(i / gcd + j / gcd) / Math.log(2);

				boolean extra = false;
				boolean equal = i == j;
				boolean sumPow2 = Math.floor(sumlog2) == Math.ceil(sumlog2);
				boolean multPow2 = Math.floor(multlog2) == Math.ceil(multlog2);
				boolean divlcmPow2 = Math.floor(divlcmlog2) == Math.ceil(divlcmlog2);

				// if (!(equal || sumPow2 || multPow2)) {
				System.out.print(i + " " + j);

				System.out.print("\t" + prod + "\t" + gcd + "\t" + lcm + "\t" + loops + "\t" + divlcmPow2);
				if (extra) {
					System.out.print("\t\t" + sum + "\t" + equal + "\t" + sumPow2 + "\t" + multPow2);
				}

				System.out.println();
				// }

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
