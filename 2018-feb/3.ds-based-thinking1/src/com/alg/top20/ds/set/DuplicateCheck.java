package com.alg.top20.ds.set;

import java.util.BitSet;
import java.util.HashSet;

public class DuplicateCheck {

	public static boolean checkDuplicate1(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < in.length; ++i) {
			if(!hset.add(in[i])) return true;
		}
		return false;
	}
	
	public static boolean checkDuplicate(int[] in) {
		BitSet bset = new BitSet(1<<31);
		for(int i = 0; i < in.length; ++i) {
			if(bset.get(in[i])) return true;
			bset.set(in[i]);
		}
		return false;
	}
}
