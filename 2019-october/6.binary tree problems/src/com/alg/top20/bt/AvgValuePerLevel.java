package com.alg.top20.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgValuePerLevel {

	public static List<Float> avgValuePerLevel1(TreeNode root) {
		List<Float> res = new ArrayList<Float>();
		int lcount = 0;
		int lsum = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp == null) {
				float avg = (float) lsum / lcount;
				res.add(avg);
				//System.out.println(avg);
				lsum = 0;
				lcount = 0;
				if (!q.isEmpty())
					q.add(null);
			} else {
				++lcount;
				lsum += tmp.data;
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		System.out.println(avgValuePerLevel1(root));
	}

}
