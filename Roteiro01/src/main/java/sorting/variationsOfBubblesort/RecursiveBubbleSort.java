package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");

		if(array.length == 0)return;

			Integer [] seq = (Integer[]) array;

			for(int j = 0 ; j < rightIndex - leftIndex ; j++) {
				if (seq[j] > seq[j + 1]) {
					util.Util.swap(seq, j, j + 1);

				}
			}

			leftIndex++;
			if(leftIndex==rightIndex)return;
			sort(array, leftIndex, rightIndex);

	}

}
