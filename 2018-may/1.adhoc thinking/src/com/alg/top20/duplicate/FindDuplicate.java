package com.alg.top20.duplicate;
import java.util.Arrays;
import java.util.BitSet;

public class FindDuplicate {

	public static int findDuplicate1(int[] in) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return 0;
	}
	public static int findDuplicate2(int[] in) {
		Arrays.sort(in);
		for(int i = 1; i < in.length; ++i) {
			if(in[i] == in[i-1]) return in[i];
		}
		return  0;
	}
	
	public static int findDuplicate3(int[] in) {
		BitSet bset = new BitSet(in.length);
		for(int i = 0; i < in.length; ++i) {
			if(bset.get(in[i]) == true)
				return in[i];
			else
				bset.set(in[i]);
		}
		return 0;
	}
	
	public static int findDuplicate4(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			int tmp = Math.abs(in[i]);
			if(in[tmp] < 0)
				return tmp;
			else
				in[tmp] *= -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		//testcase1
		int n = Integer.parseInt(args[0]); 
		int[] in = new int[n];
		for(int i = 0; i < n-1; ++i)
			in[i] = n-1-i;
		in[n-1] = n-1;
		boolean debug = Boolean.parseBoolean(args[1]);
		if(debug == true)
			System.out.println(Arrays.toString(in));
		System.out.println(findDuplicate4(in));
	}

}
