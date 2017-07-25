package com.alg.top20.tt;
import java.util.Arrays;
import java.util.Random;


public class SecondSmallest {

	//comparisons: 2n - 3   (fill up the logic)
	public static int findSecondSmallest1(int[] in) {
		return 0;
	}
	//comparisons: n-1 + log n - 1 ~ (n + log n - 2)
	public static int findSecondSmallest2(int[] in) {
		//build tournament tree for a given array
		int[] segment_tree = new int[2*in.length];
		for (int i = 0; i < in.length; ++i) {
			segment_tree[i + in.length] = i;
		}
		for (int i = in.length - 1; i > 0; --i) {
			if(in[segment_tree[2*i]] < in[segment_tree[2*i+1]])
				segment_tree[i] = segment_tree[2 * i];
			else
				segment_tree[i] = segment_tree[2 * i + 1];
		}
		System.out.println(Arrays.toString(segment_tree));
		//replace first smallest with infinity
		int tmp_ind = segment_tree[1];
		in[tmp_ind] = Integer.MAX_VALUE;
		
		tmp_ind = tmp_ind + in.length;
		
		//readjust tournament tree to get second smallest at root
		while (tmp_ind > 1) {
			if (tmp_ind % 2 == 1) {
				if(in[segment_tree[tmp_ind]] < in[segment_tree[tmp_ind-1]])
					segment_tree[tmp_ind/2] = segment_tree[tmp_ind];
				else
					segment_tree[tmp_ind/2] = segment_tree[tmp_ind-1];
			}
			else {
				if(in[segment_tree[tmp_ind]] < in[segment_tree[tmp_ind+1]])
					segment_tree[tmp_ind/2] = segment_tree[tmp_ind];
				else
					segment_tree[tmp_ind/2] = segment_tree[tmp_ind+1];
			}
			tmp_ind = tmp_ind / 2;
		}
		return in[segment_tree[1]];		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(n) + 1;
		}
		System.out.println(Arrays.toString(in));
		System.out.println(findSecondSmallest2(in));
	}

}
