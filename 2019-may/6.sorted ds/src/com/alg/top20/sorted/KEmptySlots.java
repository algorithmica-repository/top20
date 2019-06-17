package com.alg.top20.sorted;

import java.util.TreeSet;

public class KEmptySlots {

	public static int kemptyslots1(int[] in, int k) {
		return 0;
	}
	
	public static int kemptyslots2(int[] in, int k) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		tset.add(in[0]);
		for(int day = 1; day < in.length; ++day) {
			Integer f = tset.floor(in[day]);
			if(f != null && in[day]-f-1 == k) return day+1;
			Integer c = tset.ceiling(in[day]);
			if(c != null && c-in[day]-1 == k) return day+1;
			tset.add(in[day]);
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
