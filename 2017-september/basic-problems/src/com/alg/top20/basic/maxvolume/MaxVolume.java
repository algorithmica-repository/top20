package com.alg.top20.basic.maxvolume;

public class MaxVolume {

	//TC:O(n ^ 2)
	//SC:O(1)
	public static int findMaxVolume1(int[] in) {
		int maxVol = Integer.MIN_VALUE;
		for (int i = 0; i < in.length; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				int volume = (j - i) * Math.min(in[i], in[j]);
				maxVol = Math.max(maxVol, volume);
			}
		}
		return maxVol;
	}

	//TC:O(n)
	//SC:O(1)
	public static int findMaxVolume2(int[] in) {
		int maxVol = Integer.MIN_VALUE;
		int i = 0, j = in.length - 1;
		while (i < j) {
			int volume = (j - i) * Math.min(in[i], in[j]);
			maxVol = Math.max(maxVol, volume);
			if (in[i] < in[j])
				++i;
			else if (in[j] < in[i])
				--j;
			else {
				++i;
				--j;
			}
		}
		return maxVol;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
