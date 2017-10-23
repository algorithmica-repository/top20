package com.alg.top20.basic.duplicate;

import java.util.BitSet;
import java.util.HashSet;

public class DuplicateNumber {

	//TC:O(n ^ 2)
	//SC:O(1)
	public static int findDuplicate1(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			for(int j = i+1; j < in.length; ++j) {
				if(in[i] == in[j]) return in[i];
			}
		}
		return -1;
	}
	//TC:O(n)
	//SC:O(n)	
	public static int findDuplicate2(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < in.length; ++i) {
			if(hset.contains(in[i]))
				return in[i];
			hset.add(in[i]);
		}
		return -1;
	}
	
	//TC:O(n)
	//SC:O(n)
	public static int findDuplicate3(int[] in) {
		BitSet bs = new BitSet(in.length);
		for(int i = 0; i < in.length; ++i) {
			if(bs.get(in[i]) == true)
				return in[i];
			bs.set(in[i]);
		}
		return -1;
	}
	//TC:O(n)
	//SC:O(1)
	public static int findDuplicate4(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			int ind = Math.abs(in[i]);
			if(in[ind] < 0)
				return ind;
			in[ind] *= -1;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
