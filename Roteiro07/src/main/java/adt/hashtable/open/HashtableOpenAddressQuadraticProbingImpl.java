package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(element != null) {
			if(isFull()) {
				throw new HashtableOverflowException();
			}
			if(search(element) == null) {
				int it = 0;
				int hash = getHashCode(element,it);
				while(this.table[hash] != null && it < this.table.length && !this.table[hash].toString().equals("D")) {
					COLLISIONS++;
					it++;
					hash =  getHashCode(element,it);
				}

				//insere
				this.table[hash] = element;
				elements++;
			}
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(element != null && !isEmpty()) {
			if(indexOf(element) != -1) {
				this.table[indexOf(element)] = new DELETED();
				elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(element != null && !isEmpty()) {
			if(indexOf(element) != -1) {
				return element;
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		int retorno = -1;
		int it = 0;
		int hash = getHashCode( element,it);
		while(this.table[hash] != null && it < this.table.length) {
			if(this.table[hash].equals(element)) {
				return hash;
			}
			it++;
			hash =  getHashCode( element,it);
		}
		return retorno;
	}
	private int getHashCode(T element, int prob) {
		return  ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element,prob);
	}
}
