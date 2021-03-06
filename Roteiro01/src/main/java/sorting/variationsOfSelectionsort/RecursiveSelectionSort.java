package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");
		int menor = leftIndex;
		Integer [] seq = (Integer[]) array;

		for (int i = leftIndex; i <= rightIndex ; i++) {

			int n = seq[menor];
			int valor = seq[i];
			if(valor < n){
				menor = i;
			}

		}
		if(menor != leftIndex){
			util.Util.swap(seq, leftIndex, menor);
		}

		leftIndex++;
		if(leftIndex < rightIndex ){
			sort(array, leftIndex, rightIndex);
		}
	}

}
