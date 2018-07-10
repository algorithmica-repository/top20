package com.alg.top20.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class TreeSet implements ISortedSet {
	private BTreeNode root;
	private int size;
	
	//TC:O(h) if duplicate exists return null otherwise return non-null value
	private BTreeNode auxAdd(BTreeNode current, Integer key) {
		BTreeNode left, right;
		if(current == null) {
			++size;
			return new BTreeNode(key);
		}
		int res = key.compareTo(current.data);
		if(res == 0)  return null;
		if(res < 0) {
			left = auxAdd(current.left, key);
			if(left == null) return null;
			else {
				++current.lst_size;
				current.left = left;
			}
		}
		else {
			right = auxAdd(current.right, key);
			if(right == null) return null;
			else 
				current.right = right;
		}
		return current;
	}
	public boolean add(Integer key) {
		BTreeNode res = null;
		if(root == null)
			root = auxAdd(root, key);
		else
			res = auxAdd(root, key);
		if(res == null) return false;
		return true;
	}
	//O(h)
	/*public boolean add(Integer key) {
		BTreeNode current = root;
		if(root == null) {
			root = new BTreeNode(key);
			++size;
			return true;
		}
		while (true) {
			int res = key.compareTo(current.data);
			if(res == 0) return false;
			if (res < 0) {
				++current.lst_size;
				if (current.left == null) {
					current.left = new BTreeNode(key);
					break;
				} else
					// otherwise move to left subtree
					current = current.left;
			} else {
				if (current.right == null) {
					current.right = new BTreeNode(key);
					break;
				} else
					current = current.right;
			}
		}
		++size;
		return true;
	}
*/
	//O(h)
	public boolean contains(Integer key) {
		BTreeNode current = root;		
		while(current != null) {
			int res = key.compareTo(current.data);
			if(res == 0) return true;
			if(res < 0) current = current.left;
			else current = current.right;
		}
		return false;
	}

	@Override
	public boolean remove(Integer key) {
		
		return false;
	}

	//O(1)
	public int size() {
		return size;
	}

	//O(n)
	public void display() {
		Queue<BTreeNode> queue = new LinkedList<BTreeNode>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			BTreeNode current = queue.remove();
			if (current == null) {
				System.out.println();
				if (!queue.isEmpty())
					queue.add(null);
			} else {
				System.out.print("(" + current.data + "," + current.lst_size+")");
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
		}

	}

	//TC:O(h)
	public Integer findMin() {
		BTreeNode current = root;
		if(root == null) return null;
		while(current.left != null)
			current = current.left;
		return current.data;
	}

	//TC:O(n)   SC:O(h) use inorder traversal
	private Integer auxSelect1(int k) {
		BTreeNode current = root;
		Stack<BTreeNode> stack = new Stack<BTreeNode>();
		int count = 0;//
		while (true) {
			while (current != null) {		
				stack.push(current);
				current = current.left;
			}
			if(stack.isEmpty()) break;
			current = stack.pop();
			//System.out.print(current.data+ " ");
			if(++count == k) return current.data;
			current = current.right;
		}
		return null;
	}

	//TC:O(h)   SC:O(1) 
	private Integer auxSelect2(int k) {		
		BTreeNode current = root;
		
		while (current != null) {
			if (k == current.lst_size + 1)
				return current.data;
			if (k < current.lst_size + 1)
				current = current.left;
			else {
				k = k - (current.lst_size + 1);
				current = current.right;				
			}
		}
		return null;		
	}
	public Integer select(int k) {
		//System.out.println("inorder start");
		//System.out.println(k);
		//Integer res = auxSelect1(k);
		Integer res = auxSelect2(k);
		//System.out.println("inorder complete");
		return res;
	}

}
