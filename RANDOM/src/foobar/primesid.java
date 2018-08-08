package foobar;

public class primesid {
	public static String answer(int n) {
		// calculate prime string
		String primes = "2";
		int tested = 3;
		while (primes.length() <= n + 5) {
			boolean divis = false;
			for (int i = 2; i * i <= tested; i++) {
				if (tested % i == 0) {
					divis = true;
					break;
				}
			}
			if (!divis) {
				primes += tested;
			}
			tested += 2;
		}

		return primes.substring(n, n + 5);
	}

	public static void main(String[] args) {
		System.out.println(answer(3));
	}
}
