package com.alg.top20.ds.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
		for(int i = 0; i < strs.length; ++i) {
			char [] c = strs[i].toCharArray();
		    Arrays.sort(c);
		    String key =  new String(c);
		    
		    if(hmap.containsKey(key))
		    	hmap.get(key).add(strs[i]);
		    else {
		    	List<String> tmp = new LinkedList<String>();
		    	tmp.add(strs[i]);
		    	hmap.put(key, tmp);
		    }
		}
		List<List<String>> res = new LinkedList<List<String>>();
		for(List<String> elem: hmap.values()) {
			res.add(elem);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
