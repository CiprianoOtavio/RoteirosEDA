package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		// TODO Auto-generated method stub
		if(this.getBSt() != null) {
			if(this.getBSt().isEmpty()) {
				return true;
			}else {
				return verifyBST(this.getBSt().getRoot());
			}
		}else {
			return false;
		}

		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private boolean verifyBST(BTNode<T> node) {
		boolean result = true;
		if (!node.isEmpty()) {
			T nodeValue = node.getData();

			if (node.getLeft().getData() != null && node.getLeft().getData().compareTo(nodeValue) > 0) {
				result = false;
			}
			if (node.getRight().getData() != null && node.getRight().getData().compareTo(nodeValue) < 0) {
				result = false;
			}
			if (result) {
				return verifyBST(node.getLeft()) && verifyBST(node.getRight());
			}
			return result;
		}

		return result;
	}

}
