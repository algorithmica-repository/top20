package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class LongestRootToLeafPath {

	public static int longestRLpath1(BTNode root) {
		MyInteger gmax = new MyInteger(0);
		auxlongestRLPath1(root, 1, gmax);
		return gmax.get();
	}
	private static void auxlongestRLPath1(BTNode root, int plength, MyInteger gmax) {
		if(root == null) return;
		if(root.left == null && root.right == null)  {
			if(plength > gmax.get())
				gmax.set(plength);
			return;
		}
		auxlongestRLPath1(root.left, plength+1, gmax);
		auxlongestRLPath1(root.right, plength+1, gmax);
	}
	
	public static int longestRLpath2(BTNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int lp = longestRLpath2(root.left);
		int rp = longestRLpath2(root.right);
		return Math.max(lp, rp) + 1;
	}
	
	public static int longestRLpath3(BTNode root) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		q.add(null);
		int lcount = 0;
		while (!q.isEmpty()) {
			BTNode tmp = q.remove();
			if (tmp == null) {
				++lcount;
				if(! q.isEmpty())
					q.add(null);
			} else {			
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return lcount;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(longestRLpath1(root));
		System.out.println(longestRLpath2(root));
		System.out.println(longestRLpath3(root));

		
	}

}
