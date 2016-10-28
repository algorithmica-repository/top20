package com.alg.top20.trees.depth;

import java.util.Random;

import com.alg.top20.trees.size.TreeNode;
import com.alg.top20.trees.size.TreeSize;

public class Driver {
	
	private static void add(TreeNode root, TreeNode tmp) {
		Random r = new Random();
		while (true) {
			if (r.nextInt(2) == 0) {
				if (root.left == null) {
					root.left = tmp;
					return;
				} else {
					root = root.left;
				}
			} else {
				if (root.right == null) {
					root.right = tmp;
					return;
				} else {
					root = root.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);

		System.out.println("Constructing binary tree");
		TreeNode root = new TreeNode(0);
		for (int i = 1; i < size; ++i) {
			TreeNode tmp = new TreeNode(i);
			add(root, tmp);
		}

		System.out.println("Completed");
		//System.out.println(treeSize1(root));
		System.out.println(TreeDepth.treeDepth1(root));
	}
}
