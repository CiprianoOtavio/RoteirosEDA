package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(element != null) {
			if (this.isEmpty()) {
				this.array[0] = element;
				this.tail = 0;
				this.head = 0;
				this.elements++;
			} else {
				try {
					this.head = (this.head + 1) % this.array.length;
					this.array[this.head] = element;
					this.elements++;
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new QueueOverflowException();
				}
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T value = this.array[this.tail];

		if (this.tail == this.head) {
			this.tail = -1;
			this.head = -1;
			this.elements = 0;
		} else {
			this.tail = ((this.tail + 1) % this.array.length);
			elements--;
			if (elements < 0)
				throw new QueueUnderflowException();
		}
		return value;
	}

	@Override
	public T head() {
		return this.array[this.head];
	}

	@Override
	public boolean isEmpty() {
		return this.head == -1 && this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length) == this.head;
	}
}
