package com.alg.top20.rangequery;
import java.util.Arrays;
import java.util.Random;

public class RangeSum1 {
	private int[] in;
	private int[] mem;
	private int segments;

	public RangeSum1(int[] in) {
		this.in = in;
		this.segments = (int) Math.ceil(Math.sqrt(in.length));
		this.mem = new int[segments];
	}

	// O(n)
	public void buildMemory() {
		for (int i = 0; i < in.length; ++i) {
			mem[i / segments] += in[i];
		}
	}

	// O(1)
	public void update(int i, int val) {
		mem[i / segments] = mem[i / segments] + val - in[i];
		in[i] = val;
	}

	// O(sqrt(n)) : fix the bugs
	public int range_sum(int i, int j) {
		int rs = 0;
		int start, end;
		for (start = i; start % segments != 0; ++start)
			rs += in[start];
		for (end = j; end % segments != 0; --end)
			rs += in[end];
		rs += in[end];
		int sb = start / segments;
		int eb = end - 1 / segments;
		if (sb != eb) {
			for (int k = sb; k <= eb; ++k)
				rs += mem[k];
		}
		return rs;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(n) + 1;
		}
		System.out.println(Arrays.toString(in));
		RangeSum1 rs = new RangeSum1(in);
		rs.buildMemory();
		rs.update(1, 10);
		System.out.println(rs.range_sum(1, 5));
		rs.update(3, 5);
		rs.update(5, 7);
		System.out.println(rs.range_sum(2, 6));
	}

}
