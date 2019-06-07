package com.alg.top20.bt;

import java.util.LinkedList;
import java.util.Queue;

public class PerLevelSum {

	public static void levelSum(BTNode root) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		q.add(null);
		int lsum = 0;
		while (!q.isEmpty()) {
			BTNode tmp = q.remove();
			if (tmp == null) {
				System.out.println(lsum);
				lsum = 0;
				if(! q.isEmpty())
					q.add(null);
			} else {
				lsum += tmp.data;
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BTNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		levelSum(root);
	}

}
