package com.collections;

/**
 * @author Srinivas Reddy
 * @email srinivas96alluri@gmail.com
 */

public class BitSet {

	byte[] array;

	public BitSet(int size) {
		array = new byte[(int) Math.ceil(size / 8.0)];
	}

	public boolean get(int bitPos) {

		// Go to the bit position in byte(8 bits) array
		// Prepare by left shifting it appropriate times
		return ((array[(bitPos - 1) / 8] & (1 << ((bitPos - 1) % 8))) != 0);
	}

	public void set(int bitPos) {
		// Set the bit position to 1 by logical OR operation on byte array
		array[((bitPos - 1) / 8)] |= (1 << (bitPos - 1) % 8);
	}

	public void clear(int bitPos) {

		// Set the bit position to 0(1's complement) by logical AND operation on
		// byte array
		// Because 1 0 => 0 and 1 1 => 1 so we will not loose any other bit data
		array[((bitPos - 1) / 8)] &= ~(1 << (bitPos - 1) % 8);
	}

}
