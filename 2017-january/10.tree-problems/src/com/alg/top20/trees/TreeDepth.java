package com.alg.top20.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

	//TC:O(n) SC:O(h) h:log n for random binary tree, h: n for degenerated binary trees 
	public static int treeDepth1(BTreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right== null) return 1;
		int lh = treeDepth1(root.left);
		int rh = treeDepth1(root.right);
		return Math.max(lh,rh) + 1;
	}
	
	//TC:O(n) SC:O(n)  <=n/2 slots
	public static int treeDepth2(BTreeNode root) {
		Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
		queue.add(root);
		queue.add(null);
		int depth = 0;
		while (!queue.isEmpty()) {
			BTreeNode current = queue.remove();
			if (current == null) {
				++depth;
				if (!queue.isEmpty())
					queue.add(null);
			} else {
				//System.out.print(current.data + " ");
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
		}
		return depth;
	}
	
	//TC:O(n) SC:O(1) use some of the null links of given tree
	public static int treeDepth3(BTreeNode root) {
		return 0;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println("Building random binary tree..");
		RBinaryTree tree1 = new RBinaryTree();
		BTreeNode tmp = tree1.randomTree(n);
		System.out.println("Tree construction completed.");
		//tree1.display();
		System.out.println(treeDepth1(tmp));
		System.out.println(treeDepth2(tmp));
	}

}
