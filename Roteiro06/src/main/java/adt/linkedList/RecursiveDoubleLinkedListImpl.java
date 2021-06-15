package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(element != null) {
			if(this.isEmpty()) {
				insert(element);
			}else {
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
				aux.setNext(next);
				this.setNext(aux);
				aux.setPrevious(this);
				aux.setData(data);
				this.setData(element);

			}

		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(!this.isEmpty()) {
			if(!getNext().isEmpty()) {
				this.setData(next.getData());
				this.setNext(next.getNext());
			}else {
				setData(null);
				setNext(new RecursiveDoubleLinkedListImpl<>());
			}
			setPrevious(new RecursiveDoubleLinkedListImpl<>());
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(!isEmpty()) {
			if(size() == 1){
				this.previous.setNext(null);
			}else
				remove(getNext());
		}
	}

	private void remove(RecursiveSingleLinkedListImpl<T> next) {
		if (next.getNext().getNext() != null){
			remove(next.getNext());
		}else
			this.setNext(next);
	}


	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
