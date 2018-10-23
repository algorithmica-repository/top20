package com.alg.top20.setmap;

import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams1(String[] in) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
		for(String tmp: in) {
			String sorted_key = Arrays.sort();
			List<String> res = hmap.get(sorted_key);
			if(res == null)
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
