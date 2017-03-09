package com.alg.top20.trees;

import java.util.Stack;

public class RecToNonRecConversion {

	public static void rec1(BTreeNode current) {
		if (current == null)
			return;
		System.out.println(current.data);
		rec1(current.left);
	}

	public static void nonrec1(BTreeNode current) {
		while (current != null) {
			System.out.println(current.data);
			current = current.left;
		}
	}

	//TC:O(n) sc:O(h) process stack
	public static void rec2(BTreeNode current) {
		if (current == null)
			return;
		System.out.print(current.data+ " ");
		rec2(current.left);
		rec2(current.right);
	}

	//TC:O(n) SC:O(h)  stack from heap segment
	public static void nonRec2(BTreeNode current) {
		Stack<BTreeNode> stack = new Stack<BTreeNode>();
		while (true) {
			while (current != null) {
				System.out.print(current.data+" ");
				stack.push(current);
				current = current.left;
			}
			if(stack.isEmpty()) break;
			current = stack.pop().right;
		}
	}
	
	//TC:O(n) sc:O(h) process stack
	public static void rec3(BTreeNode current) {
		if (current == null) return;	
		rec3(current.left);
		System.out.print(current.data+ " ");
		rec3(current.right);
	}
	
	//TC:O(n) SC:O(h)  stack from heap segment
	public static void nonRec3(BTreeNode current) {
		Stack<BTreeNode> stack = new Stack<BTreeNode>();
		while (true) {
			while (current != null) {		
				stack.push(current);
				current = current.left;
			}
			if(stack.isEmpty()) break;
			current = stack.pop();
			System.out.print(current.data+" ");
			current = current.right;
		}
	}
	
	//TC:O(n) sc:O(h) process stack
	public static void rec4(BTreeNode current) {
		if (current == null) return;	
		rec4(current.left);
		rec4(current.right);
		System.out.print(current.data+ " ");
	}

	static class StackInfo {
		BTreeNode node;
		boolean flag;
		public StackInfo(BTreeNode node, boolean flag) {
			super();
			this.node = node;
			this.flag = flag;
		}
		
	}
	//TC:O(n) SC:O(h)  stack from heap segment
	public static void nonRec4(BTreeNode current) {
		Stack<StackInfo> stack = new Stack<StackInfo>();
		while (true) {
			while (current != null) {		
				stack.push(new StackInfo(current, false));
				current = current.left;
			}
			if(stack.isEmpty()) break;
			StackInfo tmp = stack.pop();
			if(tmp.flag == false) {
				tmp.flag = true;
				stack.push(tmp);
				current = tmp.node.right;
			} else {
				System.out.print(tmp.node.data+" ");
				//just to continue with pop statement
				current = null;
			}
		}
	}
	
	//TC:O(n) sc:O(h) process stack
	public static void rec5(BTreeNode current) {
		if (current == null) return;
		System.out.print(current.data+ " ");
		rec4(current.right);
		System.out.print(current.data+ " ");
		rec4(current.left);		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println("Building random binary tree..");
		RBinaryTree tree1 = new RBinaryTree();
		BTreeNode tmp = tree1.randomTree(n);
		System.out.println("Tree construction completed.");
		//tree1.display();
		rec4(tmp);
		System.out.println();
		nonRec4(tmp);
	}

}
