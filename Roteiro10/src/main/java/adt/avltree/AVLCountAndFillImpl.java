package adt.avltree;

import java.util.Arrays;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {

		Arrays.sort(array);
		int maxPot = (int) Math.floor(Math.log10(array.length)/Math.log10(2));

		int[] visited = new int[array.length];

		for (int i = 1; i <= maxPot; i++) {

			double pot2 = Math.pow(2, i);
			int cont = 1, pos = (int) Math.floor(cont * array.length / pot2);

			do {

				cont++;

				if (visited[pos] == 0) {
					this.insert(array[pos]);
					visited[pos] = 1;
				}

				pos = (int) Math.floor(cont * array.length / pot2);

			} while (pos < array.length);

		}

		for (int i = 0; i < array.length; i++) {

			if (visited[i] == 0) {
				this.insert(array[i]);
				visited[i] = 1;
			}

		}

	}

	@Override
	public void insert(T element) {
		insert(getRoot(), element);
	}

	private void insert(BSTNode<T> node, T element) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
			this.root.setParent(new BSTNode<T>());
		}
		else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else if(element.compareTo(node.getData()) > 0){
				insert((BSTNode<T>) node.getRight(), element);
			}
		}

		this.rebalance(node);
	}

	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> aux;

		if (calculateBalance(node) > 1) {

			if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
				LLcounter++;
				aux = Util.rightRotation(node);
			} else {
				RLcounter++;
				Util.leftRotation((BSTNode<T>) node.getLeft());
				aux = Util.rightRotation(node);
			}

			if (aux.getParent().isEmpty()) {
				root = aux;
			}
		} else if (calculateBalance(node) < -1) {
			if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
				RRcounter++;
				aux = Util.leftRotation(node);
			} else {
				LRcounter++;
				Util.rightRotation((BSTNode<T>) node.getRight());
				aux = Util.leftRotation(node);

			}

			if (aux.getParent().isEmpty()) {
				root = aux;
			}
		}
	}
}