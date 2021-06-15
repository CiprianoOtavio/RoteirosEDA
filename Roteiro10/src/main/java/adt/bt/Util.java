package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		//TODO Implemente sua rotacao a esquerda aqui
		//throw new UnsupportedOperationException("Not implemented yet!");
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		BSTNode<T> rightSwap = (BSTNode<T>) node.getRight();
		if(!parent.isEmpty()) {
			if(parent.getLeft().equals(node)) {
				parent.setLeft(rightSwap);

			}else {
				parent.setRight(rightSwap);
			}
		}
		node.setRight(rightSwap.getLeft());
		node.getRight().setParent(node);

		rightSwap.setParent(node.getParent());

		rightSwap.setLeft(node);
		rightSwap.getLeft().setParent(rightSwap);

		return rightSwap;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		//TODO Implemente sua rotacao a esquerda aqui
		//throw new UnsupportedOperationException("Not implemented yet!");
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();
		BSTNode<T> rightPivot = (BSTNode<T>) node.getRight();
		if(!parent.isEmpty()) {
			if(parent.getLeft().equals(node)) {
				parent.setLeft(pivot);

			}else {
				parent.setRight(pivot);
			}
		}
		node.setLeft(rightPivot);
		node.getLeft().setParent(node);
		pivot.setParent(parent);
		pivot.setRight(node);
		pivot.getRight().setParent(pivot);
		return pivot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
