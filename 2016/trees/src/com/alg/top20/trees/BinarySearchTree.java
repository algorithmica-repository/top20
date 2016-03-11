package com.alg.top20.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class BinarySearchTree {
	
	private TreeNode root;

	class TreeNode {
		Integer data;
		TreeNode left;
		TreeNode right;

		TreeNode(Integer key) {
			data = key;
		}
	}
	
	class MyInteger {
		private int count;
		public void incr() {			
			++count;
		}
		public int get() {
			return count;
		}
	}

	public boolean contains(Integer key) {
		TreeNode current = root;		
		int res;
		while (current != null) {
			res = key.compareTo(current.data);
			if(res == 0) return true;
			if (res < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	
	public void add(Integer key) {
		TreeNode current = root;
		if (current == null)
			root = new TreeNode(key);
		else {
			int res = 0;
			TreeNode parent = null;
			while (current != null) {
				res = key.compareTo(current.data);
				parent = current;
				if (res < 0) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if(res  < 0) parent.left = new TreeNode(key);
			else parent.right = new TreeNode(key);
		}
	}

	public void generateBST(int n) {
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			add(r.nextInt(1000) + 1);
		}
	}
	
	private TreeNode auxSelect(TreeNode current, int k, MyInteger count) {
		if(current == null) return null;
		TreeNode tmp = auxSelect(current.left, k, count);
		if(tmp != null) return tmp;
		count.incr();
		if(count.get() == k) return current;
		return auxSelect(current.right, k, count);
	}
	
	public Integer select(int k) {
		MyInteger count = new MyInteger();
		TreeNode res = auxSelect(root, k, count);
		if(null != res) return res.data;
		return null;
	}
	
	public void sortedDisplayNR() {
		TreeNode current = root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(true) {
			while(current!=null) {
				st.push(current);
				current = current.left;
			}
			if(st.isEmpty()) break;
			current = st.pop();
			System.out.println(current.data);
			current = current.right;
		}
	}
	private void auxDisplay(TreeNode current) {
		if(current == null) return;
		auxDisplay(current.left);
		System.out.print(current.data + " ");
		auxDisplay(current.right);
	}
	public void sortedDisplay() {
		auxDisplay(root);
	}

	public void display() {
		TreeNode current = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(current);
		q.add(null);
		while (!q.isEmpty()) {
			current = q.remove();
			if(current!=null) System.out.print(current.data + " ");
			if (current == null) {
				System.out.println();
				if (!q.isEmpty())
					q.add(null);
				continue;
			}
			if (current.left != null)
				q.add(current.left);
			if (current.right != null)
				q.add(current.right);
		}

	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.generateBST(10);
		//tree.display();
		//System.out.println();
		//System.out.println(tree.contains(100));
		tree.sortedDisplay();
		//System.out.println();
		//System.out.println(tree.select(3));
	}
}
