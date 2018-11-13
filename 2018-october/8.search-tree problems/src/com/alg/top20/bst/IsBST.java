package com.alg.top20.bst;

class Result {
	boolean flag;
	int min;
	int max;
	public Result(boolean flag, int min, int max) {
		super();
		this.flag = flag;
		this.min = min;
		this.max = max;
	}
	public Result(boolean flag) {
		super();
		this.flag = flag;
	}
	
}

class MyPrev {
	TreeNode prev;
	public MyPrev(TreeNode prev) {
		this.prev = prev;
	}
}
public class IsBST {

	public static boolean isBST1(TreeNode root) {
		MyPrev global = new MyPrev(null);
		return auxBST1(root, global);
	}
	private static boolean auxBST1(TreeNode root, MyPrev global) {
		if(root == null) return true;
		boolean left = auxBST1(root.left, global);
		if(left == false) return false;
		if(global.prev != null && root.data < global.prev.data) return false;
		global.prev = root;
		return auxBST1(root.right, global);
	}
	
	public static boolean isBST2(TreeNode root) {
		Result res = auxBST2(root);
		return res.flag;
	}
	
	private static Result auxBST2(TreeNode root) {
		Result left, right;
		//if(root == null) return new Result(true, )
		if(root.left == null && root.right == null) return new Result(true, root.data, root.data);
		if(root.left == null) 
			left = new Result(true, root.data, root.data);
		else {
			left = auxBST2(root.left);
			if(left.flag == false) return new Result(false);
		}
		if(root.right == null) 
			right = new Result(true, root.data, root.data);
		else {
			right = auxBST2(root.right);
			if(right.flag == false) return new Result(false);
		}
		boolean tmp = root.data >= left.max && root.data <= right.min;
		if(tmp == false)
			return new Result(false);
		else 			
			return new Result(true, left.min, right.max);
	}
	
	public static boolean isBST3(TreeNode root) {
		return auxBST31(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean auxBST31(TreeNode root, int min, int max) {
		if(root == null) return true;
		boolean tmp = root.data > min && root.data < max;
		if(tmp == false) return false;
		boolean left = auxBST31(root.left, min, root.data);
		if(left == false) return false;
		return auxBST31(root.right, root.data, max);
	}
	
	private static boolean auxBST32(TreeNode root, int min, int max) {
		if(root == null) return true;
		return root.data > min && root.data < max && 
		 auxBST32(root.left, min, root.data) &&
		auxBST32(root, root.data, max);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BSTUtils.createRandomBST(n);
		BSTUtils.displayTree(root);
		System.out.println(isBST1(root));
		System.out.println(isBST2(root));
		System.out.println(isBST3(root));
	}

}
