package com.alg.top20.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RBinaryTree {
	private BTreeNode root;

	private void addElement(int data) {
		BTreeNode current = root;
		while (true) {
			if (Math.random() < 0.5) {
				// if left subtree doesnot exist then attach new node to left
				if (current.left == null) {
					current.left = new BTreeNode(data);
					break;
				} else
					// otherwise move to left subtree
					current = current.left;
			} else {
				if (current.right == null) {
					current.right = new BTreeNode(data);
					break;
				} else
					current = current.right;
			}
		}
	}

	public BTreeNode randomTree(int n) {
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			int tmp = r.nextInt(n) + 1;
			if (root == null)
				root = new BTreeNode(tmp);
			else
				addElement(tmp);
		}
		return root;
	}

	public void display() {
		Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			BTreeNode current = queue.remove();
			if (current == null) {
				System.out.println();
				if (!queue.isEmpty())
					queue.add(null);
			} else {
				System.out.print(current.data + " ");
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
		}

	}

}
