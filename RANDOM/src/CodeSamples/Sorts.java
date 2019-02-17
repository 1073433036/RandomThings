package CodeSamples;

class Sorts {
	public static int[] selectionSort(int[] array) {
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

		return array;
	}
}
