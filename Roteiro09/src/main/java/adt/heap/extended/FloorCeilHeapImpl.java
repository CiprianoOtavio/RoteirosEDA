package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		Integer retorno = null;
		for(int i=0; i< array.length; i++) {
			this.insert(array[i]);
		}
		for(int i=0;i<array.length;i++) {
			if(this.rootElement() == numero) {
				return this.rootElement();
			}else
			if(this.rootElement() < numero) {
				if(retorno == null) {
					retorno = this.rootElement();
				}else {
					if(this.rootElement() > retorno) {
						retorno = this.rootElement();
					}
				}
			}
			this.extractRootElement();
		}

		return retorno;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		Integer ceil = null;
		this.index = -1;

		for (Integer i : array) {
			this.insert(i);
		}

		if(!isEmpty()) {
			for (int i = 0; i < array.length; i++) {
				if(this.rootElement() == numero) ceil = this.rootElement();

				else if(this.rootElement() > numero) {
					if(ceil == null || ceil > this.rootElement()) ceil = this.rootElement();
				}

				else {
					this.extractRootElement();
				}
			}
		}

		return ceil;

	}

}
