package CodeSamples;

import java.util.Arrays;
import java.util.PriorityQueue;

class SortedMisc {
	// when subarray is sorted, whole is sorted
	public static int[] sortArrayWithMinSubArray(int[] array) {
		int start = 0, end = array.length - 1;
		for (; start < array.length - 1; start++) {
			if (array[start] > array[start + 1]) {
				break;
			}
		}
		if (start == array.length - 1) {
			return new int[] { 0, 0 };
		}

		for (; end > 0; end--) {
			if (array[end] < array[end - 1]) {
				break;
			}
		}

		int min = 0, max = 0;
		for (int i = start; i <= end; i++) {
			min = Math.min(array[min], array[i]);
			max = Math.max(array[max], array[i]);
		}

		for (int i = 0; i < start; i++) {
			if (array[i] > min) {
				start = i;
				break;
			}
		}
		for (int i = array.length - 1; i >= end; i--) {
			if (array[i] < max) {
				end = i;
				break;
			}
		}

		return new int[] { start, end };
	}

	public static int[] findKCloseTarget(int[] array, int target, int k) {
		int ind = Arrays.binarySearch(array, target);
		int[] closest = new int[k];
		int count = 0;
		int left = ind;
		int right = ind + 1;

		if (array[ind] == target) {
			left--;
		}
		while (count < k) {
			if (k - array[left] > array[right] - k) {
				closest[count] = array[left--];
			}
			else {
				closest[count] = array[right++];
			}
			count++;
		}

		return closest;
	}

	// 0-n^2-1
	public static void sortInSquareRange(int[] array) {
		countingSort(array, 1);
		countingSort(array, array.length);
	}

	public static void countingSort(int[] array, int digit) {
		int[] output = new int[array.length];
		int[] count = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			count[(array[i] / digit) % array.length]++;
		}

		for (int i = 1; i < array.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = array.length - 1; i >= 0; i--) {
			output[count[(array[i] / digit) % array.length]--] = array[i];
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}

	// some elements moved to 1 from correct location
	public static int almostSortedSearch(int[] array, int target) {
		int low = 0;
		int high = array.length;
		while (low <= high) {
			int mid = (low + high) / 2;
			for (int i = -1; i <= 1; i++) {
				if (mid + i >= 0 && mid + i < array.length && array[mid + i] == target) {
					return mid + i;
				}
			}

			if (array[mid] > target) {
				low = mid + 2;
			}
			else {
				high = mid - 2;
			}
		}

		return -1;
	}

	public static void almostSortedKSort(int[] array, int target, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k + 1; i++) {
			pq.add(array[i]);
		}

		int index = 0;
		for (int i = k + 1; i < array.length; i++) {
			array[index++] = pq.poll();
			pq.add(array[i]);
		}

		while (!pq.isEmpty()) {
			array[index++] = pq.poll();
		}
	}

	// high low high low...
	public static void sortWave(int[] array) {
		for (int i = 2; i < array.length; i += 2) {
			if (i - 1 >= 0 && array[i] < array[i - 1]) {
				int temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			}
			if (i + 1 < array.length && array[i] < array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
	}

	// each half from different sorted array
	public static int[] closestPairOfDifferentArraySum(int[] array1, int[] array2, int target) {
		int diff = 0x3f3f3f3f;
		int[] pair = new int[2];
		int left = 0;
		int right = array2.length - 1;
		while (left < array1.length && right >= 0) {
			if (Math.abs(array1[left] + array2[right] - target) < diff) {
				diff = Math.abs(array1[left] + array2[right] - target);
				pair[0] = array1[left];
				pair[1] = array2[right];
			}
			if (array1[left] + array2[right] < target) {
				left++;
			}
			else {
				right--;
			}
		}

		return pair;
	}

	// print all elements in common to all 3 arrays
	public static void commonElements(int[] array1, int[] array2, int[] array3) {
		int i = 0, j = 0, k = 0;
		while (i < array1.length && j < array2.length && k < array3.length) {
			if (i == j && j == k) {
				System.out.println(i + " " + j + " " + k);
			}
			else if (i < j) {
				i++;
			}
			else if (j < k) {
				j++;
			}
			else {
				k++;
			}
		}
	}

	// pair in a sorted array
	public static int[] closestPairSum(int[] array, int target) {
		int diff = 0x3f3f3f3f;
		int[] pair = new int[2];
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (Math.abs(array[left] + array[right] - target) < diff) {
				diff = Math.abs(array[left] + array[right] - target);
				pair[0] = left;
				pair[1] = right;
			}
			else if (array[left] + array[right] < target) {
				left++;
			}
			else {
				right--;
			}
		}

		return pair;
	}

	// only 0 or 1 sorted decreasing
	public static int countOnesBinaryArray(int[] array) {
		int low = 0;
		int high = array.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] == 0) {
				if (mid == 0 || array[mid - 1] == 1) {
					return mid;
				}
				else {
					high = mid;
				}
			}
			else {
				low = mid;
			}
		}
		return 0;
	}

}