package com.alg.top20.strings;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.alg.top20.autocmpletion.ITrie;
import com.alg.top20.autocmpletion.TernarySearchTree;

public class LongestRepSubString {

	//TC:O(n ^ 3)
	public static int longRepSubstr1(String s) {
		int n = s.length();
		Set<String> hset = new HashSet<String>();
		for(int l = n-1; l >= 1; --l) {
			for(int i = 0; i <= n-l; ++i) {
				String tmp = s.substring(i, i+l);
				if(hset.contains(tmp))
					return l;
				else
					hset.add(tmp);
			}
			hset.clear();
		}
		return 0;
	}
	
	private static int findCommonPrefixLength(String s, int i, int j) {
		int common_len = 0;
		while(j < s.length()) {
			if(s.charAt(i++) == s.charAt(j++))
				++common_len;
			else
				break;
		}
		return common_len;
	}
	//TC:O(n ^ 3)
	public static int longRepSubstr2(String s) {
		int maxlen = Integer.MIN_VALUE;
		int n = s.length();
		for(int i = 0; i < n; ++i) {
			for(int j = i+1; j < n; ++j){
				int common_len = findCommonPrefixLength(s, i, j);
				maxlen = Math.max(common_len, maxlen);
			}
		}
		return maxlen;		
	}
	
	//TC:O(n * 26 * n)  suffix trie
	public static int longRepSubstr3(String s) {
		int maxlen = Integer.MIN_VALUE;
		int n = s.length();
		ITrie trie = new TernarySearchTree();
		for(int i = 0; i < n; ++i) {
				int common_len = trie.findCommonPrefixLength(s.substring(i));
				maxlen = Math.max(common_len, maxlen);
				trie.add(s.substring(i));
		}
		return maxlen;		
	}
	private static void sortSuffixes(int[] sa, String s) {
		
	}
	
	//TC:O(n ^ 2)  suffix array
	public static int longRepSubstr4(String s) {
		int n = s.length();
		int[] suffix_array = new int[n];
		for(int i = 0; i < n; ++i) 
			suffix_array[i] = i;
		
		sortSuffixes(suffix_array, s);
		
		int maxlen = Integer.MIN_VALUE;
		for(int i = 0; i < n-1; ++i) {
			int common_len = findCommonPrefixLength(s, suffix_array[i], suffix_array[i+1]);
			maxlen = Math.max(common_len, maxlen);
		}
		return maxlen;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		String s = "";		
		for(int i = 0; i < n; ++i) 
			s = s + (char)('a'+ r.nextInt(26));
		//System.out.println(s);
		//System.out.println(longRepSubstr1(s));
		System.out.println(longRepSubstr2(s));
		System.out.println(longRepSubstr3(s));
	}

}
