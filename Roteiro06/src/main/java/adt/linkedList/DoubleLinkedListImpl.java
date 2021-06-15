package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(element != null) {

			if(this.isEmpty()) {
				this.setHead(new DoubleLinkedListNode<T>(element,new DoubleLinkedListNode<T>(),new DoubleLinkedListNode<T>()));
				if( this.getHead() instanceof DoubleLinkedListNode<?>) {
					this.setLast((DoubleLinkedListNode<T>)this.getHead());
				}
			}else {
				DoubleLinkedListNode<T> temp = new DoubleLinkedListNode<T>();
				temp.setData(this.head.getData());
				temp.setNext(this.head.getNext());
				this.setHead(new DoubleLinkedListNode<T>(element,temp,new DoubleLinkedListNode<T>()));
			}
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(!this.isEmpty()) {
			this.setHead(this.getHead().getNext());
			if(this.getHead().isNIL()) {
				if(this.getHead() instanceof DoubleLinkedListNode<?>) {
					setLast((DoubleLinkedListNode<T>) this.getHead());
				}
			}
		}
	}

	@Override
	public void removeLast() {

		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");

		if( this.last != null && !isEmpty()) {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode)this.last;
			if(!aux.isNIL()){
				this.last.getPrevious().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}