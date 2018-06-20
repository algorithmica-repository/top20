package com.alg.top20.ds;

import java.util.TreeSet;

public class KEmptySlots {

	public static int kemptySlots1(int[] flowers, int k) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < flowers.length; ++i) {
			Integer prev_blooming = set.floor(flowers[i]);
			Integer next_blooming = set.ceiling(flowers[i]);
			if(prev_blooming != null && flowers[i]-prev_blooming-1 == k)
				return i+1;
			if(next_blooming != null && next_blooming-flowers[i]-1 == k)
				return i+1;	
			set.add(flowers[i]);
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
