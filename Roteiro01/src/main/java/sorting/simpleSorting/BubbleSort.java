package sorting.simpleSorting;

import sorting.AbstractSorting;


/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		Integer [] seq = (Integer[]) array;

		for(int i = leftIndex ; i < rightIndex ; i++){

			boolean changed = false;

			for(int j = leftIndex ; j < rightIndex - i ; j++) {
				if (seq[j] > seq[j + 1]) {
					util.Util.swap(seq, j, j + 1);
					changed = true;
				}
			}
				if(!changed)return;
		}
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}
}
