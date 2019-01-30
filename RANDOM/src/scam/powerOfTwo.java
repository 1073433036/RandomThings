package scam;

public class powerOfTwo {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 4, 2, 4, 1 };
		System.out.println(answer(arr));
	}

	public static boolean answer(int[] arr) {
		if (arr.length < 3) {
			return false;
		}
		int top = -1;
		boolean once = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1] && top == -1 && !once) {
				top = i;
				once = true;
			}
			else if (arr[i] < arr[i + 1] && top != -1) {
				return false;
			}
			else if (arr[i] > arr[i + 1] && top == -1 && once) {
				return false;
			}
		}

		return top > 0 && top < arr.length;
	}
}