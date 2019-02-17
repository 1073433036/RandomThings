package CodeSamples;

class BinarySearch {
	// Arrays.binarySearch(list, target);

	public static int binSearchNoDuplicates(int target, int[] list) {
		int low = 0;
		int high = list.length;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target > list[mid]) {
				low = mid + 1;
			}
			else if (target < list[mid]) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}

		return -1;
	}

	public static int binSearchFirstOccurrence(int target, int[] list) {
		int low = 0;
		int high = list.length;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target > list[mid]) {
				low = mid + 1;
			}
			else if (target < list[mid]) {
				high = mid - 1;
			}
			else {
				if (list[mid - 1] != target) {
					return mid;
				}
				else {
					high = mid - 1;
				}
			}
		}

		return list[low] == target ? low : -1;
	}

	public static int binSearchUniformlyDistributed(int target, int[] list) {
		int low = 0;
		int high = list.length;
		while (low <= high) {
			int weightedmid = low + (high - low) / (list[high] - list[low]) * (target - list[low]);
			if (list[weightedmid] < target) {
				high = weightedmid - 1;
			}
			else if (list[weightedmid] > target) {
				low = weightedmid + 1;
			}
			else {
				return weightedmid;
			}
		}

		return -1;
	}

	public static int exponentialBinSearch(int target, int[] list) {
		if (list[0] == target) {
			return 0;
		}

		int right = 1;
		while (right < list.length && list[right] < target) {
			right *= 2;
		}

		int left = right / 2;
		right = Math.min(right, list.length);
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list[mid] < target) {
				left = mid + 1;
			}
			else if (list[mid] > target) {
				right = mid - 1;
			}
			else {
				return mid;
			}
		}

		return -1;
	}
}
