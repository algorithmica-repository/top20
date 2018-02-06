package com.alg.top20.adhoc;
import java.util.Arrays;

public class FindDuplicate {

	// pair wise check
	public static int findDuplicate1(int[] in) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return -1;
	}
	
	// sort + scan
	public static int findDuplicate2(int[] in) {
		Arrays.sort(in);
		for (int i = 1; i < in.length; ++i) {
			if(in[i] == in[i-1]) return in[i];
		}
		return -1;
	}
	
	// in-place check
	public static int findDuplicate4(int[] in) {
		int element = -1;
		for (int i = 0; i < in.length; ++i) {
			element = Math.abs(in[i]);
			if(in[element] < 0) break;				
			in[element] *= -1;
		}
		//System.out.println(Arrays.toString(in));
		return element;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		//testcase1
		int i;
		for(i = 0; i < in.length-1; ++i)
			in[i] = i+1;
		in[i] = i;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(findDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 +"seconds");
	}

}
