package com.alg.top20.setmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void groupAnagrams1(String[] in) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
		for(String tmp: in) {
			char[] tmp_array = tmp.toCharArray();
			Arrays.sort(tmp_array);
			String sorted_key = new String(tmp_array);
			System.out.println(sorted_key);
			List<String> res = hmap.get(sorted_key);
			if(res == null) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(tmp);
				hmap.put(sorted_key, list);
			} else {
				res.add(tmp);
			}			
		}
		System.out.println(hmap);
	}
	public static void main(String[] args) {
		String[] in = {"cat","act","abc","cba","bac","def"};
		groupAnagrams1(in);
	}

}
