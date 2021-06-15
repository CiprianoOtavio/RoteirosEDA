package orderStatistic;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os daods em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 */
	public T quickSelect(T[] array, int k) {
		// TODO Implement your code here
		//throw new UnsupportedOperationException("Not implemented yet!");
		T saida = null;

		if(array.length > 0 && k > 0 && k <= array.length) {

			saida = recursiveQuickSelect(array,k,0,array.length - 1);

		}

		return saida;

	}
	private T recursiveQuickSelect(T[] array,int k, int leftIndex, int rightIndex) {


		if(leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int pivotIndex = particiona(array,leftIndex,rightIndex );

			if( k < pivotIndex + 1) {
				return recursiveQuickSelect(array,k,leftIndex, rightIndex - 1);

			}else if(k > pivotIndex + 1) {
				return recursiveQuickSelect(array,k,pivotIndex + 1, rightIndex);

			}
			return array[pivotIndex];
		}
		return array[k - 1];
	}
	private int particiona (T [] array, int start, int end) {

		int middle = (start + end)/2;
		mD3Sort(array,start,middle,end);
		T pivot = array[middle];
		util.Util.swap(array,middle,end-1);
		int pivotIndex = end - 1;

		for(int j = pivotIndex-1; j > start;j-- ) {
			if(pivot.compareTo(array[j]) < 0) {
				pivotIndex--;
				util.Util.swap(array,pivotIndex,j);
			}
		}
		util.Util.swap(array,end-1,pivotIndex);

		return pivotIndex;
	}

	private void mD3Sort(T[] array, int leftIndex, int middle, int rightIndex) {
		if(array[leftIndex].compareTo(array[middle]) > 0) {
			util.Util.swap(array,leftIndex, middle);
		}
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array, leftIndex, rightIndex);
		}
		if(array[middle].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array,middle ,rightIndex );
		}
	}
}