package com.alg.top20.bst;

public class ISBST {

	private static boolean auxBST1(TreeNode current, TreeNode prev) {
		if (current == null) return true;
		boolean ret = auxBST1(current.left, prev);
		if (ret == false)
			return false;
		if (prev != null) {
			int cmp = prev.data.compareTo(current.data);
			if (cmp > 0)
				return false;
		}
		prev = current;
		return auxBST1(current.right, prev);
	}

	public static boolean isBST1(TreeNode current) {
		return auxBST1(current, null);
	}
	
	private static boolean auxBST2(TreeNode current, int min, int max) {
		if (current == null) return true;
		if(! (current.data > min && current.data < max)) return false;  
		boolean ret = auxBST2(current.left, min, current.data);
		if (ret == false) return false;		
		return auxBST2(current.right, current.data, max);
	}

	public static boolean isBST2(TreeNode current) {
		return auxBST2(current, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
