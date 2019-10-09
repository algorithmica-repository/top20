package com.alg.top20.array;

public class CountZeros {

	public static int count1(int[] in) {
		int i;
		for (i = 0; i < in.length; ++i) {
			if (in[i] != 0)
				break;
		}
		return i;
	}

	public static int count2(int[] in) {
		int left = 0, right = in.length - 1;
		while (right - left > 1) {
			int mid = (left + right) / 2;
			if (in[mid] == 0)
				left = mid;
			else
				right = mid - 1;
		}
		if (in[right] == 0)
			return right + 1;
		return left + 1;

	}

	public static void main(String[] args) {// TODO Auto-generated method stub

	}

}
