package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] mainArray, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		Integer[] subsArray = (Integer[]) mainArray;
		quickSort(subsArray, leftIndex, rightIndex);
	}
	private static int particao(Integer[] subsArray, int left, int right){
		int arraySize = right - left + 1;
		int prePivot = (int)(Math.random() * arraySize) + left;

		Util.swap(subsArray, left, prePivot);

		int pivot = subsArray[left];
		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (subsArray[j] <= pivot) {
				i+=1;
				Util.swap(subsArray, i, j);
			}
		}

		Util.swap(subsArray, left, i);
		return i;
	}
	private static void quickSort(Integer[] array, int left, int right) {
		if (left < right) {
			int pivot = particao(array, left, right);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}
}
