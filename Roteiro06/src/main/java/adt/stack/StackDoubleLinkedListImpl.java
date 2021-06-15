package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if(isFull()) {
			throw new StackOverflowException();
		}
		if(element != null) {
			this.top.insertFirst(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T retorno = top();
		top.removeLast();
		return retorno;
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if(isEmpty()) {
			return null;
		}
		T[] retorno = this.top.toArray();
		return retorno[0];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		return top.size() == size;
	}

}
