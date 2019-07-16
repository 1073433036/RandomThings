package CodeSamples;

import java.util.ArrayList;

class Sorts {
	private static class Node {
		Node prev;// only doubly linked list
		Node next;
		int data;

		public Node(Node next, int data) {
			this.next = next;
			this.data = data;
		}

		public Node(Node prev, Node next, int data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}

	public static Node sortedMerge(Node left, Node right) {
		Node result = null;
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		if (left.data <= right.data) {
			result = left;
			result.next = sortedMerge(left.next, right);
		}
		else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}

		return result;
	}

	public static Node mergeSortLinkedList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node fastptr = head.next;
		Node middle = head;
		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				middle = middle.next;
				fastptr = fastptr.next;
			}
		}
		Node middleNext = middle.next;
		middle.next = null;
		Node left = mergeSortLinkedList(head);
		Node right = mergeSortLinkedList(middleNext);
		Node sorted = sortedMerge(left, right);
		return sorted;
	}

	public static void cycleSort(int[] array) {
		for (int cycle = 0; cycle <= array.length - 2; cycle++) {
			int item = array[cycle];

			int pos = cycle;
			for (int i = cycle + 1; i < array.length; i++) {
				if (array[i] < item) {
					pos++;
				}
			}

			if (pos == cycle) {
				continue;
			}

			while (item == array[pos]) {
				pos++;
			}

			if (pos != cycle) {
				int temp = array[cycle];
				array[cycle] = array[pos];
				array[pos] = temp;
			}

			while (pos != cycle) {
				pos = cycle;
				for (int i = cycle + 1; i < array.length; i++) {
					if (array[i] < item) {
						pos++;
					}
				}

				while (item == array[pos]) {
					pos++;
				}

				if (item != array[pos]) {
					int temp = array[cycle];
					array[cycle] = array[pos];
					array[pos] = temp;
				}
			}
		}
	}

	public static void combSort(int[] array) {
		for (int gap = array.length * 10 / 13; gap > 1; gap = (int) Math.max(gap / 1.3, 1)) {
			boolean swapped = false;
			for (int j = 0; j < array.length - gap; j++) {
				if (array[j] > array[j + gap]) {
					int temp = array[j];
					array[j] = array[j + gap];
					array[j + gap] = temp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}

	public static void shellSort(int[] array) {
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				int temp = array[i];
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
					array[j] = array[j - gap];
				}
				array[j] = temp;
			}
		}
	}

	public static void bucketSort(double[] array) {
		ArrayList<Double>[] buckets = new ArrayList[array.length];
		for (int i = 0; i < array.length; i++) {
			if (buckets[(int) (array.length * array[i])] == null) {
				buckets[(int) (array.length * array[i])] = new ArrayList<>(array.length / 2);
			}
			buckets[(int) (array.length * array[i])].add(array[i]);
		}

		int index = 0;
		for (int i = 0; i < array.length; i++) {
			for (int k = 1; k < buckets[i].size(); k++) {
				double compare = buckets[i].get(k);
				int j;
				for (j = k - 1; j >= 0 && buckets[i].get(j) > compare; j--) {
					buckets[i].set(j + 1, buckets[i].get(j));
				}
				buckets[i].set(j + 1, compare);
			}
			for (double val : buckets[i]) {
				array[index++] = val;
			}
		}
	}

	public static void countingSort(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
			max = Math.max(max, array[i]);
		}

		int[] count = new int[max - min + 1];
		int[] output = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			count[array[i] - min]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = array.length - 1; i >= 0; i--) {
			output[--count[array[i] - min]] = array[i];
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}

	public static void radixSort(int[] array) {
		int maxNum = array[0];
		for (int i = 1; i < array.length; i++) {
			maxNum = Math.max(maxNum, array[i]);
		}

		for (int pw10 = 1; maxNum / pw10 > 0; pw10 *= 10) {
			int[] output = new int[10];
			int[] count = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

			for (int i = 0; i < array.length; i++) {
				count[(array[i] / pw10) % 10]++;
			}

			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}
			for (int i = array.length - 1; i >= 0; i--) {
				output[--count[(array[i] / pw10) % 10]] = array[i];
			}

			for (int i = 0; i < array.length; i++) {
				array[i] = output[i];
			}
		}
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = array[high];
			int i = low - 1;
			for (int j = low; j < high; j++) {
				if (array[j] <= pivot) {
					i++;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

			int temp = array[i + 1];
			array[i + 1] = array[high];
			array[high] = temp;

			quickSort(array, low, i);
			quickSort(array, i + 1, high);
		}
	}

	public static void quickSortDoubleLinkedList(Node head, Node end) {
		if (end != null && head != end && head != end.next) {
			int pivot = head.data;
			Node i = head.prev;
			for (Node j = head; j != end; j = j.next) {
				if (j.data <= pivot) {
					i = i == null ? head : i.next;
					int temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}

			i = i == null ? head : i.next;
			int temp = i.data;
			i.data = head.data;
			head.data = temp;

			quickSortDoubleLinkedList(head, i.prev);
			quickSortDoubleLinkedList(i.next, end);
		}
	}

	public static Node quickSortSingleLinkedList(Node head, Node end) {
		if (head == null || head == end) {
			return head;
		}

		Node newHead = null, newEnd = null;
		Node pivot = end;
		Node prev = null, cur = head, tail = pivot;
		while (cur != pivot) {
			if (cur.data < pivot.data) {
				if (newHead == null) {
					newHead = cur;
				}

				prev = cur;
				cur = cur.next;
			}
			else {
				if (prev != null) {
					prev.next = cur.next;
				}
				Node temp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = temp;
			}
		}

		if (newHead == null) {
			newHead = pivot;
		}
		newEnd = tail;

		if (newHead != pivot) {
			Node temp = newHead;
			while (temp.next != pivot) {
				temp = temp.next;
			}
			temp.next = null;

			newHead = quickSortSingleLinkedList(newHead, temp);

			while (temp != null && temp.next != null) {
				temp = temp.next;
			}

			temp.next = pivot;
		}
		pivot.next = quickSortSingleLinkedList(pivot.next, newEnd);
		return newHead;
	}

	public static void iterativeQuickSort(int[] array) {
		int[] stack = new int[array.length - 1];

		int top = -1;
		stack[++top] = 0;
		stack[++top] = array.length - 1;

		while (top >= 0) {
			int e = stack[top--];
			int s = stack[top--];
			int pivot = array[e];
			int i = s - 1;
			for (int j = 1; j <= e - 1; j++) {
				if (array[j] <= pivot) {
					i++;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			int temp = array[i + 1];
			array[i + 1] = array[e];
			array[e] = temp;

			int p = i + 1;
			if (p - 1 > s) {
				stack[++top] = s;
				stack[++top] = p - 1;
			}
			if (p + 1 < e) {
				stack[++top] = p + 1;
				stack[++top] = e;
			}
		}
	}

	public static void heapSort(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			heapify(array, array.length, i);
		}

		for (int i = array.length - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0);
		}
	}

	public static void heapify(int[] array, int size, int index) {
		int largest = index;
		int l = 2 * index + 1;
		int r = 2 * index + 2;

		if (l < size && array[l] > array[largest]) {
			largest = l;
		}
		if (r < size && array[r] > array[largest]) {
			largest = r;
		}
		if (largest != index) {
			int temp = array[index];
			array[index] = array[largest];
			array[largest] = temp;

			heapify(array, size, largest);
		}
	}

	public static void mergeSort(int[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(array, l, m);
			mergeSort(array, m, r);

			int[] left = new int[m - l + 1];
			int[] right = new int[r - m];

			for (int i = 0; i < left.length; i++) {
				left[i] = array[l + i];
			}
			for (int i = 0; i < right.length; i++) {
				right[i] = array[m + i + 1];
			}

			int i = 0, j = 0;
			int k = l;
			while (i < left.length && j < right.length) {
				if (left[i] <= right[j]) {
					array[k] = left[i];
				}
				else {
					array[k] = right[j];
					j++;
				}
				k++;
			}

			while (i < left.length) {
				array[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length) {
				array[k] = right[j];
				j++;
				k++;
			}
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int compare = array[i];
			int j;
			for (j = i - 1; j >= 0 && array[j] > compare; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = compare;
		}
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}

	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minInd = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minInd] > array[j]) {
					minInd = j;
				}
			}
			int tmp = array[minInd];
			array[minInd] = array[i];
			array[i] = tmp;
		}
	}

}
