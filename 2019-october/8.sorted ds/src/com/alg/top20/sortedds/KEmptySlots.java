package com.alg.top20.sortedds;

import java.util.BitSet;
import java.util.TreeSet;

public class KEmptySlots {

	public static int kemptySlots1(int[] in, int k) {
		BitSet bset = new BitSet(in.length);
		for (int i = 0; i < in.length; ++i) {
			int pos = in[i];
			for (int current = pos; current >= 0 && current < pos - k; --current) {
				if (bset.get(current) == true && pos - current - 1 == k)
					return i + 1;
			}
			for (int current = pos; current < in.length && current < pos + k; ++current) {
				if (bset.get(current) == true && current - pos - 1 == k)
					return i + 1;
			}
			bset.set(pos);
		}
		return -1;

	}

	public static int kemptySlots2(int[] in, int k) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			int pos = in[i];
			Integer floor = tset.floor(pos);
			if (floor != null && pos - floor - 1 == k)
				return i + 1;
			Integer ceil = tset.ceiling(pos);
			if (ceil != null && ceil - pos - 1 == k)
				return i + 1;
			tset.add(pos);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
