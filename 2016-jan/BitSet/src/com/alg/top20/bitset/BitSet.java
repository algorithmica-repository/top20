package com.alg.top20.bitset;

public class BitSet {
	private byte[] array;
	
	public BitSet(int size) {
		double tmp = Math.ceil(size/8);
		array = new byte[(int)tmp];
	}

	public void set(int ind) {
		int byteno = ind/8;
		byte pattern = (byte)(1 << (ind%8));
		array[byteno] |= pattern;
	}
	
	public boolean get(int ind) {
		int byteno = ind/8;
		byte pattern = (byte)(1<<ind%8);
		if( (array[byteno] & pattern) == 0)
			return false;
		else return true;
	}
	
	public void clear(int ind) {
		int byteno = ind/8;
		byte pattern = (byte)~(1<<ind%8);
		array[byteno] &= pattern;
	}
	
	private void display_byte(byte b) {
		int[] out = new int[8];
		byte pattern = 1;
		//System.out.println(pattern);
		for(int i = 0; i < 8; ++i) {
			if((b & pattern) == 0) out[i] = 0;
			else out[i] = 1;
			pattern <<= 1;
		}
		for(int i = out.length -1; i >= 0; --i)
			System.out.print(out[i]);
	}
	
	public void display() {
		for(int i = array.length-1; i>=0; --i) {
			display_byte(array[i]);
		}
		System.out.println();
	}
}
