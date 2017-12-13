package com.alg.top20.bittricks;

public class Operators {
	
	public static int set(int n, int k) {
		n = n | (1<<k-1);
		return n;
	}
	
	public static int clear(int n, int k) {
		n = n & ~(1<<k-1);
		return n;
	}
	
	public static int toggle(int n, int k) {
		n = n ^ (1<<k-1);
		return n;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitWiseUtilities.display(n);
		BitWiseUtilities.display(set(n, 20));
		BitWiseUtilities.display(toggle(n, 4));
		BitWiseUtilities.display(toggle(n, 3));
		BitWiseUtilities.display(clear(n, 2));
	}

}
