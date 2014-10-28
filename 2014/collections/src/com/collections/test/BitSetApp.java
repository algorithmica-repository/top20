package com.collections.test;

/**
 * @author	Srinivas Reddy
 * @email	srinivas96alluri@gmail.com
 */

import java.util.Random;

import com.collections.BitSet;

public class BitSetApp {
	public static void main(String[] args) {

		BitSet bitSet = new BitSet(256);

		Random rand = new Random();

		for (int index = 1; index <= 20; ++index) {
			int random = rand.nextInt(40);

			System.out.println("Ramdom numnber is = " + random);

			if (bitSet.get(random)) {
				System.out.println("\nDuplicate found = " + random);
				break;
			} else {
				bitSet.set(random);
			}
		}
	}
}
