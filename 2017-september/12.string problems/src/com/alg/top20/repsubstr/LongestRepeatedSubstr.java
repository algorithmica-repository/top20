package com.alg.top20.repsubstr;

import java.util.HashSet;
import java.util.Set;

import com.alg.top20.trie.ITrie;
import com.alg.top20.trie.TST;

public class LongestRepeatedSubstr {

	//TC:O(n ^ 3)
	//SC:O(n ^ 3)
	public static String longestRepSubstr1(String s) {
		Set<String> set = new HashSet<String>();
		int maxlen = 0;
		String res = "";
		for(int i = 0; i < s.length(); ++i) {
			for(int j = i; j < s.length(); ++j) {
				String tmp = s.substring(i,j+1);
				if(set.contains(tmp)) {
					if(j-i+1 > maxlen) {
						maxlen = j-i+1;
						res = tmp;
					}
				} else
					set.add(tmp);
			}
		}		
		return res;
	}
	//TC:O(n ^ 3)
	//SC:O(1)
	public static String longestRepSubstr2(String s) {
		int maxlen = 0;
		int sind = -1;
		for(int i = 0; i < s.length()-1; ++i) {
			for(int j = i + 1; j < s.length(); ++j) {
				int clen = findCommonPrefixLength(s, i, j);
				if(clen > maxlen) {
					 maxlen = clen;
					 sind = i;
				}
			}
		}
		return s.substring(sind, sind+maxlen);
	}
	public static int findCommonPrefixLength(String s, int i, int j) {
		int count = 0;
		while(j < s.length()) {
			if(s.charAt(i) == s.charAt(j)) {
				++count;
				++i;
				++j;
			}
			else 
				break;
		}
		return count;
	}
	
	//TC:O(n ^ 2)
	//SC:O(n ^ 2)
	public static String longestRepSubstr3(String s) {
		ITrie trie = new TST();
		int maxlen = 0;
		String res = "";
		for(int i = 0; i < s.length(); ++i) {
			String tmp = s.substring(i);
			int pr_len = trie.findLongestPrefix(tmp);
			if(pr_len > maxlen) {
				maxlen = pr_len;
				res = tmp.substring(0, pr_len);
			} 
			trie.add(tmp);
		}
		return res;
	}
	
	public static void sort_suffixes(String s, int[] sa) {
		
	}
	//TC:O(n^2 log n)
	//SC:O(n)
	public static String longestRepSubstr4(String s) {
		int maxlen = 0;
		int sind = -1;
		int[] sa = new int[s.length()];
		//O(n)
		for(int i = 0; i < s.length(); ++i)
			sa[i] = i;
		//O(n^2 log n)
		sort_suffixes(s, sa);
		//O(n^2)
		for(int i = 0; i < s.length()-1; ++i) {
			int clen = findCommonPrefixLength(s, sa[i], sa[i+1]);
			if(clen > maxlen) {
				 maxlen = clen;
				 sind = i;
			}	
		}
		return s.substring(sind, sind+maxlen);
	}
	public static void main(String[] args) {
		//System.out.println(longestRepSubstr1(args[0]));
		System.out.println(longestRepSubstr2(args[0]));
		System.out.println(longestRepSubstr3(args[0]));
	}

}
