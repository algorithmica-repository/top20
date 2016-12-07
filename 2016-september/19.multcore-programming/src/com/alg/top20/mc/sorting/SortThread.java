package com.alg.top20.mc.sorting;

public class SortThread extends Thread {
	private int l;
	private int r;
	private int[] in;
	
	public SortThread(int[] in, int l, int r) {
		this.in = in;
		this.l = l;
		this.r = r;
	}
	
	private void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	public void run() {
		for(int i = l; i < r; ++i) {
			int min_index = i;
			for(int j = i+1; j <= r; ++j) {
				if(in[j] < in[min_index]) {
					min_index = j;
				}
			}
			swap(in, i, min_index);
			//System.out.println(Arrays.toString(in));
		}
	}
	

}
