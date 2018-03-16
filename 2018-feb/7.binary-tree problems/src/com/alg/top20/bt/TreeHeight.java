package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {

	public static int treeHeight1(TreeNode root) {
		if(root == null) return 0;		
		int lh = treeHeight1(root.left);
		int rh = treeHeight1(root.right);
		return Math.max(lh, rh) + 1;
	}
	
	public static int treeHeight2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int nlevel = 0;
		q.add(root);
		q.add(null);
		while(! q.isEmpty()) {
			TreeNode tmp = q.remove();
			if(tmp == null) {
				++nlevel;
				if(!q.isEmpty())
					q.add(null);
			} else {
				if(tmp.left != null) q.add(tmp.left);
				if(tmp.right != null) q.add(tmp.right);
			}
		}
		return nlevel;
	}
	
	public static int treeHeight3(TreeNode root){
		MyInteger maxDepth = new MyInteger(Integer.MIN_VALUE);
		auxTreeHeight(root, 0, maxDepth);
		return maxDepth.get();
	}
	private static void auxTreeHeight(TreeNode root, int depth, MyInteger maxDepth) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			maxDepth.set(Math.max(depth+1, maxDepth.get()));
			return;
		}
		auxTreeHeight(root.left, depth+1, maxDepth);
		auxTreeHeight(root.right, depth+1, maxDepth);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(treeHeight1(root));
		System.out.println(treeHeight2(root));
		System.out.println(treeHeight3(root));

	}

}
