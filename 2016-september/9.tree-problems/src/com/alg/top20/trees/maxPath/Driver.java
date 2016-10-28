package com.alg.top20.trees.maxPath;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.print.attribute.standard.Finishings;

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

	public static void display(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		TreeNode dummy = new TreeNode(-1);

		while (true) {
			TreeNode tmp = queue.remove();
			if (tmp == null) {
				System.out.println();
				if (queue.isEmpty())
					break;
				queue.add(null);
				continue;
			} else {
				System.out.print(tmp.data + " ");
			}
			if (tmp != dummy) {
				if (tmp.left != null)
					queue.add(tmp.left);
				else
					queue.add(dummy);
				if (tmp.right != null)
					queue.add(tmp.right);
				else
					queue.add(dummy);
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
		display(root);
		// System.out.println(treeSize1(root));
		System.out.println(MaxPathSum.findMaxPath1(root));
		System.out.println(MaxPathSum.findMaxPath2(root));
	}
}
