package com.alg.top20.bitset;

public class BitSet {
	private byte[] array;
	private int size;

	public BitSet(int size) {
		array = new byte[(size + 7) / 8];
		this.size = size;
	}

	public boolean get(int bit) {
		int ind = (bit - 1) / 8;
		int k = (bit % 8 == 0) ? 8 : (bit % 8);
		if ((array[ind] & 1 << (k - 1)) != 0)
			return true;
		return false;
	}

	public void set(int bit) {
		int ind = (bit - 1) / 8;
		int k = (bit % 8 == 0) ? 8 : (bit % 8);
		array[ind] |= (1 << (k - 1));
	}

	public void clear(int bit) {
		int ind = (bit - 1) / 8;
		int k = (bit % 8 == 0) ? 8 : (bit % 8);
		array[ind] &= ~(1 << (k - 1));
	}

	public void display() {
		for (int i = array.length - 1; i >= 0; --i) {
			int mask = 0x80;
			for (int j = 0; j < 8; ++j) {
				if ((array[i] & mask) == 0)
					System.out.print("0");
				else
					System.out.print("1");
				mask = mask >>> 1;
			}
			System.out.print(" ");
		}
		System.out.println();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.gc();
		System.out.println(r.freeMemory());
		BitSet bs = new BitSet(1000000000);
		System.out.println(r.freeMemory());
		/*bs.display();
		bs.set(8);
		bs.display();
		bs.set(1);
		bs.display();
		bs.set(16);
		bs.display();
		bs.set(32);
		bs.set(31);
		bs.display();*/
	}

}
