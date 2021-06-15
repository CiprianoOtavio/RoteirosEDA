package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Integer [] seq = (Integer[]) array;

		for(int i = leftIndex ; i < rightIndex ; i++){

			boolean changed1 = false;

			for(int j = leftIndex ; j < rightIndex - i ; j++) {
				if (seq[j] > seq[j + 1]) {
					util.Util.swap(seq, j, j + 1);
					changed1 = true;
				}
			}

			boolean changed2 = false;

			for(int o = rightIndex ; o > leftIndex + i; o--) {
				if (seq[o] < seq[o - 1]) {
					util.Util.swap(seq, o, o - 1);
					changed2 = true;
				}
			}
			if(!changed1 || !changed2)return;
		}
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}
}
