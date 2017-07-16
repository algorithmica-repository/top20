package com.alg.top20.rangequery;
import java.util.Arrays;
import java.util.Random;

public class RangeSum2 {
	private int[] in;
	private int[] segment_tree;

	//todo: find the next highest power of 2 for in.length
	public RangeSum2(int[] in) {
		this.in = in;
		this.segment_tree = new int[2*in.length];
	}

	// O(n)
	public void buildSegmentTree() {
		for (int i = 0; i < in.length; ++i) {
			segment_tree[i + in.length] = in[i];
		}
		for (int i = in.length - 1; i > 0; --i) {
			segment_tree[i] = segment_tree[2 * i] + segment_tree[2 * i + 1];
		}
	}

	// O(log n)
	public void update(int i, int val) {
		int tmp_ind = i + in.length;
		segment_tree[tmp_ind] = val;
		while (tmp_ind > 1) {
			if (tmp_ind % 2 == 1)
				segment_tree[tmp_ind / 2] = segment_tree[tmp_ind]
						+ segment_tree[tmp_ind - 1];
			else
				segment_tree[tmp_ind / 2] = segment_tree[tmp_ind]
						+ segment_tree[tmp_ind + 1];
			tmp_ind = tmp_ind / 2;
		}
	}

	// O(log n)
	public int range_sum(int i, int j) {
		int l = i + in.length;
		int r = j + in.length;
		int rsum = 0;
		while (l <= r) {
			if (l % 2 == 1) {
				rsum += segment_tree[l];
				++l;
			}
			if (r % 2 == 0) {
				rsum += segment_tree[r];
				--r;
			}
			l = l / 2;
			r = r / 2;
		}
		return rsum;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(n) + 1;
		}
		System.out.println(Arrays.toString(in));
		RangeSum2 rs = new RangeSum2(in);
		rs.buildSegmentTree();
		rs.update(1, 10);
		System.out.println(rs.range_sum(1, 5));
		rs.update(3, 5);
		rs.update(5, 7);
		System.out.println(rs.range_sum(2, 6));
	}

}
