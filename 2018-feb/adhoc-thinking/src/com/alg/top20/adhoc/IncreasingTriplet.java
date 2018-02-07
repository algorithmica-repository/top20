package com.alg.top20.adhoc;

public class IncreasingTriplet {

	public static boolean hasIncrTriplet1(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			for(int j = i+1; j < in.length;++j) {
				if(in[j] < in[i]) continue;
				for(int k = j+1; k < in.length;++k) {
					if(in[k] > in[j]) return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasIncrTriplet2(int[] in) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i = 0; i < in.length; ++i) {
			if(in[i] < min1) min1 = in[i];
		
			else if(in[i] < min2) min2 = in[i];
			else return true;			
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
