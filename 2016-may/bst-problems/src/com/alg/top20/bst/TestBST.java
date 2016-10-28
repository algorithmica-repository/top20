package com.alg.top20.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestBST {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void add(Integer key) {
		TreeNode current = root;
		if (current == null) {
			root = new TreeNode(key);
			return;
		}
		while (true) {
			int ret = key.compareTo(current.data);
			if (ret < 0) {
				++current.lss;
				if (current.left == null) {
					current.left = new TreeNode(key);
					break;
				} else
					current = current.left;
			} else {
				if (current.right == null) {
					current.right = new TreeNode(key);
					break;
				} else
					current = current.right;
			}
		}
	}

	public void display() {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		System.out.println(root.data + " " + root.lss);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp.left != null) {
				q.add(tmp.left);
				System.out.println(tmp.left.data + " " + tmp.left.lss);
			} else {
				System.out.println("null");
			}
			if (tmp.right != null) {
				q.add(tmp.right);
				System.out.println(tmp.right.data+ " " + tmp.right.lss);
			} else {
				System.out.println("null");
			}
		}
	}

	public void randomBST(int n) {
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			add(r.nextInt(2000) + 1);
		}
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		TestBST bst = new TestBST();
		bst.randomBST(size);
		bst.display();
		System.out.println();
		//System.out.println(SelectK.selectK(bst.getRoot(), k));
		
		System.out.println(ISBST.isBST2(bst.getRoot()));
	}

}
