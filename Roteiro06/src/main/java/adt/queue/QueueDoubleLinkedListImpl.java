package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull())
			throw new QueueOverflowException();
		else if(element != null)
			this.list.insertFirst(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException();
		else{
			T retorno = this.head();
			this.list.removeFirst();
			return retorno;
		}
	}

	@Override
	public T head() {
		T []array = list.toArray();
		return array[this.list.size() -1];
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.list.size() == size;
	}

}