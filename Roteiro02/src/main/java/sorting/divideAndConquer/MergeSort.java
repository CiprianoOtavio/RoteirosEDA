package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] mainArray, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex)/2;
			sort(mainArray,leftIndex,middle);
			sort(mainArray,middle+1, rightIndex);

			merge(mainArray, leftIndex, middle,rightIndex);
		}
	}

	public void merge(T[] mainArray , int leftIndex , int middle , int rigntIndex) {
		T[] help = Arrays.copyOf(mainArray, mainArray.length);

		for (int i = leftIndex; i <= rigntIndex; i++) {
			help[i] = mainArray[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while(i <= middle && j<= rigntIndex) {
			if(help[i].compareTo(help[j]) < 0) {
				mainArray[k] = help[i];
				i++;
			} else {
				mainArray[k] = help[j];
				j++;
			}
			k++;
		}

		while(i <= middle) {
			mainArray[k] = help[i];
			k++;
			i++;
		}
		while (j <= rigntIndex) {
			mainArray[k] = help[j];
			k++;
			j++;
		}
	}

}