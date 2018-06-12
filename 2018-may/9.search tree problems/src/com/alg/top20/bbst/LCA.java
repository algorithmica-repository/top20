package com.alg.top20.bbst;
import java.util.HashSet;


public class LCA {
	public static int findLCA1(BSTNode root, int p, int q) {
		HashSet<Integer> set = new HashSet<Integer>();

		int res = Integer.MIN_VALUE;
		BSTNode current = root;
		while (current != null) {
			set.add(current.data);
			if (p == current.data)
				break;
			if (p < current.data)
				current = current.left;
			else
				current = current.right;
		}
		current = root;
		while (current != null) {
			if(set.contains(current.data))
				res = current.data;
			if (q == current.data)
				break;
			if (q < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return res;
	}
	
	public static int findLCA2(BSTNode root, int p, int q) {
		BSTNode current = root;
		while (current != null) {
			if (p <= current.data && q >= current.data)
				return current.data;
			if (p < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return Integer.MIN_VALUE; 
	}
		
}
