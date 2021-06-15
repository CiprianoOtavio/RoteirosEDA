package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if (array.length == 1)
			return;
		else if (array.length !=0) {
			int[] indices = procuraLimites(array);
			int top = indices[0];
			int bottom = indices[1];

			int[] counting = new int[top];

			for (int i = 0; i < array.length; i++) {
				if((array[i] - 1) < 0){
					counting[0] += 1;
				} else if((array[i] - 1) > 0) {
					counting[array[i] - 1] += 1;
				} else{
					counting[1] += 1;
				}
			}

			for (int i = leftIndex + 1; i < counting.length; i++) {
				counting[i] += counting[i - 1];
			}

			Integer[] sorted = new Integer[array.length];

			for (int j = array.length - 1; j >= leftIndex; j--) {
				if (array[j] - 1 <= 0){
					sorted[counting[array[j] - bottom] - 1] = array[j];
					counting[array[j] - bottom] -= 1;
				}else{
					sorted[counting[array[j] - 1] - 1] = array[j];
					counting[array[j] - 1] -= 1;
				}
			}
			for (int l = 0; l < array.length; l++){
				array[l] = sorted[l];
			}
		}
	}

	private static int[] procuraLimites(Integer[] array){

		int top = array[0];
		int bottom = array[0];

		for(int i = 1; i < array.length; i++){
			if (array[i] > top)
				top = array[i];
			else if (array[i] < bottom)
				bottom = array[i];
		}
		int [] retorno = new int []{top, bottom};
		return retorno;
	}

}
