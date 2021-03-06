package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");
		Integer [] seq = (Integer[]) array;

		for (int i = 1; i <= rightIndex; i++) {

			int j = i;

			while (j > 0 && seq[j] < seq[j-1]) {
				util.Util.swap(seq, j, j - 1);
				j -= 1;
			}

		}

	}
}
