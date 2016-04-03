package com.alg.top20.bitset;

public class TestBitSet {

	public static void main(String[] args) {
		BitSet bs = new BitSet(16);
		bs.display();
		bs.set(2);
		bs.display();
		bs.set(7);
		bs.display();
		bs.set(8);
		bs.display();
		System.out.println(bs.get(8));
		System.out.println(bs.get(7));
		System.out.println(bs.get(15));
		bs.clear(8);
		bs.display();
	}

}
