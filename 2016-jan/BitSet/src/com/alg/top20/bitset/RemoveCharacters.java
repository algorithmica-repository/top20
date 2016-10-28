package com.alg.top20.bitset;

import java.util.Arrays;

public class RemoveCharacters {

	public static void removeCharacters(char[] rem, char[] in) {
		BitSet bs = new BitSet(26);
		int current, freeind;
		for(int i = 0; i < rem.length; ++i) {
			bs.set(rem[i] - 'a');
		}
		for(current = 0, freeind = 0; current < in.length; ++current) {
			if(bs.get(in[current] - 'a') == false)
				in[freeind++] = in[current];				
		}
		in[freeind] = '\0';
	}
	public static void main(String[] args) {
		char[] rem = new String("abc").toCharArray();
		char[] in = new String("algorithmica").toCharArray();
		removeCharacters(rem, in);
		System.out.println(Arrays.toString(in));
	}

}
