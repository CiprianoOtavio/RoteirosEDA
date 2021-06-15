package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		return this.data == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if (isEmpty())
			return 0;
		else {
			int size = 1;
			RecursiveSingleLinkedListImpl<T> lista = this.next;
			return recursiveSize(lista, size);
		}
	}

	private int recursiveSize(RecursiveSingleLinkedListImpl<T> lista, int size) {
		if (lista.getNext() == null)
			return size;
		else
			return recursiveSize(lista.getNext(), size + 1);
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");

		T retorno = null;
		if(isEmpty()) {
			return retorno;
		}

		if( element!= null){
			if(getData().equals(element)) {
				return getData();
			}
			RecursiveSingleLinkedListImpl<T> temp = this.next;
			retorno = recursiveSearch(temp,element);
		}

		return retorno;

	}

	private T recursiveSearch(RecursiveSingleLinkedListImpl<T> temp, T element) {
		if(temp.getData() == null) {
			return null;
		}
		if(temp.getData().equals(element)) {
			return temp.getData();
		}
		return recursiveSearch(temp.getNext(),element);
	}

	@Override
	public void insert(T element) {
		if(element!= null){
			if(isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			}else{
				RecursiveSingleLinkedListImpl<T> lista = this.next;
				recursiveInsert(lista, element);
			}
		}
	}

	private void recursiveInsert(RecursiveSingleLinkedListImpl<T> lista, T element) {
		if(lista.getData() == null) {
			lista.setData(element);
			lista.setNext(new RecursiveSingleLinkedListImpl<T>());
		}else{recursiveInsert(lista.getNext(), element);}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(element != null && !isEmpty()){
			RecursiveSingleLinkedListImpl<T> lista = this.next;
			if(this.next.getData().equals(element)) {
				setData(lista.getData());
				setNext(lista.getNext());
			}
			recursiveRemove(lista, element);
		}
	}
	private void recursiveRemove(RecursiveSingleLinkedListImpl<T> lista, T element) {
		if (lista.getNext() != null){
			if(lista.getData().equals(element))
				lista.setNext(lista.getNext().getNext());
			else
				recursiveRemove(lista.getNext(), element);
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		T[] retorno = (T[]) new Comparable[size()];
		if (!isEmpty()) {
			RecursiveSingleLinkedListImpl<T> lista = this.next;
			int contador = 1;
			retorno[0] = getData();
			return toString(retorno, lista, contador);
		}else{
			return retorno;
		}
	}

	private T[] toString(T[] retorno, RecursiveSingleLinkedListImpl<T> lista, int contador) {
		if(lista.getData() == null) {
			return retorno;
		}
		retorno[contador] = lista.getData();
		return toString(retorno,lista.getNext(),contador + 1);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
