package com.alg.top20.bt;

public class SerDePreIn {

	public static BTNode deserialize(int[] in, int[] pre) {
		MyInteger index = new MyInteger(0);
		return auxDeserialize(in, pre, l, r, index);
	}
	private static BTNode auxDeserialize(int[] in, int[] pre, int l, int r, MyInteger index) {
		if(l > r) return null;
		BTNode root = new BTNode(pre[index.get()]);
		int p = findPosition(in, pre[index.get()]);
		index.incr();
		root.left = auxDeserialize(in, pre, l, p-1, index);
		root.right = auxDeserialize(in, pre, p+1, r, index);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
