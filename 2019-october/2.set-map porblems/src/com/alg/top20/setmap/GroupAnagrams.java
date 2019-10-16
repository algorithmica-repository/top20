package com.alg.top20.setmap;

import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	public static void groupAnagrams1(String[] in) {
		boolean[] used = new boolean[in.length];
		for(int i = 0; i <  in.length; ++i) {
			if(used[i]) continue;
			System.out.println(in[i]);
			for(int j = i+1; j < in.length; ++j) {
				if(checkAnagram(in[i], in[j])) {
					System.out.println(in[j]);
					used[j] = true;
				}
			}
			System.out.println();
		}
	}
	
	public static void groupAnagrams3(String[] in) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
