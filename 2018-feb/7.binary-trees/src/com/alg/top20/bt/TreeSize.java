package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSize {

	public static int treeSize1(TreeNode root) {
		if(root == null) return 0;		
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);
		return ls + rs + 1;
	}
	
	public static int treeSize2(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		int count = 0;
		while(true) {
			while(root != null) {
				++count;
				st.push(root);
				root = root.left;
			}
			if(st.empty()) break;
			root = st.pop().right;
		}
		return count;
	}
	
	public static int treeSize3(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int count = 0;
		q.add(root);
		while(! q.isEmpty()) {
			TreeNode tmp = q.remove();
			++count;
			if(tmp.left != null) q.add(tmp.left);
			if(tmp.right != null) q.add(tmp.right);
		}
		return count;
	}
	
	public static int treeSize4(TreeNode root) {
		int count = 0;
		while(root != null) { 
			if(root.left == null) {
				root = root.right;
				++count;
			} else {
				TreeNode tmp = root.left;
				while(tmp.right != null && tmp.right != root)
					tmp = tmp.right;
				if(tmp.right == null) {
					++count;
					tmp.right = root;
					root = root.left;
				} else {
					tmp.right = null;
					root = root.right;
				}
			} //end of outer else
		}//end of while
		return count;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(treeSize1(root));
		System.out.println(treeSize2(root));
		System.out.println(treeSize3(root));
		System.out.println(treeSize4(root));

		
	}
}
