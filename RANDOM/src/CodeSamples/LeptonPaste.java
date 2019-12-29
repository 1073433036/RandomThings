package CodeSamples;

public class LeptonPaste {
	// vim: syntax=java
	/*
	 * Search a sorted array by jumping forward sqrtN elements to find the upper
	 * boundary, then going back to use a linear search to find the element
	 * If there are multiple occurrences, it will find the first occurrence
	 * 
	 * O(sqrtN)
	 */

	public static <T extends Comparable<T>> int jumpsearch(T[] array, T target) {
		int step = (int) Math.sqrt(array.length);

		int previous = -1;
		int current = step;
		while (array[Math.min(current, array.length - 1)].compareTo(target) < 0) {
			
		}
	}
}
