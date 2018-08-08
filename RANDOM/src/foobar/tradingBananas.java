package foobar;

import java.util.HashSet;

public class tradingBananas {
	static HashSet<String> tracker;

	public static void main(String[] args) {

	}

	public static int answer(int[] banana_list) {
		
	}

	public static boolean isLoop(int n, int m) {
		String key = n + "," + m;
		String keyreverse = m + "," + n;
		int sum = n + m;
		double half = sum / 2;
		int less = Math.min(n, m);
		double ckDivPow2 = Math.log(half / less) / Math.log(2);
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
		// if less banana pile times a power of 2 is half then no loop
		if (Math.floor(ckDivPow2) == Math.ceil(ckDivPow2)) {
			return false;
		}
		// if you have gotten here before then loops
		if (tracker.contains(key)) {
			return true;
		}

		tracker.add(key);
		tracker.add(keyreverse);
		// who wins
		if (n > m) {
			return isLoop(n - m, m * 2);
		}
		else {
			return isLoop(n * 2, m - n);
		}
	}

}
