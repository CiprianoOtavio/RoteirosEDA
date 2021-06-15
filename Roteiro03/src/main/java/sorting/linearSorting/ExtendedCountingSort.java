package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");

		if (array == null || array.length == 0|| (leftIndex >= rightIndex) || ( leftIndex < 0 ) || (rightIndex <= 0)) {
		}else if (array != null || array.length == 0 ) {

			Integer top = array[leftIndex];

			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i].compareTo(top)>0) {
					top = array[i];
				}
			}
			Integer bottom = Integer.MAX_VALUE;
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i].compareTo(bottom)<0) {
					bottom = array[i];
				}
			}
			int range = top- bottom + 1;
			int count[] = new int[range];
			int output[] = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				count[array[i] - bottom]++;
			}
			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			for (int i = array.length - 1; i >= 0; i--) {
				output[count[array[i] - bottom] - 1] = array[i];
				count[array[i] - bottom]--;
			}

			for (int i = 0; i < array.length; i++) {
				array[i] = output[i];
			}
		}
	}

}
