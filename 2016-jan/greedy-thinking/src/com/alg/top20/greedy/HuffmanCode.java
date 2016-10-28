package com.alg.top20.greedy;

import java.util.PriorityQueue;

public class HuffmanCode {
	
	static class TreeNode implements Comparable<TreeNode> {
		Character data;
		Integer freq;
		TreeNode left;
		TreeNode right;
		public TreeNode(Character data, Integer freq) {
			this.data = data;
			this.freq = freq;
		}
		@Override
		public int compareTo(TreeNode obj2) {
			return this.freq - obj2.freq;
		}

	}
	
	public static TreeNode buildTree(char[] chars, int[] freqs) {
			PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>();
			for (int i = 0; i < chars.length; ++i) {
				pq.add(new TreeNode(chars[i],freqs[i]));
			}
			while (pq.size() > 1) {
				TreeNode small1 = pq.remove();
				TreeNode small2 = pq.remove();
				TreeNode current = new TreeNode('$',small1.freq + small2.freq);
				current.left = small1;
				current.right = small2;
				pq.add(current);
			}
			return pq.remove();
	}
	
	public static void printCodes(TreeNode current,String code) {
		if(current.left == null && current.right == null) {
			System.out.println(current.data + ":"+code);
			return;
		}
		printCodes(current.left,code+"0");
		printCodes(current.right, code+"1");
	}
	public static void main(String[] args) {
		char[] chars = {'a','b','c','d','e'};
		int[] freqs =  {6,5,8,4,40};	
		TreeNode root = buildTree(chars,freqs);
		printCodes(root,"");
	}

}
