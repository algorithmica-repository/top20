package com.alg.top20.setmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams1(String[] in) {
		return null;
	}
	
	public static List<List<String>> groupAnagrams2(String[] in) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String e: in) {
			char[] tmp = e.toCharArray();
			Arrays.sort(tmp);
			String signature = Arrays.toString(tmp);
			
			if(map.containsKey(signature)) {
				map.get(signature).add(e);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(e);
				map.put(signature, list);
			}
		}
		System.out.println(map.values());
		return null;
	}
	public static void main(String[] args) {
		String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams2(in);
	}

}
