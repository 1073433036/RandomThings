package CodeSamples;

/*
 * search sorted array in log(N)
 */

class BinarySearch {
	// Arrays.binarySearch(array, target);

	public static int binSearchNoDuplicates(int[] array, int target) {
		int low = 0;
		int high = array.length;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target > array[mid]) {
				low = mid + 1;
			}
			else if (target < array[mid]) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}

		return -1;
	}

	public static int binSearchFirstOccurrence(int[] array, int target) {
		int low = 0;
		int high = array.length;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target > array[mid]) {
				low = mid + 1;
			}
			else if (target < array[mid]) {
				high = mid - 1;
			}
			else {
				if (mid == 0 || array[mid - 1] != target) {
					return mid;
				}
				else {
					high = mid - 1;
				}
			}
		}

		return array[low] == target ? low : -1;
	}

	public static int binSearchUniformlyDistributed(int[] array, int target) {
		int low = 0;
		int high = array.length;
		while (low <= high) {
			int weightedmid = low + (high - low) / (array[high] - array[low]) * (target - array[low]);
			if (array[weightedmid] < target) {
				high = weightedmid - 1;
			}
			else if (array[weightedmid] > target) {
				low = weightedmid + 1;
			}
			else {
				return weightedmid;
			}
		}

		return -1;
	}

	public static int exponentialBinSearch(int[] array, int target) {
		if (array[0] == target) {
			return 0;
		}

		int high = 1;
		while (high < array.length && array[high] < target) {
			high *= 2;
		}

		int low = high / 2;
		high = Math.min(high, array.length);
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] < target) {
				low = mid + 1;
			}
			else if (array[mid] > target) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}

		return -1;
	}
}
