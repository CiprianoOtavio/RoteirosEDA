package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method
		//throw new UnsupportedOperationException("Not implemented yet!");
		return recursiveEquals((BSTNode<T>)tree1.getRoot(), (BSTNode<T>)tree2.getRoot());
	}

	private boolean recursiveEquals(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1.isEmpty() && node2.isEmpty()) {
			return true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			if (node1.equals(node2)) {
				return recursiveEquals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) && recursiveEquals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(tree1.height() != tree2.height()) {
			return false;
		}
		return recursiveIsSimilar((BSTNode<T>)tree1.getRoot(),(BSTNode<T>)tree2.getRoot());
	}

	private boolean recursiveIsSimilar(BSTNode<T> root, BSTNode<T> root2) {
		boolean isEqual = false;
		if(root.isEmpty() && root2.isEmpty()) {
			return true;
		}
		isEqual = recursiveIsSimilar((BSTNode<T>)root.getLeft(), (BSTNode<T>)root2.getLeft());
		isEqual = recursiveIsSimilar((BSTNode<T>)root.getRight(),(BSTNode<T>)root2.getRight());
		return isEqual;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		// TODO Implement this method
		//throw new UnsupportedOperationException("Not implemented yet!");
		if (tree.isEmpty()) {
			return null;
		}
		return recursiveOrderStatistic(tree, tree.minimum(), k, 1);
	}

	private T recursiveOrderStatistic(BST<T> tree, BSTNode<T> node, int n, int m) {

		if (node != null) {
			if (n == m) {
				return node.getData();
			}
			return recursiveOrderStatistic(tree, tree.sucessor(node.getData()), n, m + 1);
		}
		return null;
	}

}
