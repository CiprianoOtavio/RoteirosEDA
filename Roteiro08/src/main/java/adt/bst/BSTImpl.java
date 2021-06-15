package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		this.root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return recursiveHeight(this.root);
	}

	private int recursiveHeight(BSTNode<T> node) {
		if(node.isEmpty()) {
			return -1;
		}
		return Math.max(recursiveHeight((BSTNode<T>) node.getLeft()), recursiveHeight((BSTNode<T>) node.getRight())) + 1;
	}

	@Override
	public BSTNode<T> search(T element) {
		// TODO Auto-generated method stub    
		if(isEmpty()) {
			return new BSTNode<T>();
		}
		return recursiveSearch(element,this.root);
	}

	private BSTNode<T> recursiveSearch(T element, BSTNode<T> node ){

		if(node.isEmpty()) {
			return new BSTNode<T>();
		}
		if( element.compareTo(node.getData()) == 0) {
			return node;
		}
		if(element.compareTo(node.getData()) < 0) {
			return recursiveSearch(element,(BSTNode<T>) node.getLeft());
		}else {
			return recursiveSearch(element, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public void insert(T element) {
		recursiveInsert(element,this.root,new BSTNode<T>());
	}

	private void recursiveInsert(T element, BSTNode<T> node, BSTNode<T> parent  ) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);

		} else {

			if (element.compareTo(node.getData()) > 0)
				recursiveInsert(element,(BSTNode<T>) node.getRight(),(BSTNode<T>) node.getParent());

			else if (element.compareTo(node.getData()) < 0)
				recursiveInsert(element,(BSTNode<T>) node.getLeft(),(BSTNode<T>) node.getParent());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		return recursiveMaximum(this.root);
	}

	private BSTNode<T> recursiveMaximum(BSTNode<T> node) {
		if (!node.getRight().isEmpty()) {
			return recursiveMaximum((BSTNode<T>) node.getRight());
		} else
			return node;
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		return recursiveMinimum(this.root);
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private BSTNode<T> recursiveMinimum(BSTNode<T> node) {
		if(node.getLeft().isEmpty()) {
			return node;
		}
		return recursiveMinimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				return recursiveMinimum((BSTNode<T>) node.getRight());
			}else {
				BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

				while (parentNode != null && parentNode.getData().compareTo(node.getData()) < 0) {
					node = parentNode;
					parentNode = (BSTNode<T>) node.getParent();
				}
				return parentNode;
			}
		}
		return null;
	}

	@Override
	public BSTNode<T> predecessor(T element) {

		// TODO Auto-generated method stub
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				return recursiveMaximum((BSTNode<T>) node.getLeft());
			}else {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
				while (parent != null && parent.getData().compareTo(node.getData()) > 0) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();
				}
				return parent;
			}
		}
		return null;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				if(node.equals(this.root)) {
					this.root = new BSTNode<T>();
				}else {
					if(node.getData().compareTo(node.getParent().getData()) < 0) {
						node.getParent().setLeft(new BSTNode<T>());
					}else {
						node.getParent().setRight(new BSTNode<T>());
					}
				}

			} else if (singleChild(node)) {
				if (node.getParent() != null) {
					if (!node.getParent().getLeft().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}

					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getRight();
					} else {
						this.root = (BSTNode<T>) node.getLeft();
					}
					this.root.setParent(null);
				}
			} else {
				T sucessorNode = sucessor(node.getData()).getData();
				remove(sucessorNode);
				node.setData(sucessorNode);
			}
		}
	}

	private boolean singleChild(BSTNode<T> node) {
		return ((node.getRight().isEmpty() && !node.getLeft().isEmpty()
				|| node.getLeft().isEmpty() && !node.getRight().isEmpty()));
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		T[] array = (T[]) new Comparable[size()];
		List<T> temp = new ArrayList<T>();
		if(!getRoot().isEmpty()) {
			recursivePreOrder(this.root, temp);
		}
		temp.toArray(array);
		return array;
	}
	private void recursivePreOrder(BSTNode<T> node, List<T> array ) {
		if(!node.isEmpty()) {
			array.add(node.getData());
			recursivePreOrder((BSTNode<T>) node.getLeft(), array);
			recursivePreOrder((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[size()];
		List<T> temp = new ArrayList<T>();
		if(!getRoot().isEmpty()) {
			recursiveOrder(this.root,temp);
		}
		temp.toArray(array);
		return array;
	}

	private void recursiveOrder(BSTNode<T> node, List<T> array) {
		if(!node.isEmpty()) {
			recursiveOrder((BSTNode<T>) node.getLeft(), array);
			array.add(node.getData());
			recursiveOrder((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		T[] array = (T[]) new Comparable[size()];
		List<T> temp = new ArrayList<T>();
		if(!getRoot().isEmpty()) {
			recursivePostOrder(this.root, temp);
		}
		temp.toArray(array);
		return array;
	}
	private void recursivePostOrder(BSTNode<T> node, List<T> array) {
		if(!node.isEmpty()) {
			recursivePostOrder((BSTNode<T>) node.getLeft(), array);
			recursivePostOrder((BSTNode<T>) node.getRight(), array);
			array.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(this.root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}