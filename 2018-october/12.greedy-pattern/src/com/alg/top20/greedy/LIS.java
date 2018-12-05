package com.alg.top20.greedy;

import java.util.TreeSet;

public class LIS {

	//greedy choice
	public static int lis(int[] in) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for(int x:in) {
			Integer ceil = tset.ceiling(x);
			if(ceil != null) 
				tset.remove(ceil);
			tset.add(x);
		}
		return tset.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
