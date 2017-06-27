package com.alg.top20.trees;
import java.util.LinkedList;
import java.util.Queue;


public class LongestRootLeafPath {

	public static int treeDepth1(TreeNode root) {
		MyInteger maxLen = new MyInteger();
		auxDepth(root, 0, maxLen);
		return maxLen.get();
	}
	private static void auxDepth(TreeNode root, int prefix, MyInteger maxLen) {
		if(root == null) return;
		if(root.left == null  && root.right == null) {
			maxLen.set(Math.max(maxLen.get(), prefix+1));
			return;
		}
		auxDepth(root.left, prefix+1, maxLen);
		auxDepth(root.right, prefix+1, maxLen);
	}
	
	public static int treeDepth2(TreeNode root) {
		if(root == null) return 0;
		int lh = treeDepth1(root.left);
		int rh = treeDepth1(root.right);
		return Math.max(lh, rh) + 1;
	}
	public static int treeDepth3(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int nlevels = 0;
		while(true) {
			TreeNode tmp = q.remove();
			if(tmp == null) {
				++nlevels;
				if(! q.isEmpty())
					q.add(null);
				else 
					break;
			} else {
				if(tmp.left != null) q.add(tmp.left);
				if(tmp.right != null) q.add(tmp.right);
			}
		}
		return nlevels;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(treeDepth1(root));
		System.out.println(treeDepth2(root));
	}

}
