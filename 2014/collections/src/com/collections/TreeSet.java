package com.collections;

/**
 * @author	Srinivas Reddy
 * @email	srinivas96alluri@gmail.com
 */

import java.util.ArrayList;

public class TreeSet<T> implements SortedSet<T> {

	private TreeNode<T> root;

	public TreeSet(T data) {
		this.root = new TreeNode<T>(data);
	}

	/*
	 * Uses to add an element to Tree
	 * 
	 * TC <= O(h) Maximum traversing can be height(h) of Tree. SC <= O(1)
	 * Constant space we are using here
	 * 
	 * @see com.collections.Set#add(java.lang.Object)
	 */

	@Override
	public boolean add(T data) {

		TreeNode<T> current = root;
		TreeNode<T> parent = null;

		int diff = 0;

		while (current != null) {

			parent = current;

			diff = ((Comparable) data).compareTo(current.data);
			if (diff == 0) {
				return true;
			} else if (diff < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (diff < 0) {
			parent.left = new TreeNode<T>(data);
		} else if (diff > 0) {
			parent.right = new TreeNode<T>(data);
		}

		return (diff != 0);
	}

	/*
	 * Uses to check an element presence in Tree
	 * 
	 * - TC <= O(h) Maximum traversing can be height(h) of Tree. - SC <= O(1)
	 * Constant space we are using here.
	 * 
	 * @see com.collections.Set#contains(java.lang.Object)
	 */

	@Override
	public boolean contains(T data) {

		TreeNode<T> current = root;
		int diff = 0;

		while (current != null) {
			diff = ((Comparable) data).compareTo(current.data);
			if (diff == 0) {
				return true;
			} else if (diff < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return false;
	}

	/*
	 * Uses to clear the tree
	 * 
	 * - TC <= O(1) We are just clearing left and right nodes. - SC <= O(1) We
	 * are using constant space here.
	 * 
	 * @see com.collections.Set#clear()
	 */

	@Override
	public boolean clear() {
		root.left = root.right = null;
		root.data = null;
		return false;
	}

	/*
	 * Uses to findMax number in the tree
	 * 
	 * - TC <= O(h) Maximum traversing can be height(h) of Tree. - SC <= O(1) We
	 * are using constant space here.
	 * 
	 * @see com.collections.SortedSet#findMax()
	 */

	@Override
	public T findMax() {

		TreeNode<T> current = root;

		while (current.right != null) {
			current = current.right;
		}

		return current.data;
	}

	/*
	 * Uses to findMin number in the tree
	 * 
	 * - TC <= O(h) Maximum traversing can be height(h) of Tree. - SC <= O(1) We
	 * are using constant space here.
	 * 
	 * @see com.collections.SortedSet#findMin()
	 */

	@Override
	public T findMin() {
		TreeNode<T> current = root;

		while (current.left != null) {
			current = current.left;
		}

		return current.data;
	}

	/*
	 * Uses to display tree
	 * 
	 * - TC <= O(n) Maximum traversing can be each node. - SC <= O(logn) We are
	 * using stack space here.
	 * 
	 * @see com.collections.SortedSet#display()
	 */
	@Override
	public void display() {
		ArrayList<T> elements = new ArrayList<T>();
		auxPreOrder(root, elements);
		System.out.println(elements);
	}

	/*
	 * Uses to provide display API with toString()
	 * 
	 * - TC <= O(n) Maximum traversing can be each node. - SC <= O(logn) We are
	 * using stack space here.
	 * 
	 * @see com.collections.SortedSet#toString()
	 */
	public String toString() {
		ArrayList<T> elements = new ArrayList<T>();
		auxPreOrder(root, elements);
		return elements.toString();
	}

	private void auxPreOrder(TreeNode<T> root, ArrayList<T> elements) {

		if (root == null) {
			return;
		}

		auxPreOrder(root.left, elements);
		elements.add(root.data);
		auxPreOrder(root.right, elements);
	}

	@Override
	public T findKthSmallest(int pos) {

		TreeNode<T> node = auxFindKthSmallest(root, pos);

		return (node == null) ? null : node.data;

	}

	private TreeNode<T> auxFindKthSmallest(TreeNode<T> root, Integer counter) {
		// Base condition to stop recursion

		if (root == null) {
			return null;
		} else {

			TreeNode<T> result = auxFindKthSmallest(root.left, counter);
			if (result != null) {
				return result;
			}
			if (counter-- == 0) {
				return root;
			}
			return auxFindKthSmallest(root.right, counter);
		}

	}

	protected class TreeNode<T> {
		private T data;
		private TreeNode<T> left;
		private TreeNode<T> right;

		public TreeNode(T data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

}
