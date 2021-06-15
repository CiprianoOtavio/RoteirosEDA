package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		return this.head.isNIL();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if(isEmpty()){
			return 0;
		}else{
			int counting = 0;
			SingleLinkedListNode<T> temp = this.head;
			while(!temp.isNIL()){
				counting++;
				temp = temp.getNext();
			}
			return counting;
		}

	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		T retorno = null;
		if(element!= null) {
			if (!isEmpty()) {
				SingleLinkedListNode<T> elemento = this.head;
				for (int i = 0; i < size(); i++) {
					if (element.equals(elemento.getData())) {
						retorno = elemento.getData();
						break;
					}
					elemento = elemento.next;
				}
			}
		}
		return retorno;
	}

	@Override
	public void insert(T element) {

		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");

		if(element!= null){
			if(isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<T>());

			}else{

				SingleLinkedListNode<T> temp = this.head;

				while(!temp.isNIL()){
					temp = temp.getNext();
				}

				temp.setData(element);
				temp.setNext(new SingleLinkedListNode<>());

			}
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if(element != null && !isEmpty()){
			SingleLinkedListNode<T> temp = this.head;
			if(this.head.getData().equals( element)) {
				this.head = this.head.getNext();
			}

			while (!temp.getNext().isNIL()){

				if(temp.getNext().getData().equals(element)){
					temp.setNext(temp.getNext().getNext());
					break;
				}

				temp = temp.getNext();

			}
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		T[] retorno = (T[]) new Comparable[size()];
		if (!isEmpty()) {
			SingleLinkedListNode<T> elemento = this.head;
			for (int i = 0; i < size(); i++){
				retorno[i] = elemento.getData();
				elemento = elemento.next;
			}
		}
		return retorno;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
