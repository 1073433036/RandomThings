package scam;

public class Medianof2SortedArrays {
	static int[] arr1 = { 2, 10, 15, 15, 25, 28 };
	static int[] arr2 = { 1, 2, 5, 12, 17, 18, 18, 20, 25, 27 };

	public static void main(String[] args) {
		if (arr2.length < arr1.length) {
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}
		System.out.println(binSearch(0, arr1.length - 1));
	}

	public static double binSearch(int left, int right) {
		int mida = (left + right) / 2;
		int divb = (arr1.length + arr2.length) / 2 - mida - 2;
		int a = mida < 0 ? -Integer.MAX_VALUE : arr1[mida];
		int b = mida >= arr1.length ? Integer.MAX_VALUE : arr1[mida + 1];
		int c = divb < 0 ? -Integer.MAX_VALUE : arr2[divb];
		int d = divb >= arr2.length ? Integer.MAX_VALUE : arr2[divb + 1];
		if (a < d && c < b) {
			if ((arr1.length + arr2.length) % 2 == 0) {
				return (Math.max(a, c) + Math.min(b, d)) / 2.0;
			}
			else {
				return Math.max(a, c);
			}
		}
		if (a > d) {
			return binSearch(left, mida - 1);
		}
		else if (c > b) {
			return binSearch(mida + 1, right);
		}
		return 0;
	}
}
