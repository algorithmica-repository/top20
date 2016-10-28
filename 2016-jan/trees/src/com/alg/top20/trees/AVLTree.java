package com.alg.top20.trees;


public class AVLTree {

	
	private TreeNode root;

	class TreeNode {
		Integer data;
		TreeNode left;
		TreeNode right;
		int height;

		TreeNode(Integer key) {
			data = key;
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
	
	private int height(TreeNode current) {
		return current == null ? 0 : current.height;
	}
	
	public void add(Integer key) {
		root = auxAdd(root,key);
	}
	private TreeNode singleRotationR(TreeNode current) {
		//Fill the logic
		return null;
	}
	private TreeNode doubleRotationLR(TreeNode current) {
		//Fill the logic
		return null;
	}
	
	private TreeNode auxAdd(TreeNode current, Integer key) {
		if(current == null){
			current = new TreeNode(key);
			return current;
		}
		int res = key.compareTo(current.data);
		if(res < 0) {
			current.left = auxAdd(current.left, key);
			if(Math.abs(height(current.left) - height(current.right)) > 1) {
				int tmp = key.compareTo(current.left.data);
				if(tmp < 0 ){
					return singleRotationR(current);
				} else {
					return doubleRotationLR(current);
				}
			}
		} else {
			current.right = auxAdd(current.right, key);
			//Fill the logic
		}
		return current;
	}
	
}
