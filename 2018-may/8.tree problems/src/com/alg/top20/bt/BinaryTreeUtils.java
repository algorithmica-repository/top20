package com.alg.top20.bt;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTreeUtils {

	private static TreeNode add(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		TreeNode current = root, parent = null;
		while (current != null) {
			parent = current;
			if (Math.random() < 0.5) {
				if(current.left == null) {
					parent.left = new TreeNode(data);
					break;
				}
				current = current.left;
			}
			else {
				if(current.right == null) {
					parent.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}		
		return root;
	}

	public static TreeNode createBinaryTree(int n) {
		Random r = new Random();
		TreeNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = r.nextInt(n) + 1;
			root = add(root, data);
		}
		return root;
	}
	public static TreeNode createBinaryTree1(int n) {
		TreeNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = i + 1;
			root = add(root, data);
		}
		return root;
	}

	public static void displayTree1(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		TreeNode dummy = new TreeNode(-1);
		while(true) {
			TreeNode tmp = q.remove();
			if(tmp == null) {
				System.out.println();
				if(! q.isEmpty())
					q.add(null);
				else 
					break;
			} else {				
				System.out.print(tmp.data+ " ");
				if(tmp == dummy)  continue;
				if(tmp.left != null) q.add(tmp.left);
				else q.add(dummy);
				if(tmp.right != null) q.add(tmp.right);
				else q.add(dummy);
			}
		}	
	}

	public static void displayTree2(TreeNode root) {
		auxDisplay(root, 0, "Root");
	}
	private static void auxDisplay(TreeNode root, int nspaces, String type) {
		if(root == null) return;
		for(int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + ")");
		auxDisplay(root.left, nspaces + 4, "L");		
		auxDisplay(root.right, nspaces + 4, "R");
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);

	}
}

