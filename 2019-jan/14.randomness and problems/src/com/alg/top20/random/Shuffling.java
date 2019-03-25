package com.alg.top20.random;

import java.util.Arrays;
import java.util.Random;

public class Shuffling {

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	public static void shuffle1(int[] in) {
		Random r = new Random();
		for(int i = 0; i < in.length; ++i) {
			int tmp = r.nextInt(in.length);
			swap(in, i, tmp);
		}
	}
	
	public static void shuffle2(int[] in) {
		MyRandom r = new MyRandom();
		for(int i = 0; i < in.length; ++i) {
			int tmp = r.nextInt(i, in.length);
			swap(in, i, tmp);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < in.length; ++i)
			in[i] = i+1;
		//shuffle1(in);
		for(int i = 0;  i < 100; ++i) {
			shuffle1(in);
			System.out.println(Arrays.toString(in));
		}
	}

}
