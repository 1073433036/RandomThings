package CodeSamples;

class Sorts {
	public static void mergeSort(int[] array, int l,int m,int r) {
		int[] left=new int[m-l+1];
		int[] right=new int[r-m];
		
		for(int i=0;i<left.length;i++) {
			left[i]=array[l+i];
			if(m+i+1<r) {
				right[i]=array[m+i+1];
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

			if (swapped) {
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
